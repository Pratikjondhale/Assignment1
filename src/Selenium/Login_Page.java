package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {
	
	public static WebElement userName(WebDriver driver)
	{
		return driver.findElement(By.className("_2zrpKA")); 
	}
	
	public static WebElement password(WebDriver driver) 
	{
		return driver.findElement(By.xpath("//input[@type='password']")); 
	}
	
	public static WebElement loginBtn(WebDriver driver) 
	{
		return driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")); 
	}

}
