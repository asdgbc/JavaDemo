package thinkinjava.c09;

class VeryImportException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4392211616497373310L;

	@Override
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5961398542411780121L;

	@Override
	public String toString() {
		return "A trivial exception";
	}
}

public class LostMessage {

	void f() throws VeryImportException {
		throw new VeryImportException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		LostMessage lm = new LostMessage();
		try {
			//并没有catch块，那么这个异常为什么消失了
			lm.f();
		} finally {
			lm.dispose();
		}
	}

}
