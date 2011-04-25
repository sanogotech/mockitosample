package com.hascode.exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Example5 {
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("/tmp/test.dat")));
		} 
		System.err.println("test"); // this line is not allowed
		catch (final FileNotFoundException e) {
		}
	}
}
