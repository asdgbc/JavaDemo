package thread;

public class ThreadJoinDemo {

	public static void main(String[] args) {

		//阻塞主线程
//		Thread xx = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("beginning of thread");
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("end of thread");
//			}
//		});
//		xx.start();
//		try {
//			//在start之后调用才有效
//			xx.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("end of mainthread");
		
		
		//阻塞线程
		Thread first = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("beginning of firstthread");
				Thread second = new Thread(new Runnable() {
					
					@Override
					public void run() {
						System.out.println("beginning of secondthread");
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("end of secondthread");
					}
				});
				second.start();
				try {
					//线程等待时长
					second.join(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end of firstthread");
			}
		});
		first.start();
	}

}
