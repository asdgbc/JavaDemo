package thinkinjava.c11;

class Weeble {
}

public class ArraySize {
	public static void main(String[] args) {
		Weeble[] a;
		Weeble[] b = new Weeble[5];
		Weeble[] c = new Weeble[4];
		for (int i = 0; i < c.length; i++) {
			if (c[i] == null) {
				c[i] = new Weeble();
			}
		}
		// 聚集初始化(aggregate initialization)，必须在定义变量的位置使用
		Weeble[] d = { new Weeble(), new Weeble(), new Weeble() };
		a = new Weeble[] { new Weeble(), new Weeble() };
		System.out.println("a.length=" + a.length);
		System.out.println("b.length=" + b.length);
		for (int i = 0; i < b.length; i++) {
			System.out.println("b[" + i + "]=" + b[i]);
		}
		System.out.println("c.length=" + c.length);
		System.out.println("d.length=" + d.length);
		a = d;
		System.out.println("a.length=" + a.length);

		// 基本类型的数组的工作方式与对象数组一样，不过基本类型的数组直接存储基本类型数据的值
		int[] e;
		int[] f = new int[5];
		int[] g = new int[4];
		for (int i = 0; i < g.length; i++) {
			g[i] = i * i;
		}
		int[] h = { 11, 47, 93 };
		System.out.println("f.length=" + f.length);
		for (int i = 0; i < f.length; i++) {
			System.out.println("f[" + i + "]=" + f[i]);
		}
		System.out.println("g.length=" + g.length);
		System.out.println("h.length=" + h.length);
		e = h;
		System.out.println("e.length=" + e.length);
		e = new int[] { 1, 2 };
		System.out.println("e.length=" + e.length);

	}
}
