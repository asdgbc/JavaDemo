package thinkinjava.c10;

import java.util.Random;

public class PetCount {

	private static Random random = new Random();
	static String[] typenames = new String[] { "Pet", "Dog", "Pug", "Cat", "Rodent", "Gerbil", "Hamster" };

	public static void main(String[] args) {
		Object[] pets = new Object[15];
		try {
			Class<?>[] petTypes = { Class.forName("thinkinjava.c10.Dog"), Class.forName("thinkinjava.c10.Pug"), Class.forName("thinkinjava.c10.Cat"), Class.forName("thinkinjava.c10.Rodent"),
					Class.forName("thinkinjava.c10.Gerbil"), Class.forName("thinkinjava.c10.Hamster") };
			for (int i = 0; i < pets.length; i++) {
				pets[i] = petTypes[random.nextInt(petTypes.length)].newInstance();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find class");
			System.exit(1);
		} catch (InstantiationException e) {
			System.out.println("Cannot instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Cannot access");
			System.exit(1);
		}

		AssociativeArray map = new AssociativeArray(typenames.length);
		for (int i = 0; i < typenames.length; i++) {
			map.put(typenames[i], new Counter());
		}
		for (int i = 0; i < pets.length; i++) {
			Object o = pets[i];
			if (o instanceof Pet) {
				((Counter) map.get("Pet")).i++;
			}
			if (o instanceof Dog) {
				((Counter) map.get("Dog")).i++;
			}
			if (o instanceof Pug) {
				((Counter) map.get("Pug")).i++;
			}
			if (o instanceof Cat) {
				((Counter) map.get("Cat")).i++;
			}
			if (o instanceof Rodent) {
				((Counter) map.get("Rodent")).i++;
			}
			if (o instanceof Gerbil) {
				((Counter) map.get("Gerbil")).i++;
			}
			if (o instanceof Hamster) {
				((Counter) map.get("Hamster")).i++;
			}
		}
		for (int i = 0; i < pets.length; i++) {
			System.out.println(pets[i].getClass());
		}
		System.out.println(map);
	}

}
