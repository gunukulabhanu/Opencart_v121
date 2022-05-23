package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jenkinchecking {
	@Parameters("Browser")
	@Test
	public void startBrowser(String browsername) {
		System.out.println("parameter value :"+browsername );
		 WebDriver driver=null;

		if(browsername.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			}
		else if(browsername.contains("Edge")){
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			}
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/");
		Assert.assertTrue(driver.getTitle().contains("Orange"));
		System.out.println("Browser is successful");
	    driver.quit();
	}
}
