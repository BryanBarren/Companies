package me.BryanBarren.Economy;

public enum Errors {
	PLAYER_ONLY_COMMAND, NO_PERMISSIONS, TOO_MANY_ARGUMENTS, TOO_LESS_ARGUMENTS, NOT_ENOUGH_MONEY, FILE_DOES_NOT_EXIST, TOO_MANY_COMPANIES, UNKNOWN_COMMAND;
	
	public static String getErrorMessage(Errors type) { 
		String msg = "";
		if(type == PLAYER_ONLY_COMMAND) {
			msg = "Only a player can use this command.";
		} else if(type == NO_PERMISSIONS) {
			msg = "You don't have permissions to use this command.";
		}else if(type == TOO_MANY_ARGUMENTS) {
			msg = "Too many arguments doofus.";
		}else if(type == TOO_LESS_ARGUMENTS) {
			msg = "Too little arguments doofus.";
		}else if(type == NOT_ENOUGH_MONEY) {
			msg = "You're poor as hell, you don't got enough mullah";
		}else if(type == FILE_DOES_NOT_EXIST) {
			msg = "This file doesn't exist.";
		} else if(type == TOO_MANY_COMPANIES) {
			msg = "You can't have more than 1 company";
		} else if(type == Errors.UNKNOWN_COMMAND) {
			msg = "Unknown Command.";
		}
		
		return msg;
	}
}
