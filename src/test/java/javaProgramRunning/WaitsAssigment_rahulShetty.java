package javaProgramRunning;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsAssigment_rahulShetty {

	public static void main(String[] args) throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver= new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.manage().window().maximize();
		  driver.get("https://rahulshettyacademy.com/angularpractice/shop");
          Thread.sleep(3000);
          WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(7000));
		   String[] phones = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry " };

		  
		  //coding
		  List<WebElement> items=driver.findElements(By.xpath("//div[@class=\"card-body\"]/h4[@class]/a"));
		  
		 
		  for (int i=0;i<=items.size();i++) {
			  String name = items.get(i).getText();
			  System.out.println(name);
			  
			//  List<String> listitems=Arrays.asList(phones);
			  //if (listitems.equals(name)) {
				 
				//  driver.findElement(By.xpath("//button[@class=\"btn btn-info\"]")).click();
				  
			  }
			  
		  }
	}
	

