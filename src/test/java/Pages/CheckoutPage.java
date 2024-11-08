package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutPage  extends ObjectPage{

	public CheckoutPage(WebDriver webdriver)
	{
		super(webdriver);
		
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
