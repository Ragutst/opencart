package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends basePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	WebElement myAct;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement registerLnk;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement loginLnk;
	
	public void clkMyaccount() {
		myAct.click();
	}
	
	public void clkRegister() {
		registerLnk.click();
	}
	
	public void clkLogin() {
		loginLnk.click();
	}

}
