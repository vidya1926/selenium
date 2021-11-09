package leafground;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class leafgroundchk {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    
	    ChromeDriver driver= new ChromeDriver();
	    
	    //Load the Url
	    driver.get("http://www.leafground.com/pages/checkbox.html");
	    
	    //Maximize the webpage
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//label[@for='java']/following::input[2]")).click();
	}

}
