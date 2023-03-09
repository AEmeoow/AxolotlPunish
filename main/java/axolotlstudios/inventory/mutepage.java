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

public class mutepage implements Listener {



    public static void openGUI(Player player, OfflinePlayer target) {

        if (!player.hasPermission("axolotlpunish.mutepage.staff")) {
            player.sendMessage(AxolotlPunish.c(AxolotlConfig.PREFIX + "&cYou do not have permission to open the mute menu."));
            player.closeInventory();
            return;
        }

        Inventory gui = Bukkit.createInventory(player, AxolotlConfig.MUTE_PAGE_SLOTS.asInt(), AxolotlConfig.MUTE_PAGE_TITLE.asString());

        ItemStack chatabuse1 = new ItemStack(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER1_MATERIAL.asMaterial());
        ItemMeta chatabusemeta1 = chatabuse1.getItemMeta();
        chatabusemeta1.setDisplayName(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER1_DISPLAY_NAME.asStringC()); // StringC is with colors, String is without colors
        chatabusemeta1.setLore(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER1_LORE.asStringCList());
        chatabuse1.setItemMeta(chatabusemeta1);
        gui.setItem(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER1_SLOT.asInt(), chatabuse1);

        ItemStack chatabuse2 = new ItemStack(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER2_MATERIAL.asMaterial());
        ItemMeta chatabusemeta2 = chatabuse2.getItemMeta();
        chatabusemeta2.setDisplayName(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER2_DISPLAY_NAME.asStringC()); // StringC is with colors, String is without colors
        chatabusemeta2.setLore(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER2_LORE.asStringCList());
        chatabuse2.setItemMeta(chatabusemeta2);
        gui.setItem(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER2_SLOT.asInt(), chatabuse2);

        ItemStack chatabuse3 = new ItemStack(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER3_MATERIAL.asMaterial());
        ItemMeta chatabusemeta3 = chatabuse3.getItemMeta();
        chatabusemeta3.setDisplayName(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER3_DISPLAY_NAME.asStringC()); // StringC is with colors, String is without colors
        chatabusemeta3.setLore(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER3_LORE.asStringCList());
        chatabuse3.setItemMeta(chatabusemeta3);
        gui.setItem(AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER3_SLOT.asInt(), chatabuse3);


        ItemStack grayGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta grayGlassMeta = grayGlass.getItemMeta();
        grayGlassMeta.setDisplayName("");
        grayGlassMeta.setLocalizedName(" ");
        grayGlass.setItemMeta(grayGlassMeta);

        for (int i = 0; i < AxolotlConfig.MUTE_PAGE_SLOTS.asInt(); i++) {
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

        if (!event.getView().getTitle().equals(AxolotlConfig.MUTE_PAGE_TITLE.asString())) {
            return;

        }


        OfflinePlayer target = AxolotlPunish.getInstance().getMenuManager().getTargetPlayer().get(p);
        event.setCancelled(true);

        ItemStack clickedItem = event.getCurrentItem();

        if (clickedItem != null && clickedItem.hasItemMeta()) {
            // This is still good, make sure it's a custom item i guess.
            ItemMeta clickedItemMeta = clickedItem.getItemMeta();

            if (event.getSlot() == AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER1_SLOT.asInt()) { // now if you change the slot in the enum, it changes it everywhere
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("mute " + target.getName() + " " + AxolotlConfig.MUTE_TIER_1TEMPLATE_NAME.asString());
                p.closeInventory();

            } else if (event.getSlot() == AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER2_SLOT.asInt()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("mute " + target.getName() + " " + AxolotlConfig.MUTE_TIER_2TEMPLATE_NAME.asString());
                p.closeInventory();

            } else if (event.getSlot() == AxolotlConfig.MUTE_PAGE_CHAT_ABUSE_TIER3_SLOT.asInt()) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getUniqueId() + " permission settemp litebans.* true 1s");
                p.performCommand("mute " + target.getName() + " " + AxolotlConfig.MUTE_TIER_3TEMPLATE_NAME.asString());
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
