package javaProgramRunning;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adding_Items_TOCart {
	public static void main(String[] args) throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver= new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// identify the items that need to add to cart
		String[] itemsneed = { "Brocolli", "Cauliflower", "Cucumber", "Beetroot " };
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		additemsCart(driver,itemsneed);
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//img[@alt=\"Cart\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"action-block\"]/button[text()=\"PROCEED TO CHECKOUT\"]")).click();
		driver.findElement(By.xpath("//input[@class=\"promoCode\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[text()=\"Apply\"]")).click();
		
		String info=w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"promoInfo\"]"))).getText();
	    System.out.println(info);
	}

	public static void additemsCart(WebDriver driver, String[] itemsneed) {
		// find xpath of items to add cart
		int j=0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i = 0; i < products.size(); i++) {
			// we need to split the products & trim them

			String[] name = products.get(i).getText().split("-");
			String trimproduct = name[0].trim(); // now the product got trimed
			// we need to convert the array to array list
			List itemsneedList = Arrays.asList(itemsneed);

			if (itemsneedList.contains(trimproduct)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				 if(j==itemsneed.length) {
					 break;
				 }
			}

		}
	}
}
