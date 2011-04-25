package com.hascode.exam;

public class Example13 {
	public static void main(String[] args) {
		final Example13 e = new Example13();

		Integer i1 = 13;
		e.processLong(i1); // error: you cannot widen a wrapper into another
							// wrapper ..
							// this only works for is-a relations

		float f1 = 13f;
		e.processDouble(f1); // error: first widen (float->double), then box
								// (double->Double) is not possible

		int i2 = 13;
		e.processNumber(i2); // works: boxing, then widening is allowed
	}

	public void processLong(Long l) {
	}

	public void processDouble(Double d) {
	}

	public void processNumber(Number n) {
	}
}
