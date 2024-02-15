package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	public static WebDriver driver;
	
	public Logger logger; //For getting logs
	
	public ResourceBundle rb; // To use config.property file we use ResourceBundle predefined class
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters("browser")
	public void setup(String browser)
	
	      {
	
			rb = ResourceBundle.getBundle("config"); //getting url from config.properties file using ResourceBundle class
			
			logger=LogManager.getLogger(this.getClass()); //For getting logs use the following code
	
	
		    if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if(browser.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}          else {
			Assert.fail("Wrong Browser!");
		}
		    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() {
		
		driver.close();
		
	}
	
	
	//Dynamically adding data Methods
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() {
		String generatedNum = RandomStringUtils.randomNumeric(10);
		return generatedNum;
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(4);
		return st+"@"+num;
	}
	
	//For Taking screenshot with timestamp
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String des = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		
		try {
			
			FileUtils.copyFile(src, new File(des));
		} catch (Exception e) {
			e.getMessage();
		}
		return des;
	}

}
