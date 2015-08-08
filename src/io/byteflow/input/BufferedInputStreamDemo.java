package io.byteflow.input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("F:\\eclipse.zip");

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			if (!file.exists()) {
				System.exit(0);
			}
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			byte[] b = new byte[1024];
			int len = 0;
			long begin = System.currentTimeMillis();
			while ((len = bis.read(b)) != -1) {
//				System.out.println(b.toString());
			}
			long end = System.currentTimeMillis();
			System.out.println(end - begin);
		} catch (Exception e) {
		} finally {

			try {
				fis.close();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
