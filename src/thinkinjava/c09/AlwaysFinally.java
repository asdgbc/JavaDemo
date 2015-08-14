package thinkinjava.c09;

class FourException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6716904465800777826L;

}

public class AlwaysFinally {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Entering first try bolck");
		try {
			System.out.println("Entering second try block");
			try {
				throw new FourException();
			} finally {
				System.out.println("finally in 2nd try block");
			}
		} catch (FourException e) {
			System.err.println("Caught FourException in 1st try block");
		} finally {
			System.err.println("finally in 1st try block");
		}
	}

}
