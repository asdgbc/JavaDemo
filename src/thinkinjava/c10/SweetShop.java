package thinkinjava.c10;

class Candy {
	static {
		System.out.println("Loading Candy");
	}
}

class Gum {
	static {
		System.out.println("Loading Gum");
	}
}

class Cookie {
	static {
		System.out.println("Loading Cookie");
	}
}

public class SweetShop {

	public static void main(String[] args) {
		System.out.println("inside main");
		new Candy();
		System.out.println("After create Candy");
		try {
			Class.forName("thinkinjava.c10.Gum");
		} catch (ClassNotFoundException e) {
			System.out.println("Coundn't find Gum");
		}
		System.out.println("After Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("After creating Cookie");

		try {
			if (Gum.class.equals(Class.forName("thinkinjava.c10.Gum"))) {
				System.out.println("true");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
