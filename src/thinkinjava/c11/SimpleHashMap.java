package thinkinjava.c11;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/**
 * 
 * 创建时间：2015年8月26日 下午6:57:20
 * 
 * 项目名称：JavaDemo
 * 
 * @author chenxx@hundsun.com
 * 
 * @version 1.0
 * 
 *          文件名称：SimpleHashMap.java
 * 
 *          类说明：
 */

@SuppressWarnings("rawtypes")
public class SimpleHashMap extends AbstractMap {

	private static final int SZ = 997;
	private LinkedList[] bucket = new LinkedList[SZ];

	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key, Object value) {
		Object result = null;
		int index = key.hashCode() % SZ;
		if (index < 0)
			index = -index;
		if (bucket[index] == null)
			bucket[index] = new LinkedList();
		LinkedList pairs = bucket[index];
		MPair pair = new MPair(key, value);
		ListIterator it = pairs.listIterator();
		boolean found = false;
		while (it.hasNext()) {
			Object iPair = it.next();
			if (iPair.equals(pair)) {
				result = ((MPair) iPair).getValue();
				it.set(pair);
				found = true;
				break;
			}
		}
		if (!found) {
			bucket[index].add(pair);
		}
		return result;
	}

	@Override
	public Object get(Object key) {
		int index = key.hashCode() % SZ;
		if (index < 0)
			index = -index;
		if (bucket[index] == null)
			return null;
		LinkedList list = bucket[index];
		MPair match = new MPair(key, null);
		ListIterator li = list.listIterator();
		while (li.hasNext()) {
			Object o = li.next();
			if (match.equals(o)) {
				return ((MPair) o).getValue();
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set entrySet() {
		Set entries = new HashSet();
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] == null)
				continue;
			Iterator it = bucket[i].iterator();
			while (it.hasNext()) {
				entries.add(it.next());
			}
		}
		return entries;
	}

}
