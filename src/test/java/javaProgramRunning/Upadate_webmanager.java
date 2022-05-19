package javaProgramRunning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upadate_webmanager {

	public static void main(String[] args) {
		ChromeOptions opt= new ChromeOptions();
		opt.setHeadless(true);
		//previously for system.getproperty
		//WebDriverManager.chromedriver().setup();
   WebDriver driver= WebDriverManager.chromedriver().capabilities(opt).create();  
   driver.get("https://www.google.com/");
   System.out.println(driver.getCurrentUrl());
   driver.quit();
    
     
	}

}
