package com.hascode.exam;

public class RobotTask extends Thread {
	private double	computationTime;

	@Override
	public void run() {
		synchronized (this) {
			try {
				Thread.sleep(3000);
				computationTime = Math.random();
				notifyAll();
			} catch (InterruptedException e) {
			}
		}
	}

	public double getComputationTime() {
		return computationTime;
	}
}
