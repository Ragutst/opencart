package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"regression","master"})
	public void test_login() {
		
		logger.info("***** TC_002_Login Test Started *****");
		
		try {
		
		HomePage hp = new HomePage(driver);
		logger.info("***** Clicking My Account *****");
		hp.clkMyaccount();
		logger.info("***** Clicking Login Button *****");
		hp.clkLogin();
		
		LoginPage lp = new LoginPage(driver);
		logger.info("***** Entering the Login Details *****");
		lp.txtEmail(rb.getString("email"));
		lp.txtPswd(rb.getString("password"));
		logger.info("***** Clicking Login Button *****");
		lp.clkLoginBtn();
		
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetMsg = mp.myAcctHeadingDisplayed();
		Assert.assertEquals(targetMsg, true,"Invalid! Account Not Matching");
		
	} catch (Exception e) {
		
		Assert.fail();
	}
		
		logger.info("***** TC_002_Login Test Completed *****");

}
	
}
