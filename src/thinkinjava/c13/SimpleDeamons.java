package thinkinjava.c13;

public class SimpleDeamons extends Thread {
	public SimpleDeamons(){
		setDaemon(true);//必須在start之前調用
		start();
	}
	public void run(){
		while(true){
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this);
		}
	}
	public static void main(String[] args){
		for (int i = 0; i < 10; i++) {
			new SimpleDeamons();
		}
	}
}
