package com.kamald.warehouse;

public class Machine implements Item{
	private int num;
	public Machine(int number) {
		this.num = number;
	}
	@Override
	public String getType() {
		return "MACHINE";
	}

	@Override 
	public String toString() {
		return "MACHINE " + num;
	}
}
