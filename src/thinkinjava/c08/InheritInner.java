package thinkinjava.c08;

class WithInner {
	class Inner {
	}
}

public class InheritInner extends WithInner.Inner {

	// 无法通过编译
	// public InheritInner() {
	// super();
	// }

	// 不存在要联接的外围类的缺省对象，因此需要显示传入外围类的引用
	InheritInner(WithInner wi) {
		wi.super();
	}

	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner ii = new InheritInner(wi);
	}

}
