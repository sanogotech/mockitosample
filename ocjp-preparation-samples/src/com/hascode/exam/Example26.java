package com.hascode.exam;

public class Example26 extends SomeParent {
	/**
	 * fails .. return type must match or be covariant return
	 */
	public int doSomething(String test) throws IllegalArgumentException {
	}

	/**
	 * fails .. exception is broader than the original exception
	 */
	public void doAnotherThing(String test) throws Exception {
	}

	/**
	 * works .. NumberFormatException is a narrower exception to the original
	 * IllegalArgumentException and the less restrictive access modifier is
	 * allowed
	 */
	public void doAThirdThing(String test) throws NumberFormatException {
	}
}
