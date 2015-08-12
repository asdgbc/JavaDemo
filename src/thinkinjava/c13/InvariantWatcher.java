package thinkinjava.c13;

public class InvariantWatcher extends Thread {

	private Invariant invariant;

	public InvariantWatcher(Invariant invariant) {
		this.invariant = invariant;
		setDaemon(true);
		start();
	}

	public InvariantWatcher(Invariant invariant, int timeOut) {
		this(invariant);
		new Timeout(timeOut, "Timed out without violating invariant");
	}

	public void run() {
		while (true) {
			InvariantState state = invariant.invariant();
			if (state instanceof InvariantFailure) {
				System.out.println("Invariant violated: " + ((InvariantFailure) state).value);
				System.exit(0);
			}
		}
	}

}
