package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Homepage;
import PageObjects.LoginPage;
import PageObjects.MyAccountpage_logout;
import TestBase.BaseClass;
import Utilities.XlUtility;

public class TC_003_loginDDT extends BaseClass
{
	@Test(dataProvider="loginData")
	public void Test_ddt( String email,String pwd,String expted ) {
		
		logger.info("application with ddt is started");
		try {
		
		driver.get(rb.getString("appURL"));
		logger.info("homepage is opned");
		driver.manage().window().maximize();
		
		Homepage hp= new Homepage(driver);
		hp.clickMyAccount();
		logger.info("Account link is clicked");
		
		hp.clicklogin();
		logger.info(" login link clicked");
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		logger.info("email entered");
		
		lp.setPwd(pwd);
		logger.info("pwd entered");
		
		lp.Clicklogin();
		logger.info("login clicked");
		
		boolean target= lp.isMyAccountPageExist();
		
		if(expted.equals("Valid")) 
		{
			if(target==true)
			{
				logger.info("login successful");
				MyAccountpage_logout logoutobj= new MyAccountpage_logout(driver);
				logoutobj.logout();
				Assert.assertTrue(true);
			}
			else {
				logger.info("login failed = valid");
				Assert.assertTrue(false);
			     }
			}
		
		if(expted.equals("Invalid")) 
		{
			if(target==true) 
			{
				logger.error("Login should failed");
				MyAccountpage_logout logoutobj= new MyAccountpage_logout(driver);
				logoutobj.logout();
				Assert.assertTrue(false);
			}
			else
			{
				logger.info("login Failed ");
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			logger.fatal("login failed -Excepetion");
			Assert.fail();
			
		}
		
	}
	@DataProvider(name="loginData")
	    public String[][] getData() throws IOException 
	  {
		   String path=".\\TestData\\Opencart_LoginData.xlsx";
		   XlUtility exclfle= new XlUtility(path);
		   // getting the row-count & cell-count
		   int rowcnt=exclfle.getRowCount("Sheet1");
	       int cellcnt=exclfle.getCellCount("Sheet1", 1);
	       // creating 2d array for storing data in logindata array getting from open cart excel file
		   String Logindata[][]= new String [rowcnt][cellcnt];
		
		     for(int r=1;r<=rowcnt;r++)  // for row 
		     {
		          for(int c=0;c<cellcnt;c++)  // for column 
			       {
				     Logindata[r-1][c]=exclfle.getCellData("Sheet1", r, c); //Assigning the values to logindata from utlity file
				   }
			  }
		         return Logindata;
		}
	
		
	}
	


