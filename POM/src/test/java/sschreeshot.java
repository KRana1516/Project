import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sschreeshot {

	public static void main(String[] args) throws IOException {
	 	WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver	 driver=new ChromeDriver();
		
		
		driver.get("https://www.facebook.com/");
      driver.manage().window().maximize();
      
      TakesScreenshot tk=(TakesScreenshot) driver;
      File source=tk.getScreenshotAs(OutputType.FILE);
      File des=new File("D:/pic.jpg");
      FileUtils.copyFile(source, des);
	}

}
