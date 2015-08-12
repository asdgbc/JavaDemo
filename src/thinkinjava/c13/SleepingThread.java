package thinkinjava.c13;

public class SleepingThread extends Thread {

	private int countDown = 5;
	private static int threadCount = 0;

	public SleepingThread() {
		super("" + ++threadCount);
		start();
	}

	public String toString() {
		return "#" + getName() + ":" + countDown;

	}

	public void run() {
		while (true) {
			System.out.println(this);
			if (--countDown == 0) {
				return;
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			try {
				new SleepingThread().join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
