package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement clickme1 =driver.findElement(By.id("alertButton"));
		clickme1.click();
		Alert alert=driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.accept();
	
	/*WebElement clickme2 =driver.findElement(By.id("timerAlertButton"));
	clickme2.click();
	alert=driver.switchTo().alert();
    System.out.println(alert.getText());
      alert.accept();*/
      
      WebElement clickme3 = driver.findElement(By.id("confirmButton"));
  	clickme3.click();
  	
  	alert = driver.switchTo().alert();
  	System.out.println(alert.getText());
  	alert.dismiss();
  	
  WebElement clickme4 = driver.findElement(By.id("promtButton"));
  JavascriptExecutor obj =  (JavascriptExecutor) driver;
  obj.executeScript("arguments[0].click();", clickme4);
  //clickme4.click();

  alert = driver.switchTo().alert();
  System.out.println(alert.getText());

  alert.sendKeys("Hello World");
  alert.accept();	
	

	}

}
