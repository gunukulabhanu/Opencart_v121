package TestBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public ResourceBundle rb;
	public Logger logger;
	
 @BeforeClass(groups= {"master","sanity","regression"})
  @Parameters({"browser"})
	public void setup(String br) {
	 logger=LogManager.getLogger(this.getClass());
	 rb=ResourceBundle.getBundle("configure");
    	if(br.equals("chrome")) {
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    	}
    	else if(br.equals("edge")) {
    		WebDriverManager.edgedriver().setup();
        	driver=new EdgeDriver();
    	}
    	else if(br.equals("firefox")) {
    		WebDriverManager.firefoxdriver().setup();
        	driver=new FirefoxDriver();
    	}
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	 
       @AfterClass(groups= {"master","sanity","regression"})
    	public void tearDown() {
			
    		driver.quit();
    	}
    public String randomestring() {
    	String emailgenrator=RandomStringUtils.randomAlphabetic(5);
    	return emailgenrator;
    	}
    public int randomestring1() {
    	String numbergenrator1=RandomStringUtils.randomNumeric(5);
    	return (Integer.parseInt(numbergenrator1));
    	}
    public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
	}
}
