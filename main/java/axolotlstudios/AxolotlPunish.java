package axolotlstudios;

import axolotlstudios.commands.CommandHandler;
import axolotlstudios.config.AxolotlConfig;
import axolotlstudios.inventory.*;
import axolotlstudios.manager.MenuManager;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AxolotlPunish extends JavaPlugin {

    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    private static Plugin plugin;

    @Getter private MenuManager menuManager;

    @Override
    public void onEnable() {
        plugin = this;

        // Config setup
        saveDefaultConfig();
        AxolotlConfig.reloadConfig();

        getServer().getPluginManager().registerEvents(new defaultpage(), this);
        getServer().getPluginManager().registerEvents(new banpage(), this);
        getServer().getPluginManager().registerEvents(new mutepage(), this);
        getServer().getPluginManager().registerEvents(new warnpage(), this);
        getServer().getPluginManager().registerEvents(new kickpage(), this);
        getCommand("axolotlpunish").setExecutor(new CommandHandler());

        menuManager = new MenuManager();

        instance = this;

    }

    public static Plugin getPlugin() {

        return plugin;
    }

    @Override
    public void onDisable() {

    }

    public static String getHex(String msg) {
        Matcher matcher = pattern.matcher(msg);
        while (matcher.find()) {
            String color = msg.substring(matcher.start(), matcher.end());
            msg = msg.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
            matcher = pattern.matcher(msg);
        }
        return net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String c(String s){

        return ChatColor.translateAlternateColorCodes('&', getHex(s));
    }

    @Getter public static AxolotlPunish instance;

}

