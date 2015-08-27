package thinkinjava.c11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import thinkinjava.util.Arrays2;
import thinkinjava.util.Collections2;
import thinkinjava.util.Generator;

public class FillTest {
	private static Generator sg = new Arrays2.RandStringGenerator(7);

	public static void main(String[] args) {
		List list = new ArrayList();
		Collections2.fill(list, sg, 25);
		System.out.println(list + "\n");
		List list2 = new ArrayList();
		Collections2.fill(list, Collections2.capitals, 25);
		System.out.println(list2 + "\n");
		Set set = new HashSet();
		Collections2.fill(set, sg, 25);
		System.out.println(set + "\n");
		Map m = new HashMap();
		Collections2.fill(m, Collections2.rsp, 25);
		System.out.println(m + "\n");
		Map m2 = new HashMap();
		Collections2.fill(m2, Collections2.geography, 25);
		System.out.println(m2);
	}
}
