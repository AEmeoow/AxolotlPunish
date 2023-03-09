package axolotlstudios.commands;

import axolotlstudios.AxolotlPunish;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("");
        sender.sendMessage(AxolotlPunish.c("#FB5252      #FF487B&l&nPUNISHMENT SYSTEM COMMANDS:&r #FB5252      "));
        sender.sendMessage("");
        sender.sendMessage(AxolotlPunish.c("     &8&l➥ #FB9DE9/axolotlpunish help &7» &fGives a list of all accessible commands."));
        sender.sendMessage(AxolotlPunish.c("     &8&l➥ #FB9DE9/axolotlpunish reload &7» &fReload the configuration file."));
        sender.sendMessage(AxolotlPunish.c("     &8&l➥ #FB9DE9/axolotlpunish punish &e<ign> &7» &fSelect a player to punish."));
        sender.sendMessage("");
        sender.sendMessage(AxolotlPunish.c("&7➟ &fMade by &d&lAXOLOTL&f&lSTUDIOS"));
        sender.sendMessage("");
        return true;

    }
}