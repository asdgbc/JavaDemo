package io.byteflow.input;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("F:\\libai.txt");
		//需要按照写入时的顺序进行读取，否则会出错
		DataInputStream dis = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			dis = new DataInputStream(new FileInputStream(file));
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
		} catch (Exception e) {
		}finally{
			try {
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
