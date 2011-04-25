package com.hascode.exam;

public class Example28 {
	public static void main(String[] args) {
		int[] values = new int[]{};
		new Example28().process(values); // output is "Object"

		int[][] otherValues = new int[][]{};

		if (values == otherValues) { // this won't compile - different operand
										// types
		}
	}
	public void process(long x) {
		System.out.println("long");
	}

	public void process(Object obj) {
		System.out.println("Object");
	}

	public void process(long... values) {
		System.out.println("int...");
	}

}
