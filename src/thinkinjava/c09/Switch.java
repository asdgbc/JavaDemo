package thinkinjava.c09;

public class Switch {

	private boolean state = false;

	public boolean read() {
		return state;
	}

	public void on() {
		state = true;
	}

	public void off() {
		state = false;
	}

}
