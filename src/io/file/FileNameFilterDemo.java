package io.file;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FileNameFilterDemo {

	public static void main(String[] args) {
		File file = new File("F:\\Corinna Magic River (FJ).rar");
		Class<File> cls = File.class;
		Method[] methods = cls.getMethods();
		for (int i = 0; i < methods.length; i++) {
			try {
				if (methods[i].getName().startsWith("get")&&methods[i].getName().contains("Path")) {
					System.out.println(methods[i].getName()+":"+methods[i].invoke(file));
				}
				
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			}
		}
	
	}
}
