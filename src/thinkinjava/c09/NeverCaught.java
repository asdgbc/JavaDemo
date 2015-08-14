package thinkinjava.c09;

public class NeverCaught {

	static void f() {
		throw new RuntimeException("From f()");
	}

	static void g() {
		f();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		g();
	}

}
