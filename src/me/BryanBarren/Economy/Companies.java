package me.BryanBarren.Economy;

import java.util.ArrayList;


public class Companies {
	
	private String name,owner;
	
	private ArrayList<String> members;
	private ArrayList<String> associates;
	public Companies(String name, String owner, ArrayList<String> members, ArrayList<String> associates) {
		this.members = members;
		this.name = name;
		this.owner = owner;
		this.associates = associates;
	}
	
	public ArrayList<String> getMembers() {
		return this.members;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getOwner() {
		return this.owner;
	}
	public ArrayList<String> getAssociates() {
		return this.associates;
	}

}
