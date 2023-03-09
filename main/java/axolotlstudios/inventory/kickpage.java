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

public class kickpage implements Listener {

    public static void openGUI(Player player, OfflinePlayer target) {

        if (!player.hasPermission("axolotlpunish.kickpage.staff")) {
            player.sendMessage(AxolotlPunish.c(AxolotlConfig.PREFIX + "&cYou do not have permission to open the kick menu."));
            player.closeInventory();
            return;
        }

        Inventory gui = Bukkit.createInventory(player, AxolotlConfig.KICK_PAGE_SLOTS.asInt(), AxolotlConfig.KICK_PAGE_TITLE.asString());

        ItemStack kickabuse1 = new ItemStack(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER1_MATERIAL.asMaterial());
        ItemMeta kickabusemeta1 = kickabuse1.getItemMeta();
        kickabusemeta1.setDisplayName(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER1_DISPLAY_NAME.asStringC()); // StringC is with colors, String is without colors
        kickabusemeta1.setLore(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER1_LORE.asStringCList());
        kickabuse1.setItemMeta(kickabusemeta1);
        gui.setItem(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER1_SLOT.asInt(), kickabuse1);

        ItemStack kickabuse2 = new ItemStack(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER2_MATERIAL.asMaterial());
        ItemMeta kickabusemeta2 = kickabuse2.getItemMeta();
        kickabusemeta2.setDisplayName(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER2_DISPLAY_NAME.asStringC()); // StringC is with colors, String is without colors
        kickabusemeta2.setLore(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER2_LORE.asStringCList());
        kickabuse2.setItemMeta(kickabusemeta2);
        gui.setItem(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER2_SLOT.asInt(), kickabuse2);

        ItemStack kickabuse3 = new ItemStack(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER3_MATERIAL.asMaterial());
        ItemMeta kickabusemeta3 = kickabuse3.getItemMeta();
        kickabusemeta3.setDisplayName(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER3_DISPLAY_NAME.asStringC()); // StringC is with colors, String is without colors
        kickabusemeta3.setLore(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER3_LORE.asStringCList());
        kickabuse3.setItemMeta(kickabusemeta3);
        gui.setItem(AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER3_SLOT.asInt(), kickabuse3);


        ItemStack grayGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta grayGlassMeta = grayGlass.getItemMeta();
        grayGlassMeta.setDisplayName("");
        grayGlassMeta.setLocalizedName(" ");
        grayGlass.setItemMeta(grayGlassMeta);

        for (int i = 0; i < AxolotlConfig.KICK_PAGE_SLOTS.asInt(); i++) {
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


        event.getView().getTitle(); //this

        if (!event.getView().getTitle().equals(AxolotlConfig.KICK_PAGE_TITLE.asString())) {
            return;

        }


        OfflinePlayer target = AxolotlPunish.getInstance().getMenuManager().getTargetPlayer().get(p);
        event.setCancelled(true);

        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null && clickedItem.hasItemMeta()) {
            // This is still good, make sure it's a custom item i guess.
            ItemMeta clickedItemMeta = clickedItem.getItemMeta();

            if (event.getSlot() == AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER1_SLOT.asInt()) { // now if you change the slot in the enum, it changes it everywhere
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("kick " + target.getName() + " " + AxolotlConfig.KICK_TIER_1TEMPLATE_NAME.asString());
                p.closeInventory();

            } else if (event.getSlot() == AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER2_SLOT.asInt()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("kick " + target.getName() + " " + AxolotlConfig.KICK_TIER_2TEMPLATE_NAME.asString());
                p.closeInventory();

            } else if (event.getSlot() == AxolotlConfig.KICK_PAGE_CHAT_ABUSE_TIER3_SLOT.asInt()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("kick " + target.getName() + " " + AxolotlConfig.KICK_TIER_3TEMPLATE_NAME.asString());
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
