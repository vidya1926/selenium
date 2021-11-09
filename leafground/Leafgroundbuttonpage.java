package leafground;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafgroundbuttonpage {

	public static void main(String[] args) {
		//Driver setup
		WebDriverManager.chromedriver().setup();
		//crating the instance for the driver
		ChromeDriver driver=new ChromeDriver();
		
		//load the url
		driver.get("http://www.leafground.com/pages/Button.html");
		
		//maximize the window
		driver.manage().window().maximize();
		//click the button and verify the navigation
		driver.findElement(By.id("home")).click();
		String title = driver.getTitle();		
		System.out.println(title);
		
		//to get back to the homepage (bond with buttons)
		//driver.navigate().back();
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
		
		driver.getCurrentUrl();
		
		//To get the position of the button
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println(location);
		
		WebElement whatColorAm = driver.findElement(By.id("color"));
		System.out.println(whatColorAm.getAttribute("style"));
		
		
	}

}
