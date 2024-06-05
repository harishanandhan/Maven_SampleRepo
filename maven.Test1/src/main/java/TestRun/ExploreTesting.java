package TestRun;

import java.util.ArrayList;
import org.testng.annotations.Test;

public class ExploreTesting {
	@Test
	public void DataTypeExample() {
		// Primitive data types
		int number = 42;
		double price = 19.99;
		char grade = 'A';
		boolean isValid = true;

		// Reference data types
		String message = "Hello, Java!";
		int[] numbersArray = { 1, 2, 3, 4, 5 };
		ArrayList<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");

		// Output primitive values
		System.out.println("Number: " + number);
		System.out.println("Price: " + price);
		System.out.println("Grade: " + grade);
		System.out.println("Is valid: " + isValid);

		// Output reference values
		System.out.println("Message: " + message);
		System.out.print("Numbers array: ");
		for (int num : numbersArray) {
			System.out.print(num + " ");
		}
		System.out.println("\nNames list: " + names);
	}

	@Test
	public void UnaryOperatorExample() {
		int a = 5;
		int b = -a;
		int c = +a;

		int d = 10;
		int e = ++d; // prefix increment
		int f = d--; // postfix decrement

		boolean g = true;
		boolean h = !g;

		int i = 8; // 8 in binary: 0000 1000
		int j = ~i; // j is -9, which is 1111 0111 in binary (two's complement)

		System.out.println("Unary Plus: " + c); // 5
		System.out.println("Unary Minus: " + b); // -5
		System.out.println("Prefix Increment: " + e); // 11
		System.out.println("Postfix Decrement: " + f); // d = 11
		System.out.println("Logical Complement: " + h); // false
		System.out.println("Bitwise Complement: " + j); // -9
	}
	
	@Test
	public void TernaryExample1() {
		int a = 2;
		int b = 5;

		// Using ternary operator to find the minimum of a and b
		int min = (a < b) ? a : b;

		// Output the result
		System.out.println(min); // Output: 2
	}
	
	@Test
	public void TernaryExample2() {
		int x = 10;
		int y = 20;

		// Use the ternary operator to find the maximum of x and y
		int max = (x > y) ? x : y;

		// Output the result
		System.out.println("The maximum value is: " + max); // Output: The maximum value is: 20
	}
	
	@Test
	public void continueExample() {
		System.out.println("Print the odd number 1 to 10:\n");
		for (int i = 1; i <= 10; i++) { // Using for loop
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i); // print odd number 1 to 10
		}
	}
	
	@Test
	public void continueExample1() {
		int i = 1;
		while (i <= 10) {
			if (i % 3 == 0) {
				i++;
				continue;
			}
			System.out.println(i);
			i++;
		}
	}
	
	@Test
	public void nestedIf() {
		String address = "Delhi, India";
		if (address.endsWith("India")) {
			if (address.contains("Meerut")) {
				System.out.println("Your city is Meerut");
			} else if (address.contains("Noida")) {
				System.out.println("Your city is Noida");
			} else {
				System.out.println("You are living in " + address.split(",")[0]);
			}
		} else {
			System.out.println("You are not living in India");
		}
	}    
	
	@Test
	public void switchMethod() {
		int num =5;
		switch(num) {
		case 0:
			System.out.println("The num is 0");
			break;
		case 4:
			System.out.println("The num is 4");
			break;
		default:
			System.out.println("The number is " + num);
		}
	}
	
	@Test //for loop
	public void forLoop() { 
		int sum = 0;
		for (int j = 1; j <= 10; j++) {
			sum = sum + j;
		}
		System.out.println("The sum of first 10 natural number is " + sum);
	}
	
	@Test //for each loop
	public void forEachLoop() {
		String[] names = { "Python", "C#", "Ruby", "C++", "Java" };
		System.out.println("Printing the content of array names:\n");
		for (String name : names) {
			System.out.println(name);
		}
	}
	
	@Test //while Loop
	public void whileLoop() {
		int i = 0;
		System.out.println("Printing the number of first 10 event numbers:\n");
		while (i <= 10) {
			System.out.println(i);
			i = i + 2;
		}
	}
	
	@Test //do while loop
	public void doWhileLoop() {
		int i = 0;
		System.out.println("Printing the number of first 10 event numbers:\n");
		do {
			System.out.println(i);
			i = i + 2;
		} while (i <= 10);
	}
	
	@Test
	public void continueStament() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 2; i++) {
			for (int j = i; j <= 5; j++) {
				if (j == 4) {
					continue;
				}
				System.out.println(j);
			}
		}
	}  
	
}
