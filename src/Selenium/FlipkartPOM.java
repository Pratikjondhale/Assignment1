package Selenium;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartPOM {
	
	private static WebDriver driver = null;
	static Properties prop = null;
	
	@BeforeMethod
	public void openFlipkart() throws Exception {
		
		prop = Configuration.getConfiguration();
		
		switch(prop.getProperty("browser")) 
		{
			case "chrome":
				System.setProperty("webdriver.chrome.driver","C:\\PRATIK\\MY DATA\\PERSONAL TRAINING\\AUTOMATION\\driver\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				System.setProperty("webdriver.gecko.driver","C:\\PRATIK\\MY DATA\\PERSONAL TRAINING\\AUTOMATION\\driver\\geckodriver-v0.22.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
					
            default:
            	throw new Exception("Wrong browser");
		}
		
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		//driver.close();
	}
	
	@Test(description="Requirement 1: LoginTest")
	public void loginTest() throws InterruptedException{
		
		//enter username
		Login_Page.userName(driver).click();
		Login_Page.userName(driver).sendKeys(prop.getProperty("username"));
		
		//enter password
		Login_Page.password(driver).click();
		Login_Page.password(driver).sendKeys(prop.getProperty("password"));
		
		//click login button
		Login_Page.loginBtn(driver).click();
		Thread.sleep(2000);
		
		//verify login
		Assert.assertTrue(Home_Page.LoginUserText(driver).getText().equals("gaurav"), "Login unsuccessful");
	}
	
	@Test(description="Requirement 2: Electronics menu in home page")
	public void electronicsMenuTest() throws InterruptedException
	{
		//login to page
		loginTest();
		
		//verify homepage has Electronics in top menu items
		Assert.assertEquals(Home_Page.MenuItemElectronic(driver).getText(),"Electronics","Electronics menu not found");
	}
	
	@Test(description="Requirement 3: Navigate to Mobile home page")
	public void navigateToMobileTest() throws InterruptedException
	{
		//calls login method
		loginTest();
		
		//navigate to Mobile page and perform assertions
		navigateToMobile();
	}
	
	@Test(description="Requirement 4: Filter for 4 GB RAM test")
	public void filterRamTest() throws InterruptedException
	{
		//calls login method
		loginTest();
		
		//navigate to Mobile page and perform assertions
		navigateToMobile();
		
		//filter RAM and perform assertions
		filterRam();
	}
	
	@Test(description="Requirement 5: Search Motorola brand test")
	public void searchBrandTest() throws InterruptedException {
		
		//calls login method
		loginTest();
				
		//navigate to Mobile page and perform assertions
		navigateToMobile();
		
		//search brand and perform assertions
		searchBrand();
	}
	
	@Test(description="Requirement 6: Select Motorola brand test")
	public void filterBrandTest() throws InterruptedException 
	{
		//calls login method
		loginTest();
			
		//navigate to Mobile page and perform assertions
		navigateToMobile();
			
		//filter RAM and perform assertions
		filterRam();
		
		//search the brand
		searchBrand();
		
		//select the brand and perform assertions
		selectBrand();

	}
	
	@Test(description="Requirement 7: Clear brand filter test")
	public void clearBrandFilterTest() throws InterruptedException 
	{
		//calls login method
		loginTest();
			
		//navigate to Mobile page and perform assertions
		navigateToMobile();
			
		//filter RAM and perform assertions
		filterRam();
		
		//search the brand
		searchBrand();
		
		//select the brand and perform assertions
		selectBrand();
		
		//to clear the brand from filters and get all brands and perform assertaion
		clearBrand();
	}
	
	@Test(description="Requirement 8: View Mobile Detail Test")
	public void viewDetailTest() throws InterruptedException
	{
		//calls login method
		loginTest();
			
		//navigate to Mobile page and perform assertions
		navigateToMobile();
			
		//filter RAM and perform assertions
		filterRam();
		
		//search the brand
		searchBrand();
		
		//select the brand and perform assertions
		selectBrand();
				
		//after clicking browser moving to detail page of the product
		List<WebElement> elements = driver.findElements(By.xpath("//a[@class='_31qSD5']"));
		String url = elements.get(0).getAttribute("href");
		System.out.println(url);
		driver.get(url);
	}
	
	@Test(description="Requirement 9: adding movbile to cart")
	public void addMobileToCartTest() throws InterruptedException
	{
		//calls login method
		loginTest();
			
		//navigate to Mobile page and perform assertions
		navigateToMobile();
			
		//filter RAM and perform assertions
		filterRam();
		
		//search the brand
		searchBrand();
		
		//select the brand and perform assertions
		selectBrand();
				
		//after clicking browser moving to detail page of the product
		List<WebElement> elements =	Product_Detail.openDetailPage(driver); //driver.findElements(By.xpath("//a[@class='_31qSD5']"));
		String url = elements.get(0).getAttribute("href");
		System.out.println(url);
		driver.get(url);
		Thread.sleep(3000);
		
		//adding mobile to cart
		Product_Detail.clickAddToCartButton(driver).click(); 
	}
	
	@Test (description="REquirement 10: Taking screen shot")
	public void takeScreenShot() throws Exception
	{
		//calls login method
		loginTest();
			
		//navigate to Mobile page and perform assertions
		navigateToMobile();
			
		//filter RAM and perform assertions
		filterRam();
		
		//search the brand
		searchBrand();
		
		//select the brand and perform assertions
		selectBrand();
				
		//after clicking browser moving to detail page of the product
		List<WebElement> elements =	Product_Detail.openDetailPage(driver); //driver.findElements(By.xpath("//a[@class='_31qSD5']"));
		String url = elements.get(0).getAttribute("href");
		System.out.println(url);
		driver.get(url);
		Thread.sleep(3000);
		
		//adding mobile to cart
		Product_Detail.clickAddToCartButton(driver).click(); 
		
		//taking screenshot
		Thread.sleep(3000);		
	 	takeScreenshot();
	 }
	
	//*************************************HELPER METHODS****************************************************************
	
	
	
	public void takeScreenshot() throws Exception
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("ScreenShot.png"));
	}
	
	public void navigateToMobile() throws InterruptedException
	{
		//click on electronics menu
		Home_Page.MenuItemElectronic(driver).click();
		
		//click on search bar
		Home_Page.SearchBar(driver).click();
		
		//search for mobile
		Home_Page.SearchBar(driver).sendKeys("mobile");
		
		//hit enter
		Home_Page.SearchBar(driver).sendKeys(Keys.ENTER);
		
		//click on Mobile submenu
		//Home_Page.SubMenuItemMobile(driver).click();
		
		//verify mobile page has opened
		//Assert.assertTrue(Home_Page.MobilePageTitle(driver).getText().contains("Mobile phones"),"Page not found");
		Assert.assertTrue(Home_Page.mobilePageTitle(driver).getText().contains("Mobile"),"Page not found");
	}
	
	public void filterRam() throws InterruptedException {
		
		//Navigate to RAM section and click on 4 GB option		
		Home_Page.FilterRam(driver).click();
		Thread.sleep(2000);
		
		//verify results with 4 GB ram got selected
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_3ULzGw']"));
		//System.out.println(elements.get(0).findElements(By.xpath("//li[@class='tVe95H']")).get(0).getText());
		Assert.assertTrue(elements.get(0).findElements(By.xpath("//li[@class='tVe95H']")).get(0).getText().contains("4 GB RAM"), "Filter0 results invalid");
		//System.out.println(elements.get(1).findElements(By.xpath("//li[@class='tVe95H']")).get(0).getText());
		Assert.assertTrue(elements.get(1).findElements(By.xpath("//li[@class='tVe95H']")).get(0).getText().contains("4 GB RAM"), "Filter1 results invalid");
	}
	
	public void searchBrand() {
		
		//enter brand name in search area
		Home_Page.FilterSearchTextBox(driver).click();
		Home_Page.FilterSearchTextBox(driver).sendKeys("Moto");
		
		//verify searched brand checkbox available
		Assert.assertTrue(Home_Page.FilterBrand(driver).isDisplayed(), "Searched brand not displayed");
		
	}
	
	public void selectBrand() throws InterruptedException
	{
		
		//select the checkbox
		Home_Page.FilterBrand(driver).click();
		Thread.sleep(3000);
		
		//performing assertion
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		System.out.println(elements.get(0).getText());
		Assert.assertTrue(elements.get(0).getText().contains("Moto"), "Filter0 results invalid");
		System.out.println(elements.get(1).getText());
		Assert.assertTrue(elements.get(1).getText().contains("Moto"), "Filter1 results invalid");
	}

	public void clearBrand() throws InterruptedException
	{
		//select the checkbox
		Home_Page.FilterBrand(driver).click();
		Thread.sleep(3000);
		
		//performing assertion
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
		System.out.println(elements.get(0).getText());
		Assert.assertFalse(elements.get(0).getText().contains("Moto"), "Filter0 results invalid");
		System.out.println(elements.get(1).getText());
		Assert.assertFalse(elements.get(1).getText().contains("Moto"), "Filter1 results invalid");
	}
	
}
