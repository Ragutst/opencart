package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends basePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()=\"My Account\"]")
	WebElement msgHeading;
	
	@FindBy(xpath="(//a[@class='list-group-item'])[13]")
	WebElement logoutBtn;
	
	public boolean myAcctHeadingDisplayed() {
		try {
			
			return msgHeading.isDisplayed();
		} catch(Exception e) {
			
			return false;
		}
	}
	
	public void logoutBtn() {
		logoutBtn.click();
	}

}
