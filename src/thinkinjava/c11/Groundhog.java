package thinkinjava.c11;

public class Groundhog {

	protected int number;

	public Groundhog(int n) {
		number = n;
	}

	@Override
	public String toString() {
		return "Groudhog #" + number;
	}

}
