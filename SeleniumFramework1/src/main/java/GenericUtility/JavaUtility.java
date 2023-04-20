package GenericUtility;

import java.util.Random;

public class JavaUtility {
	
	public int getRandomNum() 
	{
		Random ran=new Random();
		int RanNum=ran.nextInt(1000);
		
		return RanNum;
		
	}
}
