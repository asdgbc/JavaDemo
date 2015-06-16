package io.byteflow.output;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string = "http://www.jd.com/?utm_source=baidu&utm_medium=cpc&utm_term=baidu1_%be%a9%b6%abx";
		ByteArrayOutputStream baos= new ByteArrayOutputStream();
		
		try {
//			baos.write(string.getBytes(), 0, string.length());
			baos.write(string.getBytes());
			System.out.println(baos.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
