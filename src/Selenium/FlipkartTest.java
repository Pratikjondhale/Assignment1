package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartTest {
	
	static WebDriver driver;
	
	public void openFlipkart() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\PRATIK\\MY DATA\\PERSONAL TRAINING\\AUTOMATION\\driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}
	
	public void login() throws InterruptedException{
		driver.findElement(By.className("_2zrpKA")).click();
		driver.findElement(By.className("_2zrpKA")).sendKeys("gauravajain@gmail.com");
		
		driver.findElement(By.xpath("//input[@type='password']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("gaurav1234");
		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
		Thread.sleep(2000);
	}
	
	public void verifyMenu() {
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8']")).getText(), "Electronics", "Electronics menu not found");
	}
	
	public void verifyMobilePage()
	{
		driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8']")).click();
		driver.findElement(By.linkText("Mobiles")).click();
		Assert.assertTrue(driver.findElement(By.className("_30P0WS")).getText().contains("Mobile phones"), "page not found");
		
	}
	
	public void verifyRam()
	{
		driver.findElement(By.xpath("//div[@title='4 GB']")).click();
	}
	
	public void findBrand() throws InterruptedException
	{
		driver.findElement(By.className("_3vKPvR")).click();
		driver.findElement(By.className("_3vKPvR")).sendKeys("Moto");
		driver.findElement(By.xpath("//div[@title='Motorola']")).click();
		Thread.sleep(5000);
	}
	
	public void verifyBrand() throws InterruptedException
	{
		//driver.findElement(By.className("_3vKPvR")).click();
		//driver.findElement(By.className("_3vKPvR")).clear();
		//driver.findElement(By.className("_3vKPvR")).sendKeys(Keys.CONTROL+"a");
		//driver.findElement(By.className("_3vKPvR")).sendKeys("Moto");
	    //driver.findElement(By.xpath("//div[@title='Motorola']")).findElement(By.xpath("//input[@type='checkbox']")).click();
	    //Thread.sleep(5000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		System.out.println(elements.get(0).getText());
		Assert.assertTrue(elements.get(0).getText().contains("Moto"), "Filter0 results invalid");
		System.out.println(elements.get(1).getText());
		Assert.assertTrue(elements.get(1).getText().contains("Moto"), "Filter1 results invalid");
	}
	
	public void clearFilter() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[@title='Motorola']")).click();
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		System.out.println(elements.get(0).getText());
		Assert.assertFalse(elements.get(0).getText().contains("Moto"), "Filter0 results invalid");
		System.out.println(elements.get(1).getText());
		Assert.assertFalse(elements.get(1).getText().contains("Moto"), "Filter1 results invalid");
	}
	
	public void selectMobile() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@title='Motorola']")).click();
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_31qSD5']"));
		String url = elements.get(0).getAttribute("href");
		System.out.println(url);
		driver.get(url);
	}
	
	@Test
	public void TestFlipkart() throws InterruptedException {

		openFlipkart();
		login();
		verifyMenu();
		verifyMobilePage();
		verifyRam();
		findBrand();
		verifyBrand();
		clearFilter();
		selectMobile();
	}

}
