import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.kamald.emp.Employee;
import com.kamald.warehouse.Bolt;
import com.kamald.warehouse.Item;
import com.kamald.warehouse.Machine;

public class TestConveyor {

	public static void main(String[] args) {
		BlockingQueue<Item> belt = new ArrayBlockingQueue<>(10);
		
		//initialize belt
		initialize(belt);
		
		//create employee object
		Employee A = new Employee("Thread A", belt);
		Employee B = new Employee("Thread B", belt);
		Employee C = new Employee("Thread C", belt);
		
		
		//start thread
		new Thread(A).start();
		new Thread(B).start();
		new Thread(C).start();
	}

	private static void initialize(BlockingQueue<Item> belt) {
		belt.add(new Bolt(1));
		belt.add(new Machine(1));
		belt.add(new Bolt(2));
		belt.add(new Bolt(3));
		belt.add(new Machine(2));
		belt.add(new Bolt(4));
		belt.add(new Bolt(5));
		belt.add(new Bolt(6));
		belt.add(new Machine(3));
	}

}
