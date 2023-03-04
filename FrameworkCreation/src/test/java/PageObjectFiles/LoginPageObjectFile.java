package PageObjectFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjectFile {
	WebDriver driver;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='radius']")
	WebElement login;
	
	
	@FindBy(xpath="//a[starts-with(@href,'/drag_and_drop')]")
	WebElement dragAndDrop;
	

	public LoginPageObjectFile(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	public void setUserName(String strUsername) {
		username.sendKeys(strUsername);
		
	}
	public void setPassword(String strPwd) {
		password.sendKeys(strPwd);
	}
	public void ClickLogin() {
		login.click();
		
	}
	
	public void clickdragAndDrop() {
		dragAndDrop.click();
	}
}
