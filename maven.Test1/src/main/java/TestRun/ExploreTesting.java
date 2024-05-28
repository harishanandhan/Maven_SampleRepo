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
	
}
