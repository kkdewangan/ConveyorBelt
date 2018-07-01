package com.kamald.warehouse;

public class Bolt implements Item {
	private int num;
	public Bolt(int number) {
		this.num = number;
	}
	
	@Override
	public String getType() {
		return "BOLT";
	}

	@Override 
	public String toString() {
		return "BOLT " + num;
	}
}
