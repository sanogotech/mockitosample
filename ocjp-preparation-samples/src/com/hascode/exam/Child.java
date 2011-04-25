package com.hascode.exam;

public class Child extends Dad {
	static {
		System.out.println("6");
	}

	{
		System.out.println("15");
	}

	public Child() {
		System.out.println("17");
	}

	{
		System.out.println("16");
	}

	static {
		System.out.println("7");
	}
}
