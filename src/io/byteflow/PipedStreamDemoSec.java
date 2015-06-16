package io.byteflow;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Random;

public class PipedStreamDemoSec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Send s = new Send();
		// Receive r = new Receive();
		// try {
		// s.getPos().connect(r.getPis());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// new Thread(s).start();
		// new Thread(r).start();

		try {
			PipedOutputStream pout1 = new PipedOutputStream();
			PipedInputStream pin1 = new PipedInputStream(pout1);

			PipedOutputStream pout2 = new PipedOutputStream();
			PipedInputStream pin2 = new PipedInputStream(pout2);

			/* construct threads */
			Producer prod = new Producer(pout1);
			Filter filt = new Filter(pin1, pout2);
			Consumer cons = new Consumer(pin2);
			/* start threads */
			prod.start();
			filt.start();
			cons.start();
		} catch (IOException e) {
		}

	}

	// 前端：该类的作用是产生随机数，并将其放到管道1的输出流中
	static class Producer extends Thread {
		private DataOutputStream out;// DataOutputStream是用于写入一些基本类型数据的类，此类的实例用于生成伪随机数流
		private Random rand = new Random();

		public Producer(OutputStream os) {
			out = new DataOutputStream(os);
		}

		public void run() {
			while (true) {
				try {
					double num = rand.nextDouble();
					// 将double值直接写入流
					out.writeDouble(num);
					System.out.println("写入流中的值是 ：" + num);
					out.flush();
					sleep(Math.abs(rand.nextInt() % 10));// 随机休眠一段时间
				} catch (Exception e) {
					System.out.println("Error:   " + e);
				}
			}
		}
	}

	// 过滤器，起数据处理作用，读取管道1中输入流的内容，并将其放到管道2的输出流中
	static class Filter extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		private double total = 0;
		private int count = 0;

		public Filter(InputStream is, OutputStream os) {
			in = new DataInputStream(is);
			out = new DataOutputStream(os);
		}

		public void run() {
			for (;;) {
				try {
					double x = in.readDouble(); // 读取流中的数据
					total += x;
					count++;
					if (count != 0) {
						double d = total / count;
						out.writeDouble(d); // 将得到的数据平均值写入流
					}
				} catch (IOException e) {
					System.out.println("Error:   " + e);
				}
			}
		}
	}

	// 后端：读取管道2输入流的内容
	static class Consumer extends Thread {
		private double old_avg = 0;
		private DataInputStream in;

		public Consumer(InputStream is) {
			in = new DataInputStream(is);
		}

		public void run() {
			for (;;) {
				try {
					double avg = in.readDouble();
					if (Math.abs(avg - old_avg) > 0.01) {
						System.out.println("现在的平均值是：   " + avg);
						System.out.println();
						old_avg = avg;
					}
				} catch (IOException e) {
					System.out.println("Error:   " + e);
				}
			}
		}
	}

	static class Receive implements Runnable {

		private PipedInputStream pis;

		public Receive() {
			this.pis = new PipedInputStream();
		}

		@Override
		public void run() {
			byte[] b = new byte[1024];
			int len = 0;
			try {
				len = this.pis.read(b);
			} catch (Exception e) {
			} finally {
				try {
					this.pis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("接收的内容为：" + new String(b, 0, len));
		}

		public PipedInputStream getPis() {
			return this.pis;
		}

	}

	static class Send implements Runnable {

		private PipedOutputStream pos = null;

		public Send() {
			this.pos = new PipedOutputStream();
		}

		@Override
		public void run() {
			String str = "Hello World!";
			try {
				// Thread.sl
				this.pos.write(str.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					this.pos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		public PipedOutputStream getPos() {
			return this.pos;
		}

	}

}
