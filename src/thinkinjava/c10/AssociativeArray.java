package thinkinjava.c10;

public class AssociativeArray {

	private Object[][] pairs;
	private int index;

	public AssociativeArray(int length) {
		pairs = new Object[length][2];
	}

	public void put(Object key, Object value) {
		if (index >= pairs.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		pairs[index++] = new Object[] { key, value };
	}

	public Object get(Object key) {
		for (int i = 0; i < index; i++) {
			if (key.equals(pairs[i][0])) {
				return pairs[i][1];
			}
		}
		throw new RuntimeException("Failed to find key");
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < index; i++) {
			result.append(pairs[i][0] + " : " + pairs[i][1]);
			if (i < index - 1) {
				result.append("\n");
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		AssociativeArray map = new AssociativeArray(6);
		map.put("sky", "blue");
		map.put("grass", "green");
		map.put("ocean", "dancing");
		map.put("tee", "tall");
		map.put("earth", "brown");
		map.put("sun", "warm");
		try {
			map.put("extra", "object");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Too many objects!");
		}
		System.out.println(map);
		System.out.println(map.get("ocean"));
	}

}
