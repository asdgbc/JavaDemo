package thinkinjava.c09;

class OneException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2696758166830396944L;

	public OneException(String msg) {
		super(msg);
	}
}

class TwoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6472883584296793524L;

	public TwoException(String msg) {
		super(msg);
	}
}

public class RethrowNew {

	public static void f() throws OneException {
		System.out.println("originating the exception in f()");
		throw new OneException("thrown from f()");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws TwoException {
		try {
			f();
		} catch (Exception e) {
			System.err.println("Caught in main, e.printStackTrace()");
			e.printStackTrace();
			throw new TwoException("from main()");
		}
	}

}
