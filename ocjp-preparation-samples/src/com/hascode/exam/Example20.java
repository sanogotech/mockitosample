package com.hascode.exam;

import static java.lang.Math; // this won't work

/* 
 * the correct way is one of those:
 * 
 * import static java.lang.Math.*;
 * import static java.lang.Math.max;
 * 
 */

public class Example20 {
	public static void main(String[] args) {
		max(2, 4);
	}
}
