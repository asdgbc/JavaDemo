package io.charflow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

public class FileReaderDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		StringWriter sw = new StringWriter();
		try {
			fr = new FileReader(new File("F:\\student.txt"));
			char[] buf = new char[1024];
			int len;
			while ((len = fr.read(buf)) != -1) {
				sw.write(buf, 0, len);
			}
			sw.flush();
			System.out.println(sw.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				sw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
