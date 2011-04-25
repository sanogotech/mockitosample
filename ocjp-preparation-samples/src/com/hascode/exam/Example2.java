package com.hascode.exam;

public class Example2 {
	final Integer	i	= 10;
	public static void main(String[] args) {
		new Example2().doIncrement();
	}

	public void doIncrement() {
		i++; // fails
	}
}
