package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import UITestFramework.FrameworkTest;




public class PriceTests  extends FrameworkTest {
	
	@Test
	public void priveVerificationTest() throws InterruptedException
	{
	
		HomePage homepage = new HomePage(driver);	
		String price = homepage.getInsurancePersonalPrice();
		String finalprice = homepage.getFinalSummaryPrice();
		Assert.assertEquals(price, finalprice);
	}
   

}
