package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountpage_logout {
WebDriver driver;
public MyAccountpage_logout(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
WebElement lnkLogout;

public void logout() {
	lnkLogout.click();
}
}