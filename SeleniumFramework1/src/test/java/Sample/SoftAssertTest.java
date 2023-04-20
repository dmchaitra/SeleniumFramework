package Sample;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
@Test
public class SoftAssertTest {
	public void createContanct() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		SoftAssert soft=new SoftAssert();
	    soft.assertEquals(false, false);
	    System.out.println("step4");
		System.out.println("step5");
		soft.assertAll();
	}
}
