package thinkinjava.c13;

public class EvenGenerator implements Invariant {

	private int i;

	public void next() {
		i++;
		i++;
	}

	public int getValue() {
		return i;
	}

	public InvariantState invariant() {
		int val = i;
		if (val % 2 == 0) {
			return new InvariantOK();
		} else {
			return new InvariantFailure(new Integer(val));
		}
	}

	public static void main(String[] args) {
		EvenGenerator gen = new EvenGenerator();
		new InvariantWatcher(gen);
		while (true)
			gen.next();
	}

}
