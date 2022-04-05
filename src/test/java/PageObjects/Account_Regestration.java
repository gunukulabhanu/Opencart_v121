package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_Regestration {

	WebDriver driver;
	public Account_Regestration(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="firstname")
	WebElement txtfirstname;
	@FindBy(name="lastname")
	WebElement txtlastname;
	@FindBy(name="email")
	WebElement txtemail;
	@FindBy(name="telephone")
	WebElement txtnumber;
	@FindBy(name="password")
	WebElement txtpassword;
	@FindBy(name="confirm" )
	WebElement txtconfirmpwd;
    @FindBy(name="agree")
    WebElement clickpolicy;
    @FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
    public void firstname(String fname) {
    	txtfirstname.sendKeys(fname);
    	}
    public void lastname(String lname ) {
    	txtlastname.sendKeys(lname);
    }
    public void email(String mail) {
    	txtemail.sendKeys(mail);
    }
    public void pnumber(String telnum) {
    	txtnumber.sendKeys(telnum);
    }
    public void password(String pass) {
    	txtpassword.sendKeys(pass);
    }
    public void confirmpwd(String cpwd) {
    	txtconfirmpwd.sendKeys(cpwd);
    }
    public void policy() {
    	clickpolicy.click();
    }
    public void continueclick( ) {
    	btnContinue.click();
    }
    public String getconfirmation() {
    try {
    	return(msgConfirmation.getText());
    }
catch(Exception e) {
	return (e.getMessage());
}
    }
	
	
}
