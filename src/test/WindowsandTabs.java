package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsandTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String parentwindow=driver.getWindowHandle();
		System.out.println("Before Click tab"+ parentwindow);
		
		WebElement tab =driver.findElement(By.id("tabButton"));
		
		tab.click();
		Set<String> allwin=driver.getWindowHandles();
		for (String win: allwin)
		{
			System.out.println(win);
			if (!win.equals(parentwindow))
			{
			
				driver.switchTo().window(win);
			}
		}
		WebElement childheader =driver.findElement(By.id("sampleHeading"));
		System.out.println(childheader.getText());
		driver.close();
		driver.switchTo().window(parentwindow);
		
		WebElement winbutton =driver.findElement(By.id("windowButton"));
		winbutton.click();
		
		driver.quit();

	}
	

}
