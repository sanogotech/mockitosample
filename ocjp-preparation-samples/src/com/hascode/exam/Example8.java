package com.hascode.exam;

public class Example8 {
	public static void main(String[] args) {
		int x = 0;
		int out = 0;
		boolean z = true;
		if (z & (++x == 1))
			out++;
		if ((z == true) & ++out == 2)
			out += 3;
		System.out.println(out);

	}
}
