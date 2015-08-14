package thinkinjava.c09;

public class WithFinally {

	static Switch sw = new Switch();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			sw.on();
			OnOffSwitch.f();
		}catch(OnOffException1 e){
			System.err.println("OnOffException1");
		}catch(OnOffException2 e){
			System.err.println("OnOffException2");
		}finally{
			sw.off();
		}
		
	}

}
