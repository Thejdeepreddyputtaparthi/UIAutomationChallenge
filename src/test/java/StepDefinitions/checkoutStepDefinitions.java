package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class checkoutStepDefinitions {
	
protected static WebDriver driver;
	
	
	@When("^Verify Insurance price on the checkout page$")
	public void verify_Insurance_price_on_the_checkout_page()  {
		String chekoutPrice = getInsuranceCheckoutPrice();
		System.out.println(chekoutPrice);
		//Assert.assertEquals(price, chekoutPrice);   
	    
	}

	@When("^Verify Insurance Coverage Period details$")
	public void verify_Insurance_Coverage_Period_details(){
		String covergagePeriod = getCoveragePeriod();
		Assert.assertEquals(covergagePeriod, "12 months");
	}

	@When("^Verify Insurance Coverage Provider details$")
	public void verify_Insurance_Coverage_Provider_details()  {
		String providerName = getProviderName();
		Assert.assertEquals(providerName, "ERGO");
	}

	@When("^Verify Insurance Coverage Plan name$")
	public void verify_Insurance_Coverage_Plan_name()  {		
		String checkoutplanName =  getPlanName();
		System.out.println(checkoutplanName);
		
	   
	}

	@When("^user Selects minimum date of plan$")
	public void user_Selects_minimum_date_of_plan() {
		String datebefore= getDateInsurance();
		selectMinDate();			
		String dateafter = getDateInsurance();
		Assert.assertEquals(datebefore, dateafter);
	
	}

	@Then("^user verifies the date is changed$")
	public void user_verifies_the_date_is_changed() {
		
    //Assert.assertEquals(datebefore, dateafter);
	    
	}

	@Then("^user Selects maximum date of plan$")
	public void user_Selects_maximum_date_of_plan() {
		selectMaxDate();
	}
	
	SearchContext shadow0 = driver.findElement(By.cssSelector("body > div:nth-child(3) > edi-fragment:nth-child(1) > edi-checkout:nth-child(1)")).getShadowRoot();
	SearchContext shadow1 = shadow0.findElement(By.cssSelector("edi-product-summary")).getShadowRoot();
	WebElement checkoutPrice =shadow1.findElement(By.cssSelector(".final-price"));
	
	SearchContext shadow2 = shadow0.findElement(By.cssSelector("edi-product-summary")).getShadowRoot();
	SearchContext shadow3 = shadow0.findElement(By.cssSelector(".form-component")).getShadowRoot();
	
	WebElement coveragePeriod = shadow2.findElement(By.cssSelector("#coverageEnd"));
	WebElement providerName  = shadow2.findElement(By.cssSelector("#providerName"));	
	WebElement planName = shadow2.findElement(By.cssSelector("#planName"));
	
	WebElement calendarClick = shadow3.findElement(By.cssSelector(".calendar-icon"));

	WebElement dateText = shadow3.findElement(By.cssSelector("#coverageStartInput"));
	

	
	
	public WebElement calendarClick()
	{
		return calendarClick;
	}
	
	public String getInsuranceCheckoutPrice()
	{	
		return checkoutPrice.getText();	
	}
	public String getCoveragePeriod()
	{	
		return coveragePeriod.getText();	
	}
	public String getProviderName()
	{	
		return providerName.getText();	
	}
	public String getPlanName()
	{	
		return planName.getText();	
	}
	public String getDateInsurance()
	{	
		return dateText.getText();	
	}
	public void selectMinDate()
	{			
		calendarClick().click();	
		SearchContext shadow4 = shadow3.findElement(By.cssSelector("#coverageStartDatepicker")).getShadowRoot();
		SearchContext shadow5 = shadow4.findElement(By.cssSelector("#datePicker")).getShadowRoot();
		SearchContext shadow6 = shadow5.findElement(By.cssSelector("#datePicker")).getShadowRoot();
		WebElement todayDate = shadow6.findElement(By.cssSelector(".each-days-of-month.is-today.chosen-days-of-month"));
		todayDate.click(); 
	}
	
	public void selectMaxDate()
	{			
		calendarClick().click();	
		SearchContext shadow4 = shadow3.findElement(By.cssSelector("#coverageStartDatepicker")).getShadowRoot();
		SearchContext shadow5 = shadow4.findElement(By.cssSelector("#datePicker")).getShadowRoot();
		SearchContext shadow6 = shadow5.findElement(By.cssSelector("#datePicker")).getShadowRoot();
		SearchContext shadow7 = shadow6.findElement(By.cssSelector("paper-icon-button[role='button'][icon='datepicker:chevron-right']")).getShadowRoot();
		WebElement nextIcon= shadow7.findElement(By.cssSelector("#icon"));
		nextIcon.click();

	}
	



}
