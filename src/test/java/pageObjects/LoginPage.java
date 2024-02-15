package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends basePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement pswd;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	public void txtEmail(String txtEmail) {
		email.sendKeys(txtEmail);
	}
	
	public void txtPswd(String txtPswd) {
		pswd.sendKeys(txtPswd);
	}
	
	public void clkLoginBtn() {
		
		login.click();
		
	}

}
