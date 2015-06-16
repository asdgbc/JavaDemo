package io.byteflow;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Send s = new Send();
		Receive r = new Receive();

		try {
			r.getPis().connect(s.getPos());

			new Thread(s).start();
			new Thread(r).start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static class Send implements Runnable {

		private PipedOutputStream pos = null;

		public Send() {
			this.pos = new PipedOutputStream();
		}

		@Override
		public void run() {
			String libai = "白酒新熟山中归，黄鸡啄黍秋正肥。\n呼童烹鸡酌白酒，儿女歌笑牵人衣。\n高歌取醉欲自慰，起舞落日争光辉。\n游说万乘苦不早，著鞭跨马涉远道。\n会稽愚妇轻买臣，余亦辞家西入秦。\n仰天大笑出门去，我辈岂是蓬蒿人。";
			try {
				Thread.sleep(3000);
				pos.write(libai.getBytes());
				Thread.sleep(3000);
				pos.write("wakaka".getBytes());
				Thread.sleep(3000);
				pos.write("libai".getBytes());
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			} finally {
				try {
					// 必須close，不然PipedInputStream會報錯
					pos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		public PipedOutputStream getPos() {
			return this.pos;
		}
	}

	static class Receive implements Runnable {

		private PipedInputStream pis = null;

		public Receive() {
			this.pis = new PipedInputStream();
		}

		@Override
		public void run() {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int len = 0;
			try {
				// 一直阻塞，等待PipedOutputStream close
				while ((len = this.pis.read(b, 0, b.length)) != -1) {
					bos.write(b, 0, len);
				}
				System.out.println(bos.toString());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					this.pis.close();
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		public PipedInputStream getPis() {
			return this.pis;
		}

	}

}
