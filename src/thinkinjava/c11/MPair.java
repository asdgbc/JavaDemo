package thinkinjava.c11;

import java.util.Map;

@SuppressWarnings("rawtypes")
public class MPair implements Map.Entry, Comparable {

	private Object key, value;

	public MPair(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Object o) {
		return ((Comparable) key).compareTo(((MPair) o).key);
	}

	@Override
	public Object getKey() {
		return key;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public Object setValue(Object v) {
		Object result = value;
		value = v;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return key.equals(((MPair) obj).key);
	}
}
