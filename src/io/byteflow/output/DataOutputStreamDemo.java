package io.byteflow.output;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("F:\\libai.txt");
		DataOutputStream dos = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			dos = new DataOutputStream(new FileOutputStream(file));
			dos.writeInt(18);
			dos.writeUTF("李白");
			dos.writeDouble(3.14);
			dos.writeBoolean(true);
		} catch (Exception e) {
		}finally{
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
