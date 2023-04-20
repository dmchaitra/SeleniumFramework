package Sample;

import org.testng.annotations.Test;

@Test
public class SampleTestNG {
	
//@Test(priority=1)
	@Test(invocationCount=4)
public void creatcontact()
{
	System.out.println("creat contact");
}
	//@Test(priority=2)

public void modifycontact()
{
	System.out.println("modify contact");
}
	//@Test(priority=3)
public void deletcontact()
{
	System.out.println("delet contact");
}
}
