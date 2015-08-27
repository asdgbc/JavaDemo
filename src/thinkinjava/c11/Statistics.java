package thinkinjava.c11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Counter {
	int i = 1;

	@Override
	public String toString() {
		return Integer.toString(i);
	}
}

public class Statistics {
	private static Random rand = new Random();

	public static void main(String[] args) {
		Map hm = new HashMap();
		for (int i = 0; i < 10000; i++) {
			Integer r = new Integer(rand.nextInt(20));
			if (hm.containsKey(r)) {
				((Counter) hm.get(r)).i++;
			} else {
				hm.put(r, new Counter());
			}
		}
		System.out.println(hm);
	}
}
