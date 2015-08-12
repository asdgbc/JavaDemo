package thinkinjava.c09;

class SimpleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2844490829097037847L;

}

public class SimpleExceptionDemo {

	public void f() throws SimpleException {
		System.out.println("Throw SimpleException from f()");
		throw new SimpleException();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleExceptionDemo sed = new SimpleExceptionDemo();
		try {
			sed.f();
		} catch (SimpleException e) {
			//通常把错误信息输出到System.err要好，因为System.out也许会被重定向
			//但是把结果送到System.err，他不会随System.out一起被重定向，这样
			//更容易被用户注意
			System.err.println("Caught it!");
		}
	}

}
