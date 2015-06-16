package io.byteflow.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("F:\\libai.txt");
		FileInputStream fis = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			fis = new FileInputStream(file);
			byte[] tem = new byte[20];
			int len;
			while ((len = fis.read(tem)) != -1) {
				baos.write(tem, 0, len);
			}
			System.out.println(baos.toString());
		} catch (Exception e) {
		} finally {
			try {
				baos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
