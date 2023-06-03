package dependsOn;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testdepends {
	
	//it would be good to use depends on sing testng then from using it from class level as if there are many class
	// and if there s any change then it would be hectic and confusing to c the things going in each class
	
	@Test(groups = "select")
	public void select() {
		System.out.println("select");
		Assert.fail();
	}
	
	@Test(groups = "buyNow")
	public void buyNow() {
		System.out.println("buyNow");
		
	}
	
	@Test(groups = "checkout")
	public void checkout() {
		System.out.println("checkout");
	}
	
	@Test(groups = "confirm")
	public void confirm() {
		System.out.println("confirm");
	}


}
