package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void test_Account_Registration() throws InterruptedException {
		
		        logger.info("*** Application Started ***");
		        logger.info("Started the TC_001_AccountRegistrationTest Testcase");
				
				HomePage hp = new HomePage(driver);
				logger.info("My Account has been clicked");
				hp.clkMyaccount();
				logger.info("Clicked on Registration button to register new account");
				hp.clkRegister();
				
				AccountRegistrationPage ar = new AccountRegistrationPage(driver);
				logger.info("Entering the details on the Registration Page");
				ar.txtFstname(randomString().toUpperCase());
				ar.txtLstname(randomString().toUpperCase());
				ar.txtEmail(randomString()+"@gmail.com");
				ar.txtTel(randomNumber());
				String password = randomAlphaNumeric();
				ar.txtPswd(password);
				ar.txtConfmpswd(password);
				ar.clkAgree();
				logger.info("Clicking Continue button after the details has been entered");
				ar.clkCont();
				String confmsg=ar.getConfirmationMsg();
				logger.info("Validating the Confirmation Message with the actual result");
				Assert.assertEquals(confmsg, "Your Account Has Been Created!");
				
			
		
	}

}
