package StepDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomepageStepDefinitions {
	
protected static WebDriver driver;
	
static String ROOT = System.getProperty("user.dir");
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){
		 
		 System.setProperty("webdriver.chrome.driver",ROOT + "\\chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		 
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 14 Pro Max");  
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.bolttech.co.th/en/fwd/car-insurance/ctpl-insurance?utm_source=fwd&utm_medium=genesis");
      
		
	}
	
	@When("^Home page is loaded successfully$")
	public void home_page_is_loaded_successfully() {
	    
		Assert.assertTrue(driver.getCurrentUrl().contains("car-insurance/ctpl-insurance"), "Home page is not loaded successfully");		
    
	}

	@Then("^verify the prices shown in the cards$")
	public void verify_the_prices_shown_in_the_cards(){
		String price = getInsurancePersonalPrice();
		String finalprice = getFinalSummaryPrice();
		Assert.assertEquals(price, finalprice);
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
	
	@When("^Select any plan on the Home Page$")
	public void select_any_plan_on_the_Home_Page() {
		SelectPlan().click();	
	}

	@When("^Check out page is loaded successfully$")
	public void check_out_page_is_loaded_successfully(){
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout/payment"), "Plan is not selected and not redirected to payment page");

	}



	
	

}
