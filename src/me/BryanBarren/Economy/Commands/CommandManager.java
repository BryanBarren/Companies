package me.BryanBarren.Economy.Commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.BryanBarren.Economy.Errors;
import me.BryanBarren.Economy.Main;
import net.md_5.bungee.api.ChatColor;

public class CommandManager implements CommandExecutor {
	private ArrayList<command> cmds = new ArrayList<command>();
	Main main;

	public CommandManager(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("company")) {
			if (args.length == 0) {
				for (Command c : cmds) {
					sender.sendMessage(
							ChatColor.GOLD + cmd.getName() + c.getName() + c.getArgs() + " - " + c.getDescription());
				}
				return true;
			}
			ArrayList<String> a = new ArrayList<String>(Arrays.asList(args));
			a.remove(0);
			for (Command c : cmds) {
				if (c.getName().equalsIgnoreCase(args[0])) {
					try {
						c.run(sender, a.toArray(new String[a.size()]));
					} catch (Exception e) {
						sender.sendMessage("Error");
						e.printStackTrace();
					}
					return true;
				}
			}
			sender.sendMessage(Errors.getErrorMessage(Errors.UNKNOWN_COMMAND));
		}
		return false;
	}
}
