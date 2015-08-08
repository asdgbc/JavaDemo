package thinkinjava.c08;

import thinkinjava.c08.Parcel3.PDestination;

class Parcel3 {
	private class PContents implements Contents {
		private int i = 11;

		public int value() {
			return i;
		}

	}

	protected class PDestination implements Destination {
		private String label;

		public PDestination(String whereTo) {
			this.label = whereTo;
		}

		@Override
		public String readLabel() {
			return label;
		}

	}

	public Destination dest(String s) {
		return new PDestination(s);
	}

	public Contents cont() {
		return new PContents();
	}

}

public class TestParcel {

	public static void main(String[] args) {
		Parcel3 p = new Parcel3();
		Contents c = p.cont();
		Destination d = p.dest("Tanzania");
		// 蛮有意思的语法，创建内部类对象
		// 由于内部类会持有一个外围类的引用，因此
		// 在进行初始化的时候使用了p.这样的语法，
		// 将p的引用传递给实例化好的pd对象
		PDestination pd = p.new PDestination("asdf");
		// 无法访问PContents对象
		// Parcel3.PContents pc = p.new PContents();
	}

}
