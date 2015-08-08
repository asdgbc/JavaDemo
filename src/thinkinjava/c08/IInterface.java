package thinkinjava.c08;

/**
 * 嵌套类可以作为接口的一部分
 * @author chenxx
 *
 */
public interface IInterface {
	static class Inner{
		int i,j,k;
		public Inner(){}
		void f(){}
	}
}
