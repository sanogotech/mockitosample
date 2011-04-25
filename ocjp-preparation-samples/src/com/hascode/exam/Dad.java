package com.hascode.exam;

public class Dad extends Grampa {
	static {
		System.out.println("4");
	}

	{
		System.out.println("12");
	}

	public Dad() {
		System.out.println("14");
	}

	{
		System.out.println("13");
	}

	static {
		System.out.println("5");
	}
}
