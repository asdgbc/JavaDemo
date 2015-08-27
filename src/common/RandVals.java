package common;

import java.util.Random;

public interface RandVals {
	//接口中定义的变量都是final和static的，自动声明为public
	Random rand = new Random();
	int randomInt = rand.nextInt(10);
	long randomLong = rand.nextLong()*10;
	
	//自动声明为public
	void play();
}
