package thinkinjava.c11;

import java.util.Arrays;
import java.util.WeakHashMap;

class Key {
	private String ident;

	public Key(String id) {
		ident = id;
	}

	@Override
	public int hashCode() {
		return ident.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Key) && ident.equals(((Key) obj).ident);
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalizing Key " + ident);
	}

}

class Value {
	private String ident;

	public Value(String ident) {
		this.ident = ident;
	}

	@Override
	public String toString() {
		return ident;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalizing Value " + ident);
	}

}

public class CanonicalMapping {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		int size = 1000;
		Key[] keys = new Key[size];
		WeakHashMap map = new WeakHashMap();
		for (int i = 0; i < size; i++) {
			Key k = new Key(Integer.toString(i));
			Value v = new Value(Integer.toString(i));
			if (i % 3 == 0) {
				keys[i] = k;

			}
			map.put(k, v);
		}
		System.gc();
	}
}
