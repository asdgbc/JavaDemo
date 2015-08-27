package thinkinjava.c11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import thinkinjava.util.Collections2;
import thinkinjava.util.CountryCapitals;

public class Collection1 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		Collections2.fill(c, Collections2.countries, 5);
		c.add("ten");
		c.add("eleven");
		System.out.println(c);
		Object[] array = c.toArray();
		String[] str = (String[]) c.toArray((new String[1]));
		System.out.println("Collections.max(c) = " + Collections.max(c));
		System.out.println("Collections.min(c) = " + Collections.min(c));
		Collection<String> c2 = new ArrayList<String>();
		Collections2.fill(c2, Collections2.countries, 5);
		c.addAll(c2);
		System.out.println(c);
		c.remove(CountryCapitals.pairs[0][0]);
		System.out.println(c);
		c.remove(CountryCapitals.pairs[1][0]);
		System.out.println(c);
		c.removeAll(c2);
		System.out.println(c);
		c.addAll(c2);
		System.out.println(c);
		String val = CountryCapitals.pairs[3][0];
		System.out.println("c.contains(" + val + ") = " + c.contains(val));
		System.out.println("c.containsAll(c2) = " + c.containsAll(c2));
		Collection<String> c3 = ((List<String>) c).subList(3, 5);
		c2.retainAll(c3);
		System.out.println(c);
		c2.remove(c3);
		System.out.println("c.isEmpty() = " + c.isEmpty());
		c = new ArrayList<String>();
		Collections2.fill(c, Collections2.countries, 5);
		System.out.println(c);
		c.clear();
		System.out.println("after c.clear():");
		System.out.println(c);
	}
}
