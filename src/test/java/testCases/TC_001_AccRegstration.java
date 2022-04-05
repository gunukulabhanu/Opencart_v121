package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Account_Regestration;
import PageObjects.Homepage;
import TestBase.BaseClass;

public class TC_001_AccRegstration extends BaseClass {
	
	@Test(groups= {"master","regression"})
	public void test_Account_reg() {
		try {
		
		logger.info("staring the application");
		driver.get(rb.getString("appURL"));
		logger.info("Home Page Displayed ");
		driver.manage().window().maximize();
		Homepage hp= new Homepage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account ");
		hp.clickRegister();
		logger.info("Clicked on Register ");
		

		Account_Regestration regpage= new Account_Regestration(driver);
		
		regpage.firstname("shiva");
		logger.info("Provided First Name ");
		
		regpage.lastname("thota");
		logger.info("Provided Last Name ");

		regpage.email(randomestring()+"@gmail.com");
		logger.info("Provided Email ");

		regpage.pnumber("1234567890");
		logger.info("Provided Telephone ");
		
		regpage.password(rb.getString("password"));
		logger.info("Provided Password ");

		regpage.confirmpwd(rb.getString("password"));
		logger.info("Provided Confrmed Password ");

		regpage.policy();
		logger.info("Set Privacy Policy ");
		regpage.continueclick();
		logger.info("Clicked on Continue ");

		String confrimMsg=regpage.getconfirmation();
		if(confrimMsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration succefull ");
			Assert.assertTrue(true);
			
		}
		else {
			logger.error("Account Registration Failed ");
			captureScreen(driver, "test_Account_reg");
			Assert.assertTrue(false);
			
         }
		}
		catch(Exception e) {
			
			logger.fatal("Account Registration Failed ");
			Assert.fail();
		}
		logger.info("Finishes the Registration test_case");
		}
		
		}
	
		
	
	

