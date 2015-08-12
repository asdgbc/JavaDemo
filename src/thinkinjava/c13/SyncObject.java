package thinkinjava.c13;

class DualSynch {
	private Object syncObjet = new Object();

	public synchronized void f() {
		System.out.println("Inside f()");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Leaving f()");
	}

	public void g() {
		synchronized (syncObjet) {
			System.out.println("Inside g()");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Leaving g()");
		}
	}
}

public class SyncObject {

	public static void main(String[] args) {
		final DualSynch ds = new DualSynch();
		new Thread() {
			public void run() {
				ds.f();
			}
		}.start();
		ds.g();
	}

}
