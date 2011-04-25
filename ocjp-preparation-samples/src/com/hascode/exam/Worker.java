package com.hascode.exam;

public class Worker extends Thread {
	private final RobotTask	robot;

	public Worker(final RobotTask robot) {
		this.robot = robot;
	}

	@Override
	public void run() {
		System.out.println("Robot calculates ..");
		synchronized (robot) {
			try {
				robot.wait();
			} catch (InterruptedException e) {
			}
			System.out.println("Thread " + Thread.currentThread().getId() + " finished. result: " + robot.getComputationTime());
		}
	}
}
