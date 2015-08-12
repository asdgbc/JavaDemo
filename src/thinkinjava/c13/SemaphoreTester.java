package thinkinjava.c13;

public class SemaphoreTester extends Thread {

	private volatile Semaphore semaphore;
	public SemaphoreTester(Semaphore semaphore){
		this.semaphore = semaphore;
		setDaemon(true);
		start();
	}
	
	public void run(){
		while(true){
			if (semaphore.available()) {
//				yield();
				semaphore.acquire();
				yield();
				semaphore.release();
//				yield();
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		Semaphore sem = new Semaphore();
		new SemaphoreTester(sem);
		new SemaphoreTester(sem);
		new InvariantWatcher(sem).join();
	}

}
