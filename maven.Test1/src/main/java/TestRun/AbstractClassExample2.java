package TestRun;

import org.testng.annotations.Test;

interface Drivable{
	void drive();
}

abstract class vehicle implements Drivable {
	//abstract method without body (No Implementation)
	abstract void fuel();
	
	//Non abstract method with body
	void start() {
		System.out.println("The Vehicle is Starting.");
	}
}

class Car extends vehicle {
	void fuel() {
		System.out.println("The Car is Refueling.");
	}
	
	public void drive() {
		System.out.println("The Car is Driving.");
	}
}

@Test
public class AbstractClassExample2 {
	public void abstract2() {
		Car car = new Car();
		
		car.fuel();
		car.start();
		car.drive();
	}
}
