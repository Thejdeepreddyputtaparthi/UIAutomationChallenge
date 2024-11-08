
package UITestFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


public class FrameworkTest {
	
protected static WebDriver driver;


static String ROOT = System.getProperty("user.dir");
static String xlFilePath = ROOT +"\\TestData.xlsx"; 
static String SheetName = "Datasheet";
public  String Res;  
public int DataSet=-1;


	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",ROOT + "\\chromedriver.exe");
		
		 ChromeOptions chromeOptions = new ChromeOptions();
		 chromeOptions.addArguments("--remote-allow-origins=*");
		 
		 driver = new ChromeDriver(chromeOptions);
		 
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 14 Pro Max");  
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.bolttech.co.th/en/fwd/car-insurance/ctpl-insurance?utm_source=fwd&utm_medium=genesis");
      
		
		
	}
	
}
	