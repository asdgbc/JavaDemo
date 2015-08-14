package thinkinjava.c13;

import java.util.Timer;
import java.util.TimerTask;

class Blocked extends Thread {
	public Blocked() {
		System.out.println("Starting Blocked");
		start();

	}

	@Override
	public void run() {
		try {
			synchronized (this) {
				wait();
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		System.out.println("Exiting run()");
	}
}

public class Interruupt {

	static Blocked blocked = new Blocked();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Timer(true).schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("Preparing to interrupt");
				blocked.interrupt();
				blocked = null;
			}
		}, 2000);
	}

}
