package com.hascode.exam;

public class Example17 {
	public static void main(String[] args) {
		new Example17().doSomething();
	}

	void doSomething() {
		String str1 = "test";
		final String str2 = "test";
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(str1); // this one fails - cannot refer to
											// non final variable
				System.out.println(str2); // this one works
			}
		}).start();

	}
}
