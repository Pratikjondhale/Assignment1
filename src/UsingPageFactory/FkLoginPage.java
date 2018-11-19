package UsingPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FkLoginPage {
	
	WebDriver driver;
	
	public FkLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CLASS_NAME, using = "_2zrpKA")
	WebElement userName;
	
	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	WebElement passWord;
	
	@FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginBtn;
	
	public void enterUsername(String username) {
		userName.click();
		userName.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passWord.click();
		passWord.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}

}
