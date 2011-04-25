package com.hascode.exam;

public class Example19 {
	public static void main(String[] args) {
		int x = 3;
		if (x > 2 & ++x > 3) // no short circuit AND .. pre-increment on x will
								// be executed
			x++;
		if (x % 5 == 0 ^ true)
			x += 2;
		if (x > 1 || ++x > 0) // short circuit operator .. pre increment on x
								// won't be run
			x += 20;
		System.out.println(x); // result is 25
	}
}
