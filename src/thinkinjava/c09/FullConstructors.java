package thinkinjava.c09;


class MyException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7815043297741335474L;

	public MyException() {
	}

	public MyException(String msg) {
		super(msg);
	}
}

public class FullConstructors {

	public static void f() throws MyException {
		System.out.println("Throwing MyException from f()");
		throw new MyException();
	}

	public static void g() throws MyException {
		System.out.println("Throwing MyException from g()");
		throw new MyException("Originated in g()");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			f();
		} catch (MyException e) {
			e.printStackTrace();
		}

		try {
			g();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
