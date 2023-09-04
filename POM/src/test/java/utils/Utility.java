package utils;

import java.time.Duration;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;
import testbase.WebTestBase;

public class Utility extends WebTestBase {
	public static void selectValue(WebElement Element, String term, String value) 
	{
		// TODO Auto-generated method stub
		Select dropDown = new Select(Element);
		if(term.equalsIgnoreCase("byValue")){
            dropDown.selectByValue(value);
        }else if(term.equalsIgnoreCase("byIndex")){
            dropDown.selectByIndex(Integer.parseInt(value));
        }else if(term.equalsIgnoreCase("byVisibleText")){
            dropDown.selectByVisibleText(value);
        }else{
            System.out.println("Please select the correct value");
        }
	}

	public static void mouseHover(WebDriver driver, WebElement element){
        Actions action=new Actions(driver);
        action.moveToElement(element)
                .build()
                .perform();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

	public static void scrollDownMethod(WebDriver driver, WebElement youtubeOption) {
		// TODO Auto-generated method stub
		
	}
	
	public static void scrollDownByElement(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

	public static void switchToWindows(WebDriver driver) throws InterruptedException {
        String parentWindows = driver.getWindowHandle();//parent Id==1
        Set<String> allWindow = driver.getWindowHandles();//Parent+child<1,2>
        for (String s : allWindow) {
        	//child Id
            if (!parentWindows.contentEquals(s)) {
                driver.switchTo().window(s);
                driver.close();
                Thread.sleep(5000);
            }
          
        }
        driver.switchTo().window(parentWindows);
        Thread.sleep(5000);
    }

	public static void getCookies() {
		// TODO Auto-generated method stub
		  Set<Cookie> cookies = driver.manage().getCookies();
	        for (Cookie c : cookies){
	            System.out.println(c);
	}
	
	}
}
