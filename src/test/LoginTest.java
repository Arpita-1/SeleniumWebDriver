package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		/* Step1*/
		WebElement loginlink=driver.findElement(By.linkText("Log in"));
		loginlink.click();
		
		//step2: User Name
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");
		
		
		//Step3: Enter Password
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Test@1234");
		
		//Step4: Click on Login Button
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();
		
       // Step 5: RememberMe
		WebElement Rememberme = driver.findElement(By.className("rememberMe"));
		Rememberme.click();
		
        WebElement Error = driver.findElement(By.id("msg_box"));
		
		String ActError = Error.getText();
		String ExpError = "The email or password you have entered is invalid.";
		
		if(ActError.equals(ExpError)) {
			System.out.println("TC PAssed");
		}else {
			System.out.println("Tc Failed");
		}
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total num of links are " + Links.size());
		
		for(int index=0;index<Links.size();index++) {
			
			System.out.println(Links.get(index).getAttribute("href"));
			
		}
		
		
		//Step7: Close the browser
		driver.close();
		
		
		
	}

}
