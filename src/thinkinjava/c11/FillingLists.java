package thinkinjava.c11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillingLists {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("");
		}
		Collections.fill(list, "Hello");
		System.out.println(list);
	}

}
