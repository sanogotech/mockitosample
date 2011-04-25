package com.hascode.exam;

public class Example23 {
	public static void main(String[] args) throws InterruptedException {
		RobotTask robot = new RobotTask();
		for (int i = 0; i < 5; i++) {
			Worker worker = new Worker(robot);
			worker.start();
		}
		robot.start();
	}
}
