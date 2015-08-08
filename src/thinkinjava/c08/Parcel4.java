package thinkinjava.c08;

public class Parcel4 {

	public Destination dest(String s) {
		// 定义在方法中的内部类
		class PDestination implements Destination {
			private String label;

			public PDestination(String whereTo) {
				this.label = whereTo;
			}

			@Override
			public String readLabel() {
				return label;
			}

		}
		return new PDestination(s);
	}

	public static void main(String[] args) {
		Parcel4 p = new Parcel4();
		Destination d = p.dest("Tanzania");
	}

}
