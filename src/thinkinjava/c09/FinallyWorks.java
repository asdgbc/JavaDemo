package thinkinjava.c09;

class ThreeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8042186369463064744L;
}

public class FinallyWorks {

	static int count = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			try {
				if (count++ == 0) {
					throw new ThreeException();
				}
				System.out.println("No exception");
			} catch (ThreeException e) {
				System.err.println("ThreeException");
			} finally {
				System.err.println("In finally clause");
				if (count == 2) {
					break;
				}
			}
		}
	}

}
