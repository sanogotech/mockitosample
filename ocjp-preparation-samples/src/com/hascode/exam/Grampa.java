package com.hascode.exam;

public class Grampa {
	static {
		System.out.println("2");
	}

	{
		System.out.println("8");
	}

	public Grampa() {
		this("test");
		System.out.println("11");
	}

	public Grampa(String s) {
		System.out.println("10");
	}

	{
		System.out.println("9");
	}

	static {
		System.out.println("3");
	}
}
