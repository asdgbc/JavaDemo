package thinkinjava.c13;

public class Semaphore implements Invariant {

	private volatile int semaphore = 0;

	public boolean available() {
		return semaphore == 0;
	}

	public void acquire() {
		++semaphore;
	}

	public void release() {
		--semaphore;
	}

	@Override
	public InvariantState invariant() {
		int val = semaphore;
		if (val == 0 || val == 1) {
			return new InvariantOK();
		} else {
			return new InvariantFailure(new Integer(val));
		}
	}

}
