package thinkinjava.c09;

public class OnOffSwitch {

	private static Switch sw = new Switch();

	public static void f() throws OnOffException1, OnOffException2 {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			sw.on();
			f();
			sw.off();
		} catch (OnOffException1 e) {
			System.err.println("OnOffException1");
			sw.off();
		} catch (OnOffException2 e) {
			System.err.println("OnOffException2");
			sw.off();
		}
	}

}
