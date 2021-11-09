package leafground;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions Options=new ChromeOptions();
				Options.addArguments("--disable-notification");
				ChromeDriver driver=new ChromeDriver();		
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("https://www.myntra.com/");
				
				
				
				//mousehover method 
				Actions actions = new Actions(driver);
				WebElement target = driver.findElement(By.xpath("(//a[@class='desktop-main'])[2]"));
				actions.moveToElement(target).perform();
				
				
				
				
				
				
				
				driver.findElement(By.linkText("Jackets & Coats")).click();	
				String  Totcnt= driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
				
			//String Totcnt = driver.findElement(By.xpath("//*[@id='mountRoot']/div/div[1]/main/div[2]/div/span")).getText();
				System.out.println("The Total Count is  "+Totcnt);
				
				
				
			String 	total=Totcnt.replaceAll("\\D", "");
		         int tc=Integer.parseInt(total);
		         
		       //*[@id="mountRoot"]/div/div[1]/main/div[3]/div[1]/section/div/div[3]/div[2]     
		         
		      //h3[@class=''] 
				String j = driver.findElement(By.xpath("//input[@value='Jackets']/following-sibling::span[1]")).getText();
				System.out.println(j);
				String j1=j.replaceAll("\\D","");
				String c = driver.findElement(By.xpath("//input[@value='Coats']/following-sibling::span[1]")).getText();
				System.out.println(c);
				String c1=c.replaceAll("\\D","");
				int a;
				int b;
				int sum=0;
				a=Integer.parseInt(j1);
				b=Integer.parseInt(c1);
				sum=Integer.sum(a, b);
				 System.out.println("The Categories count is  = " + Integer.sum(a, b)); 
				if(tc==sum)
			{System.out.println("The total count and the categories count matches");
			}
			driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]")).click();
			//driver.findElement(By.xpath("//div[text()='57']")).click();
			driver.findElement(By.className("brand-more")).click();
			
			driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Mango");

			driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div[1]")).click();
			driver.findElement(By.xpath("//*[@id='mountRoot']/div/div[1]/main/div[3]/div[1]/section/div/div[3]/div[3]/div[1]/span")).click();
			WebElement brandmango=driver.findElement(By.className("filter-summary-filter"));
				System.out.println("Confirmed that all the coats are of same brand MANGO" +brandmango.getText());
			WebElement target1= driver.findElement(By.xpath("//div[text()='Sort by : ']"));
			actions.moveToElement(target1).perform();
				//*[@id="desktopSearchResults"]/div[2]/section/ul/li[1]/a/div[1]/div
				driver.findElement(By.xpath("(//label[@class='sort-label '])[3]")).click();
			String rs = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
			System.out.println(rs);		
		   WebElement target2=driver.findElement(By.xpath("//*[@id='desktopSearchResults']/div[2]/section/ul/li[1]/a/div[1]/div"));
			actions.moveToElement(target2).perform();
			driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[2]/section/ul/li[1]/div[3]/span")).click();
		  
			
			
	}

}
