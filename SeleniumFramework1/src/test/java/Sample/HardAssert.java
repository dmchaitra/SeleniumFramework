package Sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	@Test
public void createContanct() {
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		Assert.assertEquals(false, false);
	}
	@Test
		public void deletContanct()	{
		System.out.println("step4");
		System.out.println("step5");
	}
	@Test
public void m1() {
	String extdata="dmc";
	String actdata="dma";
	Assert.assertEquals(actdata, extdata);
}

}
