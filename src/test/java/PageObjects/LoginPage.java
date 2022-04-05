package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
    @FindBy(name="password")
    WebElement pwd;
    
    @FindBy(xpath="//input[@type='submit']")
    WebElement login;
    
    @FindBy(xpath="//h2[text()='My Account']")
    WebElement msgHeading;
    
    public void setEmail(String Logemail) {
    	email.sendKeys(Logemail);
    }
    public void setPwd(String Logpwd) {
    	pwd.sendKeys(Logpwd);
    }
    public void Clicklogin() {
    	login.click();
    }
    public boolean isMyAccountPageExist() {
    	try {
    	return(msgHeading.isDisplayed());
    	}
    	catch(Exception e) {
    		return (false);
    	}
    }
}
