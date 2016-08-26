package me.BryanBarren.Economy;

public enum Permissions {
	COMMAND_COMPANY;
	public static String getPermissons(Permissions type) {
		String permission= "";
		if(type == Permissions.COMMAND_COMPANY) {
			permission = "economy.company";
		}
		return permission;
	}

}
