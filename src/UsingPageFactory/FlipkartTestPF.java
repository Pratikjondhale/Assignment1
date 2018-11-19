package UsingPageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FlipkartTestPF {
	
	static WebDriver driver;
	
	public void openFlipkart() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\PRATIK\\MY DATA\\PERSONAL TRAINING\\AUTOMATION\\driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void login() throws InterruptedException{
		openFlipkart();
		
		
		FkLoginPage loginpage = PageFactory.initElements(driver, FkLoginPage.class);
		
		loginpage.enterUsername("gauravajain@gmail.com");
		
		loginpage.enterPassword("gaurav1234");
		
		loginpage.clickLogin();
		Thread.sleep(2000);
	}

}
