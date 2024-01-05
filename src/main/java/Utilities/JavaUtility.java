package Utilities;

import java.util.Random;

public class JavaUtility {
	
	public int generateRandom(int range) {
		Random random=new Random(500);
		int ranNumber=random.nextInt();
		return ranNumber;
	}

}
