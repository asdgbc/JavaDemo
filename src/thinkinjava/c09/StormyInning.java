package thinkinjava.c09;

class BaseballExceptioin extends Exception {
	private static final long serialVersionUID = -6663533540709293874L;
}

class Foul extends BaseballExceptioin {
	private static final long serialVersionUID = -6021101141884051659L;

}

class Strike extends BaseballExceptioin {
	private static final long serialVersionUID = -8206854757061547586L;

}

abstract class Inning {
	public Inning() throws BaseballExceptioin {
	}

	public void event() throws BaseballExceptioin {

	}

	public abstract void atBat() throws Strike, Foul;

	public void walk() {

	}
}

class StormException extends Exception {
	private static final long serialVersionUID = 17453681628867062L;
}

class RainedOut extends StormException {
	private static final long serialVersionUID = 2868761048814404229L;

}

class PopFoul extends Foul {
	private static final long serialVersionUID = 5150571836259082803L;

}

interface Storm {
	public void event() throws RainedOut;

	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {

	public StormyInning() throws RainedOut, BaseballExceptioin {
	}

	public StormyInning(String s) throws Foul, BaseballExceptioin {

	}

	public void rainHard() throws RainedOut {
	}

	public void event() {
	}

	public void atBat() throws PopFoul {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
			System.err.println("Pop foul");
		} catch (RainedOut e) {
			System.err.println("Rained out");
		} catch (BaseballExceptioin e) {
			System.err.println("Generic baseball exception");
		}

		try {
			Inning i = new StormyInning();
			i.atBat();
		} catch (Strike e) {
			System.err.println("Strike");
		} catch (Foul e) {
			System.err.println("Foul");
		} catch (RainedOut e) {
			System.err.println("Rained out");
		} catch (BaseballExceptioin e) {
			System.err.println("Generic baseball exception");
		}

	}

}
