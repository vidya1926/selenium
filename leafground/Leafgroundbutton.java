package leafground;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafgroundbutton {

	public static void main(String[] args) throws IOException {

		/*
		 * WebDriverManager.chromedriver().setup(); ChromeDriver driver = new
		 * ChromeDriver(); driver.get("http://www.leafground.com/");
		 * driver.manage().window().maximize(); Thread.sleep(3000);
		 * driver.findElement(By.xpath("//h5[text()='Radio Button']")).click();
		 * driver.findElement(By.id("yes")).click(); String path =
		 * "//label[text()='Find default selected radio button']/following::label";
		 * if(driver.findElement(By.xpath(path+"[1]")).isSelected()) {
		 * System.out.println(driver.findElement(By.xpath(path+"[1]")).getText()); }else
		 * { System.out.println(driver.findElement(By.xpath(path+"[2]")).getText()); }
		 * 
		 * String radio =
		 * "//label[contains(text(), 'Select your age group')]/following::input[2]";
		 * System.out.println(driver.findElement(By.xpath(radio)).getText());
		 * 
		 * if(driver.findElement(By.xpath(radio)).isSelected()) {
		 * System.out.println("came");
		 * System.out.println(driver.findElement(By.xpath(radio)).getText()); }
		 */







		/*
		 * WebDriverManager.chromedriver().browserVersion("91").setup(); ChromeDriver
		 * driver = new ChromeDriver();
		 * driver.get("http://www.leafground.com/pages/selectable.html");
		 * driver.manage().window().maximize(); List<WebElement>
		 * list=driver.findElements(By.xpath("//ol[@class='ui-selectable']")); Actions
		 * act=new Actions(driver);
		 * 
		 * act.clickAndHold(list.get(0)).clickAndHold(list.get(4)).release().build().
		 * perform();
		 * 
		 * Actions builder = new Actions(driver); WebElement item1 =
		 * driver.findElement(By.xpath("//li[text()='Item 1']")); WebElement item2 =
		 * driver.findElement(By.xpath("//li[text()='Item 2']")); WebElement item6 =
		 * driver.findElement(By.xpath("//li[text()='Item 6']"));
		 * //builder.clickAndHold(item1).clickAndHold(item2).clickAndHold(item6).perform
		 * ();
		 * builder.keyDown(Keys.CONTROL).click(item1).click(item2).click(item6).build().
		 * perform();
		 * 
		 */
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.myntra.com/");
		WebElement men = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(men).perform();
		
		driver.findElement(By.xpath("//a[text() = 'Jackets']")).click();
		
		String jacketsCount = driver.findElement(By.xpath("//span[@class = 'title-count']")).getText();
		System.out.println("Number of jackets present: " + jacketsCount);
		
		String replaceAll = jacketsCount.replaceAll("\\D", "");
		int jacketscountInt = Integer.parseInt(replaceAll);
		System.out.println(jacketscountInt);
		
		WebElement jackets = driver.findElement(By.xpath("(//label[@class = 'common-customCheckbox vertical-filters-label'])[1]/span"));
		String jackets1 = jackets.getText();
		// System.out.println(jackets);
		String jacketsReplace = jackets1.replaceAll("\\D", "");
		
		System.out.println(jacketsReplace);
		int jacketsInt = Integer.parseInt(jacketsReplace);
		
		String rainJacket = driver.findElement(By.xpath("(//label[@class = 'common-customCheckbox vertical-filters-label'])[2]/span")).getText();
		String rainJacketReplace = rainJacket.replaceAll("\\D", "");
		int rainJacketInt = Integer.parseInt(rainJacketReplace);
		
		int totalJackets = jacketsInt + rainJacketInt;
		if (jacketscountInt == totalJackets) {
			
			System.out.println("Jacket Count Matches");
			
		} else {
			System.out.println("Jacket Count not Matches");
		}
		jackets.click();
		
	    driver.findElement(By.xpath("//div[@class='brand-more']")).click();
	
		driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']/input")).sendKeys("duke"+ Keys.ENTER);
		driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div")).click();
		
		driver.findElement(By.xpath("//div[@class='FilterDirectory-titleBar']//span")).click();
		
		String brandName = driver.findElement(By.xpath("//div[@class='product-productMetaInfo']/h3")).getText();
		System.out.println(brandName);
		List<String> dukeBrand = new ArrayList<String>();
		dukeBrand.add(brandName);
		//String dukeBrand1 = dukeBrand.get(0);
		String Brand = "Duke";
	
		if(dukeBrand.contains(Brand)) //to compare list element with string use .contains
		{
			System.out.println("Brand is Duke");
		}
		else {
			System.out.println("Brand name is not duke");
		}
		 //driver.findElement(By.xpath("(//ul[@class='sort-list']//label[@class='sort-label '])[2]/input")).click();
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		sort.click();
	

		WebElement sortBy = driver.findElement(By.xpath("(//ul[@class = 'sort-list']//label)[3]"));
				Actions action = new Actions(driver);
		action.moveToElement(sortBy).click().perform();
		
		WebElement discountPrice = driver.findElement(By.xpath("//div[@class = 'product-price']/span/span"));
		String discountPrice1 = discountPrice.getText();
		System.out.println("First displayed dicount price is: " + discountPrice1 );
		discountPrice.click();
		
	    Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<String>(windowHandles);
        driver.switchTo().window(windowList.get(1));
       // TakesScreenshot scrShot =((TakesScreenshot)driver);
        
    File src1 = driver.getScreenshotAs(OutputType.FILE); // the page that has to be taken screen shot
	File dst = new File("./snaps/seat.png");
	FileUtils.copyFile(src1, dst);
        
		
		//driver.findElement(By.xpath("(//ul[@class='sort-list']/li)[3]//input")).click();
        driver.findElement(By.xpath("//span[@class = 'myntraweb-sprite pdp-notWishlistedIcon sprites-notWishlisted pdp-flex pdp-center ']/following-sibling::span")).click();
        driver.quit();
	}

}
