package common;

import java.io.Serializable;

public class Person implements Serializable {
	
	public int age;
	public String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

}
