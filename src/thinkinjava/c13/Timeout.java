package thinkinjava.c13;

import java.util.Timer;
import java.util.TimerTask;

public class Timeout extends Timer {

	public Timeout(int delay, String msg) {
		super(true);
		schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println(msg);
				System.exit(0);
				;
			}
		}, delay);
	}

}
