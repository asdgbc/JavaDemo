package thinkinjava.c13;

public class SynchronizedSemaphore extends Semaphore {

	private volatile int semaphore = 0;
	@Override
	public synchronized boolean available(){
		return semaphore == 0;
	}
	
	@Override
	public synchronized void acquire() {
		++semaphore;
	}

	@Override
	public synchronized void release() {
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

	public static void main(String[] args) throws Exception{
		SynchronizedSemaphore sem = new SynchronizedSemaphore();
		new SemaphoreTester(sem);
		new SemaphoreTester(sem);
		new InvariantWatcher(sem).join();
	}

}
