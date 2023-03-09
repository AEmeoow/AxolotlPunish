package axolotlstudios.inventory;

import axolotlstudios.AxolotlPunish;
import axolotlstudios.config.AxolotlConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class banpage implements Listener {

    public static void openGUI(Player player, OfflinePlayer target) {

        if (!player.hasPermission("axolotlpunish.banpage.staff")) {
            player.sendMessage(AxolotlPunish.c(AxolotlConfig.PREFIX + "&cYou do not have permission to open the ban menu."));
            player.closeInventory();
            return;
        }

        Inventory gui = Bukkit.createInventory(player, AxolotlConfig.BAN_PAGE_SLOTS.asInt(), AxolotlConfig.BAN_PAGE_TITLE.asString());

        ItemStack unfairAdvantage = new ItemStack(AxolotlConfig.BAN_PAGE_UNFAIRADVANTAGE_MATERIAL.asMaterial());
        ItemMeta unfairAdvantageMeta = unfairAdvantage.getItemMeta();
        unfairAdvantageMeta.setDisplayName(AxolotlConfig.BAN_PAGE_UNFAIRADVANTAGE_DISPLAY_NAME.asStringC());
        unfairAdvantageMeta.setLore(AxolotlConfig.BAN_PAGE_UNFAIRADVANTAGE_LORE.asStringCList());
        unfairAdvantage.setItemMeta(unfairAdvantageMeta);
        gui.setItem(AxolotlConfig.BAN_PAGE_UNFAIRADVANTAGE_SLOT.asInt(), unfairAdvantage);


        ItemStack xray = new ItemStack(AxolotlConfig.BAN_PAGE_XRAY_MATERIAL.asMaterial());
        ItemMeta xrayMeta = xray.getItemMeta();
        xrayMeta.setDisplayName(AxolotlConfig.BAN_PAGE_XRAY_DISPLAY_NAME.asStringC());
        xrayMeta.setLore(AxolotlConfig.BAN_PAGE_XRAY_LORE.asStringCList());
        xray.setItemMeta(xrayMeta);
        gui.setItem(AxolotlConfig.BAN_PAGE_XRAY_SLOT.asInt(), xray);

        ItemStack abusinglitches = new ItemStack(AxolotlConfig.BAN_PAGE_ABUSING_GLITCHES_MATERIAL.asMaterial());
        ItemMeta abusinglitchesmeta = abusinglitches.getItemMeta();
        abusinglitchesmeta.setDisplayName(AxolotlConfig.BAN_PAGE_ABUSING_GLITCHES_DISPLAY_NAME.asStringC());
        abusinglitchesmeta.setLore(AxolotlConfig.BAN_PAGE_ABUSING_GLITCHES_LORE.asStringCList());
        abusinglitches.setItemMeta(abusinglitchesmeta);
        gui.setItem(AxolotlConfig.BAN_PAGE_ABUSING_GLITCHES_SLOT.asInt(), abusinglitches);

        ItemStack altgrinding = new ItemStack(AxolotlConfig.BAN_PAGE_ALT_GRINDING_MATERIAL.asMaterial());
        ItemMeta altgrindingmeta = altgrinding.getItemMeta();
        altgrindingmeta.setDisplayName(AxolotlConfig.BAN_PAGE_ALT_GRINDING_DISPLAY_NAME.asStringC());
        altgrindingmeta.setLore(AxolotlConfig.BAN_PAGE_ALT_GRINDING_LORE.asStringCList());
        altgrinding.setItemMeta(altgrindingmeta);
        gui.setItem(AxolotlConfig.BAN_PAGE_ALT_GRINDING_SLOT.asInt(), altgrinding);

        ItemStack communitymisconduct = new ItemStack(AxolotlConfig.BAN_PAGE_COMMUNITY_MISCONDUCT_MATERIAL.asMaterial());
        ItemMeta communitymisconductmeta = communitymisconduct.getItemMeta();
        communitymisconductmeta.setDisplayName(AxolotlConfig.BAN_PAGE_COMMUNITY_MISCONDUCT_DISPLAY_NAME.asStringC());
        communitymisconductmeta.setLore(AxolotlConfig.BAN_PAGE_COMMUNITY_MISCONDUCT_LORE.asStringCList());
        communitymisconduct.setItemMeta(communitymisconductmeta);
        gui.setItem(AxolotlConfig.BAN_PAGE_COMMUNITY_MISCONDUCT_SLOT.asInt(), communitymisconduct);


        ItemStack grayGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta grayGlassMeta = grayGlass.getItemMeta();
        grayGlassMeta.setDisplayName("");
        grayGlassMeta.setLocalizedName(" ");
        grayGlass.setItemMeta(grayGlassMeta);

        for (int i = 0; i < AxolotlConfig.BAN_PAGE_SLOTS.asInt(); i++) {
            if (gui.getItem(i) == null) {
                gui.setItem(i, grayGlass);
            }
        }

        player.openInventory(gui);
        AxolotlPunish.getInstance().getMenuManager().getTargetPlayer().put(player, target);

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        if (!AxolotlPunish.getInstance().getMenuManager().getTargetPlayer().containsKey(p)) {
            return;
        }

        if (!event.getView().getTitle().equals(AxolotlConfig.BAN_PAGE_TITLE.asString())) {
            return;
        }

        OfflinePlayer target = AxolotlPunish.getInstance().getMenuManager().getTargetPlayer().get(p);
        event.setCancelled(true);

        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null && clickedItem.hasItemMeta()) {
            ItemMeta clickedItemMeta = clickedItem.getItemMeta();

            if (event.getSlot() == AxolotlConfig.BAN_PAGE_UNFAIRADVANTAGE_SLOT.asInt()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("ban " + target.getName() + " " + AxolotlConfig.BAN_UNFAIRADV_TEMPLATE_NAME.asString());
                p.closeInventory();
            } else if (event.getSlot() == AxolotlConfig.BAN_PAGE_XRAY_SLOT.asInt()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("ban " + target.getName() + " " + AxolotlConfig.BAN_XRAY_TEMPLATE_NAME);
                p.closeInventory();
            } else if (event.getSlot() == AxolotlConfig.BAN_PAGE_ABUSING_GLITCHES_SLOT.asInt()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("ban " + target.getName() + " " + AxolotlConfig.BAN_ABUSINGLITCHES_TEMPLATE_NAME);
                p.closeInventory();
            } else if (event.getSlot() == AxolotlConfig.BAN_PAGE_ALT_GRINDING_SLOT.asInt()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("ban " + target.getName() + " " + AxolotlConfig.BAN_ALTGRINDING_TEMPLATE_NAME);
                p.closeInventory();
            } else if (event.getSlot() == AxolotlConfig.BAN_PAGE_COMMUNITY_MISCONDUCT_SLOT.asInt()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("ban " + target.getName() + " " + AxolotlConfig.BAN_COMMISCONDUCT_TEMPLATE_NAME);
                p.closeInventory();
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        AxolotlPunish.getInstance().getMenuManager().getTargetPlayer().remove(player);
    }
}

