package thinkinjava.c13;

import java.util.Timer;
import java.util.TimerTask;

class CanStop extends Thread {
	// Must be volatile
	private volatile boolean stop = false;
	private int counter = 0;

	@Override
	public void run() {
		while (!stop && counter < 10000) {
			System.out.println(counter++);
		}
		if (stop) {
			System.out.println("Detectedd stop");
		}
	}

	public void requestStop() {
		stop = true;
	}
}

public class Stopping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final CanStop stoppable = new CanStop();
		stoppable.start();
		new Timer(true).schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("Requestint stop");
				stoppable.requestStop();
			}
		}, 500);
	}

}
