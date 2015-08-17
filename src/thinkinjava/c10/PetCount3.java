package thinkinjava.c10;

import java.util.Random;

public class PetCount3 {
	private static Random random = new Random();

	public static void main(String[] args) {
		Object[] pets = new Object[15];
		Class<?>[] petTypes = { Pet.class, Dog.class, Pug.class, Cat.class, Rodent.class, Gerbil.class, Hamster.class };
		try {
			for (int i = 0; i < pets.length; i++) {
				int rnd = 1 + random.nextInt(petTypes.length - 1);
				pets[i] = petTypes[rnd].newInstance();
			}
		} catch (InstantiationException e) {
			System.out.println("Cannot instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("Cannot access");
			System.exit(1);
		}
		AssociativeArray map = new AssociativeArray(petTypes.length);
		for (int i = 0; i < petTypes.length; i++) {
			map.put(petTypes[i].toString(), new Counter());
		}
		for (int i = 0; i < pets.length; i++) {
			Object o = pets[i];
			for (int j = 0; j < petTypes.length; j++) {
				if (petTypes[j].isInstance(o)) {
					((Counter) map.get(petTypes[j].toString())).i++;
				}
			}
		}
		for (int i = 0; i < pets.length; i++) {
			System.out.println(pets[i].getClass());
		}
		System.out.println(map);
	}

}
