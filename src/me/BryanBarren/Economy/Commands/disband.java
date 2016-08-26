package me.BryanBarren.Economy.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.BryanBarren.Economy.Companies;
import me.BryanBarren.Economy.CompaniesManager;
import me.BryanBarren.Economy.Errors;

public class disband extends command {

	public disband() {
		super("disband", "disband a company", "<name>");
	}

	@Override
	public void run(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length < 1) {
				p.sendMessage(Errors.getErrorMessage(Errors.TOO_LESS_ARGUMENTS));
				return;
			}

			if (args.length == 1 && p.isOp()) {
				String cName = args[0];
				CompaniesManager.getInstance().removeCompany(p, cName);
				return;
			}
			if (args.length == 0) {
				String name = p.getName();
				if(CompaniesManager.getInstance().companyWhereOwner(name).equalsIgnoreCase(name)) {
					CompaniesManager.getInstance().removeCompany(p, cName);

				}
			}
		}
	}

}
