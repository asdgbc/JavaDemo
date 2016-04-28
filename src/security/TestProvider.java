package security;

import java.security.Provider;
import java.security.Security;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestProvider {
	public static void main(String[] args) {
		Provider[] providers = Security.getProviders();
		for (Provider provider:providers) {
			Set<Map.Entry<Object,Object>> set = provider.entrySet();
			Iterator<Entry<Object,Object>> ite = set.iterator();
			while (ite.hasNext()) {
				Entry<Object, Object> entry = ite.next();
				System.out.println("key:"+entry.getKey());
				System.out.println("value:"+entry.getValue());
			}
		}
	}
}
