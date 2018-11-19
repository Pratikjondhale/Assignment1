package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product_Detail 
{
	public static List<WebElement> openDetailPage(WebDriver driver)
	{
		return driver.findElements(By.xpath("//a[@class='_31qSD5']"));
	}
	
	public static WebElement clickAddToCartButton(WebDriver driver)
	{
		return driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']"));
	}
}
