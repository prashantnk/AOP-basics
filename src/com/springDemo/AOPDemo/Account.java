package com.springDemo.AOPDemo;

public class Account {

	private int level;
	private String name;

	public Account() {

	}

	public Account(int level, String name) {
		this.level = level;
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [level=" + level + ", name=" + name + "]";
	}

}
