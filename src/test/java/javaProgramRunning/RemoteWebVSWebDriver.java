package javaProgramRunning;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebVSWebDriver {

	public static void main(String[] args) {
RemoteWebDriver driver= new ChromeDriver();
driver.get("https://drive.google.com/drive/folders/1kZvlb4a56W4WjA4A0VvByFRQHhc1nqJN");
	}

}
