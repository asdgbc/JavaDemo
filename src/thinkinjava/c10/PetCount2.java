package thinkinjava.c10;

import java.util.Random;

public class PetCount2 {
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
			if (o instanceof Pet) {
				((Counter) map.get("class thinkinjava.c10.Pet")).i++;
			}
			if (o instanceof Dog) {
				((Counter) map.get("class thinkinjava.c10.Dog")).i++;
			}
			if (o instanceof thinkinjava.c10.Pug) {
				System.out.println("wakaka");
				((Counter) map.get("class thinkinjava.c10.Pug")).i++;
			}
			if (o instanceof Cat) {
				((Counter) map.get("class thinkinjava.c10.Cat")).i++;
			}
			if (o instanceof Rodent) {
				((Counter) map.get("class thinkinjava.c10.Rodent")).i++;
			}
			if (o instanceof Gerbil) {
				((Counter) map.get("class thinkinjava.c10.Gerbil")).i++;
			}
			if (o instanceof Hamster) {
				((Counter) map.get("class thinkinjava.c10.Hamster")).i++;
			}
		}
		for (int i = 0; i < pets.length; i++) {
			System.out.println(pets[i].getClass());
		}
		System.out.println(map);
	}
}
