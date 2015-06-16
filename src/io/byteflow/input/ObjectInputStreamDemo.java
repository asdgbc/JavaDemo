package io.byteflow.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import common.Person;

public class ObjectInputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File outputFile = new File("F:\\student.txt");
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(outputFile));
			Person p = (Person) ois.readObject();
			System.out.println(p.name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
