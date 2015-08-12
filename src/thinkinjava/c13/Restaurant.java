package thinkinjava.c13;

class Order {
	private static int i = 0;
	private int count = i++;

	public Order() {
		if (count == 10) {
			System.out.println("Out of food, closing");
			System.exit(0);
		}
	}

	public String toString() {
		return "Order " + count;
	}
}

class WaitPerson extends Thread {
	private Restaurant restaurant;

	public WaitPerson(Restaurant r) {
		restaurant = r;
		start();
	}

	public void run() {
		while (true) {
			while (restaurant.order == null) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Waitperson got " + restaurant.order);
				restaurant.order = null;
			}
		}
	}
}

class Chef extends Thread {
	private Restaurant restaurant;
	private WaitPerson waitPerson;

	public Chef(Restaurant r, WaitPerson w) {
		restaurant = r;
		waitPerson = w;
		start();
	}

	public void run() {
		while (true) {
			if (restaurant.order == null) {
				restaurant.order = new Order();
				System.out.println("Order up!");
				synchronized (waitPerson) {
					//notify会先获取对象的锁，保证了如果多个线程在同一对象上调用notify()时不会相互冲突
					waitPerson.notify();
				}
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

}

public class Restaurant {

	Order order;

	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();
		WaitPerson waitPerson = new WaitPerson(restaurant);
		Chef chef = new Chef(restaurant, waitPerson);
	}

}
