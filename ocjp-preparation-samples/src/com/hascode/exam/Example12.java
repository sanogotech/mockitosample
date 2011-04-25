package com.hascode.exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Example12 {
	public static void main(String[] args) {
		FileInputStream is;
		try {
			is = new FileInputStream(new File("/tmp/test.data"));
		} catch (FileNotFoundException e) {
		} finally {
			is.close(); // unhandled exception of type IOException !!
		}
	}
}
