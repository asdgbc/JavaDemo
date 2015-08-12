package thinkinjava.c13;

public class InvariantFailure implements InvariantState {
	public Object value;

	public InvariantFailure(Object value) {
		this.value = value;
	}
}
