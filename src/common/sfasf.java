package common;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class sfasf {
	interface wakaka {
		public void wa(int i);
	}

	wakaka wa;

	void setLis(wakaka w) {
		wa = w;
	}

	public static void main(String[] args) {
		sfasf s = new sfasf();
		s.setLis((x) -> {
			System.out.println("wakaka" + x);
		});
//		Reference<T>
		List<String> list = new ArrayList<String>();
		list.stream().filter(o->{return o.endsWith("asdf");}).forEach(o->{o = "asdf";});
	}

	class A {
		int method(int a,int b){
			return 0;
		}
	}
	
	class B extends A{

		@Override
		int method(int a, int b) {
			// TODO Auto-generated method stub
			return super.method(a, b);
		}
		
	}
	
}
class XX{
	boolean closed;

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	
}