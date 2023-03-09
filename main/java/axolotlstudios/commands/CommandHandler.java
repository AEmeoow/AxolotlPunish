package axolotlstudios.commands;

import axolotlstudios.AxolotlPunish;
import axolotlstudios.config.AxolotlConfig;
import axolotlstudios.inventory.defaultpage;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler implements CommandExecutor, TabCompleter {

    HelpCommand helpCommand = new HelpCommand();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("axolotlpunish.staff.use")) {
            player.sendMessage(AxolotlPunish.c(AxolotlConfig.PREFIX + "&cYou do not have permission to use this command."));
            return true;
        }

        if (args.length == 0) {
            helpCommand.onCommand(sender, command, label, args);
            return true;
        }

        if (args[0].equalsIgnoreCase("punish")) {
            if (args.length == 1) {
                player.sendMessage(AxolotlPunish.c(AxolotlConfig.PREFIX + "&cUsage: /stealfunpunish punish (player)"));
                return true;
            }
            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[1]);
            defaultpage.openGUI(player);
            AxolotlPunish.getInstance().getMenuManager().getTargetPlayer().put(player, offlinePlayer);
            return true;
        }

        if (args[0].equalsIgnoreCase("reload") && (player.hasPermission("axolotlpunish.reloadcmd.staff"))) {
            AxolotlConfig.reloadConfig();
            player.sendMessage(AxolotlPunish.c(AxolotlConfig.PREFIX + "&aConfiguration file reloaded."));
            return true;
        }

        if (args[0].equalsIgnoreCase("help")) {
            helpCommand.onCommand(sender, command, label, args);
            return true;
        }

        player.sendMessage(AxolotlPunish.c(AxolotlConfig.PREFIX + "&cUnknown subcommand. Use /stealfunpunish help for a list of subcommands."));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            completions.add("punish");
            completions.add("help");
            completions.add("reload");
        } else if (args.length == 2 && args[0].equalsIgnoreCase("punish")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                completions.add(player.getName());
            }
        }

        return completions;
    }
}


