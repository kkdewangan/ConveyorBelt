package com.kamald.emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import com.kamald.warehouse.Item;

public class Employee implements Runnable{
	private BlockingQueue<Item> belt;
	private Status status;
	private String name;
	
	
	public Employee(String name, BlockingQueue<Item> belt) {
		this.name = name;
		this.belt = belt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	@Override
	public void run() {
		int noOfBolt = 0;
		int noOfMachine = 0;
		
		while(this.getStatus() != Status.WORKING && !belt.isEmpty()) {
			Item item = belt.poll();
			
			if("MACHINE".equalsIgnoreCase(item.getType())) {
				if(noOfMachine == 1) {
					belt.add(item);
				} else {
					noOfMachine++;
					System.out.println( item + "picked by" + this.name);
				}
			} else if("BOLT".equalsIgnoreCase(item.getType())) {
				if(noOfMachine == 2) {
					belt.add(item);
				} else {
					noOfMachine++;
					System.out.println(item + " picked by" + this.name);
				}
			}
			
			
			if( noOfBolt == 2 && noOfMachine == 1) {
				try {
					this.setStatus(Status.WORKING);
					Thread.sleep(60);
					this.setStatus(Status.COMPLETED);
					System.out.println("Product completed by "+ this.name);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				this.setStatus(Status.WAITING);
			}
		}
	}
	
	
	 private enum Status {
		OPEN, // no item in hand
		WAITING, // waiting for item to start product
		WORKING, // have all the items working on it
		COMPLETED; //product completed, open for new product
		//public Status() {}
	}

	
}
