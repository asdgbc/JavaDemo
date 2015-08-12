package thinkinjava.c13;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class Pair {
	private int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
		this(0, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void incrementX() {
		x++;
	}

	public void incrementY() {
		y++;
	}

	public String toString() {
		return "x:" + x + ",y:" + y;
	}

	public class PairValuesNotEqualException extends RuntimeException {
		public PairValuesNotEqualException() {
			super("Pair values not equal:" + Pair.this);
		}
	}

	public void checkState() {
		if (x != y) {
			throw new PairValuesNotEqualException();
		}
	}

}

abstract class PairManager {
	protected Pair p = new Pair();
	private List<Pair> storage = new ArrayList<Pair>();

	public synchronized Pair getPair() {
		return new Pair(p.getX(), p.getY());
	}

	protected void store() {
		storage.add(getPair());
	}

	public abstract void doTask();
}

class PairManager1 extends PairManager {

	@Override
	public synchronized void doTask() {
		p.incrementX();
		p.incrementY();
		store();
	}

}

class PairManager2 extends PairManager {

	@Override
	public void doTask() {
		synchronized (this) {
			p.incrementX();
			p.incrementY();
		}
		store();
	}

}

class PairManipulator extends Thread {
	private PairManager pm;
	private int checkCounter = 0;

	private class PairChecker extends Thread {
		PairChecker() {
			start();
		}

		public void run() {
			while (true) {
				checkCounter++;
				pm.getPair().checkState();
			}
		}
	}

	public PairManipulator(PairManager pm) {
		this.pm = pm;
		start();
		new PairChecker();
	}

	public void run() {
		while (true) {
			pm.doTask();
		}
	}

	public String toString() {
		return "Pair:" + pm.getPair() + " checkCounter = " + checkCounter;
	}
}
/**
 * 通过使用同步控制块而不是对整个方法进行同步控制，可以使多个线程访问对象的事件性能得到显著提高
 * @author chenxx
 *
 */
public class CriticalSection {
	public static void main(String[] args) {
		final PairManipulator pm1 = new PairManipulator(new PairManager1());
		final PairManipulator pm2 = new PairManipulator(new PairManager2());
		new Timer(true).schedule(new TimerTask() {

			@Override
			public void run() {
				System.out.println("pm1:" + pm1);
				System.out.println("pm2:" + pm2);
				System.exit(0);
			}
		}, 10000);
	}
}
