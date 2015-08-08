package thinkinjava.c08;

/**
 * 匿名内部类的构造过程
 * @author chenxx
 *
 */
abstract class Base{
	public Base(int i){
		System.out.println("Base constructor,i = " + i);
	}
	
	public abstract void f();
	
}

public class AnonymousConstructor {

	private static Base getBase(int i){
		return new Base(i) {
			{
				System.out.println("Inside instance initializer");
			}
			@Override
			public void f() {
				System.out.println("In anonymous f()");
			}
		};
	}
	
	public static void main(String[] args) {
		Base base = getBase(47);
		base.f();
	}

}
