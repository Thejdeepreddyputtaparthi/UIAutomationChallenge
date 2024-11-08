package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends ObjectPage {
	
	public HomePage(WebDriver webdriver)
	{
		super(webdriver);
		
	}
	
	
	SearchContext shadow0 = driver.findElement(By.cssSelector("edi-card-vertical[card-title='Personal Use']")).getShadowRoot();
	SearchContext shadow1 = shadow0.findElement(By.cssSelector("edi-card-vertical-content[fixed-height='false']")).getShadowRoot();
	SearchContext shadow2 = shadow1.findElement(By.cssSelector("edi-counter")).getShadowRoot();
	WebElement pricePersonal = shadow2.findElement(By.cssSelector("#counter"));
	
	
	SearchContext shadow4 = shadow1.findElement(By.cssSelector(".edi-submit-cta")).getShadowRoot();
	WebElement SelectPlan  = shadow4.findElement(By.cssSelector(".cta-text"));
	
	WebElement planName =  shadow1.findElement(By.cssSelector(".card-title"));
	
	public WebElement SelectPlan()
	{
		return SelectPlan;
	}
	
	public String getInsurancePersonalPrice()
	{
		
		return pricePersonal.getText();
		
	}
	SearchContext shadow3 = driver.findElement(By.cssSelector("edi-plan-compare[currency-symbol='฿']")).getShadowRoot();
	WebElement priceFinal = shadow3.findElement(By.cssSelector(" div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(22) > div:nth-child(1) > div:nth-child(2) > p:nth-child(1)"));

	public String getFinalSummaryPrice()
	{
		
		return priceFinal.getText();
		
	}
	public String getPlanName()
	{
		
		return planName.getText();
		
	}
	

}
