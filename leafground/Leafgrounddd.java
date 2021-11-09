package leafground;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafgrounddd {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
        driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		driver.manage().window().maximize();
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//driver.findElement(By.linkText("Drop down")).click();

		WebElement webElement1 = driver.findElement(By.id("dropdown1"));
		Select drpDown1 = new Select(webElement1);
		drpDown1.selectByVisibleText("Selenium");
		drpDown1.selectByIndex(1);
		Thread.sleep(2000);
		
		drpDown1.selectByValue("1");
		
		WebElement webElement2 = driver.findElement(By.name("dropdown2"));
		Select drpDown2 = new Select(webElement2);
		drpDown2.selectByValue("2");

		WebElement webElement3 = driver.findElement(By.id("dropdown3"));
		Select drpDown3 = new Select(webElement3);
		drpDown3.selectByVisibleText("Loadrunner");

		WebElement webElement4 = driver.findElement(By.className("dropdown"));
		Select drpDown4 = new Select(webElement4);
		drpDown4.selectByVisibleText("Loadrunner");

		
		
     WebElement findElement = driver.findElement(By.xpath("//select/option[text()='Select your programs']/following-sibling::option"));
		
     Select allOptions = new Select(findElement);
     System.out.println(allOptions.getOptions()); 
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 * driver.findElement(By.
		 * xpath("//option[text()='Select your programs']/following-sibling::option[2]")
		 * ).click(); driver.findElement(By.
		 * xpath("//option[text()='Select your programs']/following-sibling::option[3]")
		 * ).click();
		 * 
		 * driver.findElement(By.
		 * xpath("//option[text()='Select your programs']/following-sibling::option[4]")
		 * ).click();
		 */		
	
}
}