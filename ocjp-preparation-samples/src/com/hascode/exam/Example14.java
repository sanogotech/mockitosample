package com.hascode.exam;

public class Example14 {
	public static void main(String[] args) {
		Integer i = 11;
		new Example14().dieAtRuntime(i); // At runtime we'll get: Exception in
											// thread "main"
											// java.lang.ClassCastException:
											// java.lang.Integer cannot be cast
											// to java.lang.String
	}

	public void dieAtRuntime(Object obj) {
		String s = (String) obj;
	}
}
