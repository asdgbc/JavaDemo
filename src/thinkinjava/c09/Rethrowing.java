package thinkinjava.c09;

public class Rethrowing {

	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
	}

	public static void g() throws Throwable {
		try {
			f();
		} catch (Exception e) {
			System.err.println("Inside g(), e.printStackTrace()");
			e.printStackTrace();
//			throw e;
			/*
			 * 用于在Throwable对象的内部记录栈(stack frame)的当前状态
			 * 在程序重新抛出错误或异常时很有用。调用该代码使改行成为异常的新发生地。
			 */
			throw e.fillInStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Throwable {
		try {
			g();
		} catch (Exception e) {
			System.err.println("Caught in main, e.printStackTrace()");
			e.printStackTrace();
		}
	}

}
