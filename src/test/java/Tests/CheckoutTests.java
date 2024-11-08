package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CheckoutPage;
import Pages.HomePage;
import UITestFramework.FrameworkTest;

public class CheckoutTests   extends FrameworkTest{
	
	@Test
	public void selectInsurancePlanTest() throws InterruptedException
	{	
		HomePage homepage = new HomePage(driver);
		homepage.SelectPlan().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout/payment"), "Plan is not selected and not redirected to payment page");		
	}

	
	@Test
	public void checkOutVerificationTest() throws InterruptedException
	{	
		HomePage homepage = new HomePage(driver);
		String price = homepage.getFinalSummaryPrice();
		String planName = homepage.getPlanName();
		System.out.println(planName);
		homepage.SelectPlan().click();		
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout/payment"), "Plan is not selected and not redirected to payment page");
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		String chekoutPrice = checkoutPage.getInsuranceCheckoutPrice();
		System.out.println(chekoutPrice);
		Assert.assertEquals(price, chekoutPrice);
		String covergagePeriod = checkoutPage.getCoveragePeriod();
		Assert.assertEquals(covergagePeriod, "12 months");
		String providerName = checkoutPage.getProviderName();
		Assert.assertEquals(providerName, "ERGO");
		String checkoutplanName = checkoutPage.getPlanName();
		System.out.println(checkoutplanName);
		Assert.assertTrue(checkoutplanName.contains(planName),"Plan name is not matched");
		String datebefore= checkoutPage.getDateInsurance();
		checkoutPage.selectMinDate();			
		String dateafter = checkoutPage.getDateInsurance();
		Assert.assertEquals(datebefore, dateafter);
		checkoutPage.selectMaxDate();
		
		
		
		
			
			
	}

}
