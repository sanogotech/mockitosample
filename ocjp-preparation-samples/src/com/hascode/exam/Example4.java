package com.hascode.exam;

public class Example4 {
	public static void main(String[] args) {
		int x = 4;
		int y = 5;
		switch (x) {
			case 4 :
				System.out.println("A");
				break;
			case y : // this one does not work
				System.out.println("B");
				break;
			default :
				System.out.println("Default");
		}

		// working sample
		final int z = 5;
		switch (x) {
			case 4 :
				System.out.println("A");
				break;
			case z : // now z is final ..
				System.out.println("B");
				break;
			default :
				System.out.println("Default");
		}

		final String str = "test";
		switch (str) { // strings do not work at all .. wait for Java 7 :)
		// [..]
		}
	}
}
