package thinkinjava.c09;

public class ThrowOut {

	/**
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		try {
			throw new Throwable();
		} catch (Exception e) {
			System.err.println("Caught in main()");
		}
	}

}
