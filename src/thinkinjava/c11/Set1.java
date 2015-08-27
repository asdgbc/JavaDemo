
package thinkinjava.c11;   

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class Set1 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static void fill(Set s){
		s.addAll(Arrays.asList("one two three four five six seven".split(" ")));
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void test(Set s){
		System.out.println(s.getClass().getSimpleName());
		fill(s);fill(s);fill(s);
		System.out.println(s);
		s.addAll(s);
		s.add("one");
		s.add("one");
		s.add("one");
		System.out.println(s);
		System.out.println("s.contains(\"one\"):"+s.contains("one"));
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		test(new HashSet());
		test(new TreeSet());
		test(new LinkedHashSet());
	}
	
}
 