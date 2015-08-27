package thinkinjava.c11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import thinkinjava.util.Collections2;

public class ReadOnly {
	private static Collections2.StringGenerator gen = Collections2.countries;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Collections2.fill(c, gen, 25);
		c = Collections.unmodifiableCollection(c);
		c.add("add");
	}
}
