package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import common.Person;

public class ObjectOutputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File outputFile = new File("F:\\student.txt");
		ObjectOutputStream oos = null;
		try {
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(outputFile));
			oos.writeObject(new Person(11, "lixiaolong"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
