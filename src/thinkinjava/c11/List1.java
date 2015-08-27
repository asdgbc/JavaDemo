package thinkinjava.c11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import thinkinjava.util.Collections2;

public class List1 {

	@SuppressWarnings("rawtypes")
	public static List fill(List a) {
		Collections2.countries.reset();
		Collections2.fill(a, Collections2.countries, 10);
		return a;
	}

	private static boolean b;
	private static Object o;
	private static int i;
	@SuppressWarnings("rawtypes")
	private static Iterator it;
	@SuppressWarnings("rawtypes")
	private static ListIterator lit;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void basicTEST(List a) {
		a.add(1, "x");// add at location 1
		a.add("x");// add at end

		a.addAll(fill(new ArrayList()));
		a.addAll(3, fill(new ArrayList()));

		b = a.contains("1");
		b = a.containsAll(fill(new ArrayList()));

		o = a.get(1);
		i = a.indexOf("1");
		b = a.isEmpty();
		it = a.iterator();
		lit = a.listIterator();
		lit = a.listIterator(3);
		i = a.lastIndexOf("1");
		a.remove(1);
		a.remove("3");
		a.set(1, "y");
		//保留所有包含在指定list中的元素，也就是说删除不在指定list中的所有元素
		a.retainAll(fill(new ArrayList()));
		a.removeAll(fill(new ArrayList()));
		i = a.size();
		a.clear();

	}

	@SuppressWarnings("rawtypes")
	public static void iterMotion(List a) {
		ListIterator it = a.listIterator();
		b = it.hasNext();
		b = it.hasPrevious();
		o = it.next();
		i = it.nextIndex();
		o = it.previous();
		i = it.previousIndex();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void iterManipulation(List a) {
		ListIterator it = a.listIterator();
		it.add("47");
		System.out.println(it.previous());
		it.next();
		it.next();
		it.remove();
		it.next();
		it.set("47");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void testVisual(List a) {
		System.out.println(a);
		List b = new ArrayList();
		fill(b);
		System.out.println("b = ");
		System.out.println(b);
		a.addAll(b);
		a.addAll(fill(new ArrayList()));
		System.out.println(a);

		ListIterator x = a.listIterator(a.size() / 2);
		x.add("one");
		System.out.println(a);
		System.out.println(x.next());
		x.remove();
		System.out.println(x.next());
		x.set("47");
		System.out.println(a);
		x = a.listIterator(a.size());
		while (x.hasPrevious()) {
			System.out.println(x.previous() + "");
			System.out.println();
			System.out.println("testVisual finished");
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void testLinkedList() {
		LinkedList ll = new LinkedList();
		fill(ll);
		System.out.println(ll);
		ll.addFirst("one");
		ll.addFirst("two");
		System.out.println(ll);
		System.out.println(ll.getFirst());
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeFirst());
		System.out.println(ll.removeLast());
		System.out.println(ll);
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
//		basicTEST(fill(new LinkedList()));
//		basicTEST(fill(new ArrayList()));
//		iterMotion(fill(new LinkedList()));
//		iterMotion(fill(new ArrayList()));
//		iterManipulation(fill(new LinkedList()));
//		iterManipulation(fill(new ArrayList()));
		testVisual(fill(new LinkedList()));
//		testLinkedList();

	}

}
