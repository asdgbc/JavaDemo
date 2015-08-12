package thinkinjava.c13;

public class SynchronizedEvenGenerator implements Invariant {

	private int i;

	public synchronized void next() {
		i++;
		i++;
	}

	public synchronized int getValue() {
		return i;
	}

	@Override
	public InvariantState invariant() {
		int val = getValue();
		if (val % 2 == 0) {
			return new InvariantOK();
		} else {
			return new InvariantFailure(new Integer(val));
		}
	}

	public static void main(String[] args) {
		SynchronizedEvenGenerator gen = new SynchronizedEvenGenerator();
		new InvariantWatcher(gen, 4000);
		while (true)
			gen.next();
	}

}
