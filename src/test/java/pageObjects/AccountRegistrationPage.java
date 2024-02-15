package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends basePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(name="firstname")
	WebElement fstName;
	
	@FindBy(name="lastname")
	WebElement lstName;
	
	@FindBy(name="email")
	WebElement txtMail;
	
	@FindBy(name="telephone")
	WebElement txtTel;
	
	@FindBy(name="password")
	WebElement txtPswd;
	
	@FindBy(name="confirm")
	WebElement confmPswd;
	
	@FindBy(name="agree")
	WebElement agreeBtn;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement clkContinue;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	WebElement msgConfirmation;
	
	//Action Methods
	public void txtFstname(String fstname) {
		fstName.sendKeys(fstname);
	}
	
	public void txtLstname(String lstname) {
		lstName.sendKeys(lstname);
	}
	
	public void txtEmail(String mailid) {
		txtMail.sendKeys(mailid);
	}
	
	public void txtTel(String txttel) {
	    txtTel.sendKeys(txttel);
	}
	
	public void txtPswd(String pswd) {
		txtPswd.sendKeys(pswd);
	}
	
	public void txtConfmpswd(String confmpswd) {
		confmPswd.sendKeys(confmpswd);
	}
	
	public void clkAgree() {
		agreeBtn.click();
	}
	
	public void clkCont() {
		clkContinue.click();
	}
	
	public String getConfirmationMsg(){

		   try{
		      return (msgConfirmation.getText());
			  } catch (Exception e) {
			       return (e.getMessage());
				   }
				}
				
 }
