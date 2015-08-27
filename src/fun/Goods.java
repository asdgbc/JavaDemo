package fun;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

class Request {

	public Request(Customer c, int money) {
		super();
		this.c = c;
		this.money = money;
	}

	Customer c;
	int money;
}

class Customer {

	private String name;

	public Customer(String name) {
		this.name = name;
	}

	public void purch(Goods g, int money) {

		new Thread() {
			@Override
			public void run() {
				super.run();
				g.purch(money, Customer.this);
			}
		}.start();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return name.equals(obj);
	}
}

public class Goods {
	private int limit;
	private volatile int left;// 还剩多少
	private int qigou;
	// 用户购买记录队列队列
	private HashMap<Customer, Integer> record;
	// 购买请求队列
	private LinkedBlockingQueue<Request> mRequests;
	// 处理请求的线程池
	ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

	/**
	 * 
	 * @param limit
	 */
	public Goods(int limit, int qigou, float rate) {
		this.limit = limit;
		this.left = this.limit;
		this.qigou = qigou;
		record = new HashMap<Customer, Integer>();
		mRequests = new LinkedBlockingQueue<Request>();
	}

	public void purch(int money, Customer c) {
		synchronized (mRequests) {
			try {
				mRequests.put(new Request(c, money));
				mRequests.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void execute() {
		executor.execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					synchronized (mRequests) {
						Request request = null;
						while ((request = mRequests.poll()) == null) {
							try {
								mRequests.wait();
							} catch (InterruptedException e) {
								System.out.println("wakaka");
								e.printStackTrace();
							}
						}
						if (request.money < qigou) {
							System.err.println("用户：" + request.c.getName() + "\n抢购失败：" + request.money);
						} else if (left < request.money) {
							if (left==0) {
								System.out.println("已售罄");
							}else
							System.err.println("用户：" + request.c.getName() + "\n抢购失败：" + request.money + "\n您无法购买超过" + left + "元的产品");
						} else {
							left = left - request.money;
							if (record.containsKey(request.c)) {
								record.put(request.c, record.get(request.c) + request.money);
							} else {
								record.put(request.c, request.money);
							}
							System.out.println("用户：" + request.c.getName() + "\n抢购了：" + request.money + "\n剩余：" + left);
						}
					}
				}
			}
		});
	}

	public int getLeft() {
		return left;
	}

	public static void main(String[] args) {
		Goods goods = new Goods(2000000, 1000, 18);
		goods.execute();
		Random rand = new Random();
		int index = -1;
//		while (goods.getLeft() > 0) {
//			for (int i = 0; i < 10; i++) {
//				index++;
//				Customer c = new Customer("Customer" + index);
//				c.purch(goods, 1000 * rand.nextInt(20));
//			}
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(goods.executor.getActiveCount());
		Customer c = new Customer("Customer" + index);
		c.purch(goods, 1000 * rand.nextInt(20));
		
	}
}
