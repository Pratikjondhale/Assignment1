package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page
{
	public static WebElement MenuItemElectronic(WebDriver driver)
	{
		return driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8']"));
	}
	
	public static WebElement SearchBar(WebDriver driver)
	{
		return driver.findElement(By.className("LM6RPg"));
	}
	
	public static WebElement SubMenuItemMobile(WebDriver driver)
	{
		return driver.findElement(By.linkText("Mobiles"));
	}
	
	public static WebElement mobilePageTitle(WebDriver driver)
	{
		//return driver.findElement(By.className("_30P0WS"));
		return driver.findElement(By.xpath("//a[@class='_3XS1AH _32ZSYo']"));
	}
	
	public static WebElement FilterRam(WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[@title='4 GB']"));
	}
	
	public static WebElement FilterSearchTextBox(WebDriver driver)
	{
		return driver.findElement(By.className("_3vKPvR"));
	}
	
	public static WebElement FilterBrand(WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[@title='Motorola']"));
	}
	
	public static WebElement LoginUserText(WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[@class='_2cyQi_']"));
	}
	
	
	
}
