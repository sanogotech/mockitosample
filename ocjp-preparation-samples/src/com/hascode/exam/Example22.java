package com.hascode.exam;

public class Example22 {
	public static void main(String[] args) {
		String t = "test";
		t.replace("te", "this is a te"); // this won't change the String
											// referenced by t
		System.out.println(t); // the output is "test"
	}

}
