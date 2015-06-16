package io.byteflow.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String libai = "白酒新熟山中归，黄鸡啄黍秋正肥。\n呼童烹鸡酌白酒，儿女歌笑牵人衣。\n高歌取醉欲自慰，起舞落日争光辉。\n游说万乘苦不早，著鞭跨马涉远道。\n会稽愚妇轻买臣，余亦辞家西入秦。\n仰天大笑出门去，我辈岂是蓬蒿人。";
		File file = new File("F:\\libai.txt");
		FileOutputStream fos = null;
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			fos.write(libai.getBytes(), 0, libai.getBytes().length);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
