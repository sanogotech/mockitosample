package com.hascode.exam;

public class Example27 {
	public static void main(String[] args) {
		short x = 4;
		long y = 10l;
		Long[] z = new Long[]{};

		Example27 e = new Example27();
		e.printOut(x);
		e.printOut(y);
		e.printOut(z);

	}

	public void printOut(int val) {
		System.out.println("Integer");
	}

	public void printOut(Long... val) {
		System.out.println("Long...");
	}
}
