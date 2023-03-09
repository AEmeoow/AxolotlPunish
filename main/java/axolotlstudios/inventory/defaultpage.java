package axolotlstudios.inventory;

import axolotlstudios.AxolotlPunish;
import axolotlstudios.config.AxolotlConfig;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class defaultpage implements Listener {


    public static void openGUI(Player player) {
        Inventory gui = Bukkit.createInventory(player, AxolotlConfig.DEFAULT_PAGE_SLOTS.asInt(), AxolotlConfig.DEFAULT_PAGE_TITLE.asString());

        ItemStack banOption = new ItemStack(AxolotlConfig.DEFAULT_PAGE_BAN_MATERIAL.asMaterial());
        ItemMeta banOptionMeta = banOption.getItemMeta();
        banOptionMeta.setDisplayName(AxolotlPunish.c(AxolotlConfig.DEFAULT_PAGE_BAN_DNAME.asStringC()));
        banOptionMeta.setLore(AxolotlConfig.DEFAULT_PAGE_BAN_LORE.asStringCList());
        banOption.setItemMeta(banOptionMeta);
        gui.setItem(AxolotlConfig.DEFAULT_PAGE_BAN_SLOT.asInt(), banOption);

        ItemStack muteOption = new ItemStack(AxolotlConfig.DEFAULT_PAGE_MUTE_MATERIAL.asMaterial());
        ItemMeta muteOptionMeta = muteOption.getItemMeta();
        muteOptionMeta.setDisplayName(AxolotlPunish.c(AxolotlConfig.DEFAULT_PAGE_MUTE_DNAME.asStringC()));
        muteOptionMeta.setLore(AxolotlConfig.DEFAULT_PAGE_MUTE_LORE.asStringCList());
        muteOption.setItemMeta(muteOptionMeta);
        gui.setItem(AxolotlConfig.DEFAULT_PAGE_MUTE_SLOT.asInt(), muteOption);

        ItemStack kickOption = new ItemStack(AxolotlConfig.DEFAULT_PAGE_KICK_MATERIAL.asMaterial());
        ItemMeta kickOptionMeta = kickOption.getItemMeta();
        kickOptionMeta.setDisplayName(AxolotlPunish.c(AxolotlConfig.DEFAULT_PAGE_KICK_DNAME.asStringC()));
        kickOptionMeta.setLore(AxolotlConfig.DEFAULT_PAGE_KICK_LORE.asStringCList());
        kickOption.setItemMeta(kickOptionMeta);
        gui.setItem(AxolotlConfig.DEFAULT_PAGE_KICK_SLOT.asInt(), kickOption);

        ItemStack warnOption = new ItemStack(AxolotlConfig.DEFAULT_PAGE_WARN_MATERIAL.asMaterial());
        ItemMeta warnOptionMeta = warnOption.getItemMeta();
        warnOptionMeta.setDisplayName(AxolotlPunish.c(AxolotlConfig.DEFAULT_PAGE_WARN_DNAME.asStringC()));
        warnOptionMeta.setLore(AxolotlConfig.DEFAULT_PAGE_WARN_LORE.asStringCList());
        warnOption.setItemMeta(warnOptionMeta);
        gui.setItem(AxolotlConfig.DEFAULT_PAGE_WARN_SLOT.asInt(), warnOption);

        ItemStack grayGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta grayGlassMeta = grayGlass.getItemMeta();
        grayGlassMeta.setDisplayName("");
        grayGlassMeta.setLocalizedName(" ");
        grayGlass.setItemMeta(grayGlassMeta);

        for (int i = 0; i < AxolotlConfig.DEFAULT_PAGE_SLOTS.asInt(); i++) {
            if (gui.getItem(i) == null) {
                gui.setItem(i, grayGlass);
            }
        }

        player.openInventory(gui);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(AxolotlConfig.DEFAULT_PAGE_TITLE.asString())) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            OfflinePlayer target = AxolotlPunish.getInstance().getMenuManager().getTargetPlayer().get(player);
            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && clickedItem.hasItemMeta()) {
                ItemMeta clickedItemMeta = clickedItem.getItemMeta();
                if (event.getSlot() == (AxolotlConfig.DEFAULT_PAGE_BAN_SLOT.asInt())) {
                    banpage.openGUI(player, target);
                }

                else if (event.getSlot() == (AxolotlConfig.DEFAULT_PAGE_MUTE_SLOT.asInt())) {
                    mutepage.openGUI(player, target);
                }

                else if (event.getSlot() == (AxolotlConfig.DEFAULT_PAGE_KICK_SLOT.asInt())) {
                    kickpage.openGUI(player, target);
                }

                else if (event.getSlot() == (AxolotlConfig.DEFAULT_PAGE_WARN_SLOT.asInt())) {
                    warnpage.openGUI(player, target);
                }

                    }

                }

            }


}





