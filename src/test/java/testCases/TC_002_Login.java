package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Homepage;
import PageObjects.LoginPage;
import TestBase.BaseClass;

public class TC_002_Login extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void loginPage() {
		logger.info("starting the login ");
		try {
		driver.get(rb.getString("appURL"));
		logger.info("Homepage displayed ");

		driver.manage().window().maximize();
		
		Homepage hp= new Homepage(driver);
		
		hp.clickMyAccount();
		logger.info("My account clicked");
		
		hp.clicklogin();
		logger.info("login link clicked");
		
		LoginPage lp= new LoginPage(driver);
		
		
		lp.setEmail(rb.getString("email"));
		logger.info("  email entered");
		
	     lp.setPwd(rb.getString("password"));
	    logger.info("password is provided");
	    
	    lp.Clicklogin();
	    logger.info("login is clicked");
	    
	    boolean target=lp.isMyAccountPageExist();
	    if(target) {
	    	logger.info("login is successfull");
	    	Assert.assertTrue(true);
	    	 }
	    else {
	    	logger.info("login is failed");
	    	Assert.assertTrue(false);
	    }
		}
		catch(Exception e) {
			logger.fatal("login failed");
			Assert.fail();
			
		}
		logger.info("test login is completed");
	}

}
