package TestRun;

import org.testng.annotations.Test;

abstract class Animal {
	// abstract method without body (No Implementation)
	abstract void makeSound();

	// Non abstract method with body
	void eat() {
		System.out.println("This animal eat food");
	}
}

class Dog extends Animal {
	// calling abstract method from abstract class
	void makeSound() {
		System.out.println("The Dog Barks.");
	}
}

class Cat extends Animal {
	// calling abstract method from abstract class
	void makeSound() {
		System.out.println("The Cat Meow.");
	}
}

@Test
public class AbstractClassExample1 {
	public void abstract1() {

		Dog dog = new Dog();
		dog.makeSound();
		dog.eat();

		Cat cat = new Cat();
		cat.makeSound();
		cat.eat();
	}
}
