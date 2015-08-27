package thinkinjava.c11;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

import thinkinjava.util.Collections2;
import thinkinjava.util.CountryCapitals;

public class Map1 {

	private static Collections2.StringPairGenerator geo = Collections2.geography;
	private static Collections2.RandStringPairGenerator rsp = Collections2.rsp;

	public static void printKey(Map map) {
		System.out.println("Size = " + map.size() + ",");
		System.out.println("Keys: ");
		System.out.println(map.keySet());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void test(Map map) {
		System.out.println(map.getClass().getSimpleName());
		Collections2.fill(map, geo, 25);
		Collections2.fill(map, geo.reset(), 25);
		printKey(map);
		System.out.println("Values: ");
		System.out.println(map.values());
		System.out.println(map);
		String key = CountryCapitals.pairs[4][0];
		String value = CountryCapitals.pairs[4][1];
		System.out.println("map.containsKey(\"" + key + "\"):" + map.containsKey(key));
		System.out.println("map.get(\"" + key + "\"):" + map.containsKey(key));
		System.out.println("map.containsValue(\"" + value + "\"):" + map.containsValue(value));
		Map map2 = new TreeMap();
		Collections2.fill(map2, rsp, 25);
		map.putAll(map2);
		printKey(map);
		key = map.keySet().iterator().next().toString();
		System.out.println("First key in map:" + key);
		map.remove(key);
		printKey(map);
		map.clear();
		System.out.println("map.isEmpty():" + map.isEmpty());
		Collections2.fill(map, geo.reset(), 25);
		map.keySet().removeAll(map.keySet());
		System.out.println("map.isEmpty():" + map.isEmpty());
	}

	public static void main(String[] args) {
		test(new HashMap());
//		test(new TreeMap());
//		test(new LinkedHashMap<>());
//		test(new IdentityHashMap<>());
//		test(new WeakHashMap<>());
	}

}
