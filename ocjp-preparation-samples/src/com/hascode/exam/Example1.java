package com.hascode.exam;

public class Example1 {
	private final int	x	= 10;

	public static void main(String[] args) {
		x = 11; // fails
		System.out.println(getX()); // fails
		new Example1().getX(); // works

	}

	public int getX() {
		return x;
	}
}
