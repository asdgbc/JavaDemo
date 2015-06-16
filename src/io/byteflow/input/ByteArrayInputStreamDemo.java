package io.byteflow.input;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayInputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string = "http://www.jd.com/?utm_source=baidu&utm_medium=cpc&utm_term=baidu1_%be%a9%b6%abx";
		ByteArrayInputStream bais = new ByteArrayInputStream(string.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bttmp = new byte[10];
		int len;
		try {
			while ((len = bais.read(bttmp)) != -1) {
				baos.write(bttmp, 0, len);
			}
			System.out.println(baos.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
