package thinkinjava.c11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PrintingContainers {
	static Collection<String> fill(Collection<String> c) {
		c.add("dog");
		c.add("dog");
		c.add("cat");
		return c;
	}

	static Map<String, String> fill(Map<String, String> m) {
		m.put("dog", "Bosco");
		m.put("dog", "Spot");
		m.put("cat", "Rags");
		return m;
	}

	public static void main(String[] args) {
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new HashSet<String>()));
		System.out.println(fill(new HashMap<String, String>()));
	}

}
