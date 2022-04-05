package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
WebDriver driver;

   public Homepage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
   @FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyaccount;
   @FindBy(linkText="Register")
   WebElement lnkregister;
   @FindBy(linkText="Login")
   WebElement lnkLogin;
   
   public void clickMyAccount() {
	   lnkMyaccount.click();
   }
   public void clickRegister() {
	   lnkregister.click();
   }
   public void clicklogin() {
	   lnkLogin.click();
   }
}


