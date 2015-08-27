package thinkinjava.c11;

public class Prediction {
	private boolean shadow = Math.random() > 0.5;

	@Override
	public String toString() {
		if (shadow) {
			return "Six more weeks of Winer!";
		} else {
			return "Early Spring!";
		}
	}
}
