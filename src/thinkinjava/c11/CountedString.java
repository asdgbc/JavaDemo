package thinkinjava.c11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CountedString {

	@SuppressWarnings("rawtypes")
	private static List created = new ArrayList();
	private String s;
	private int id = 0;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CountedString(String str) {
		s = str;
		created.add(s);
		Iterator it = created.iterator();
		while (it.hasNext())
			if (it.next().equals(s))
				id++;
	}

	@Override
	public String toString() {
		return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
	}

	@Override
	public int hashCode() {
		int res = 17;
		res = 37 * res + s.hashCode();
		res = 37 * res + id;
		return res;
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof CountedString) && s.equals(((CountedString) obj).s) && id == ((CountedString) obj).id;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Map map = new HashMap();
		CountedString[] cs = new CountedString[10];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = new CountedString("hi");
			map.put(cs[i], new Integer(i));
		}
		System.out.println(map);
		for (int i = 0; i < cs.length; i++) {
			System.out.println("Looking up "+cs[i]);
			System.out.println(map.get(cs[i]));
		}
	}

}
