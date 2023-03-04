package TheInternet.Herokuapp.com;

import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjectFiles.LoginPageObjectFile;

public class Logintest {
	@Test
	public void Authentication() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");

		// Load system Properties
		String configFilePath = "src/main/resources/Config/config.properties";
		Properties Prop = new Properties();
		FileInputStream propsInput = new FileInputStream(configFilePath);
		Prop.load(propsInput);

		
		  WebDriver driver= new ChromeDriver(); 
		  driver.manage().deleteAllCookies();

		  driver.get(Prop.getProperty("url")); driver.manage().window().maximize();
		  Thread.sleep(5000);
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		  
	
		  WebDriverWait wait = new WebDriverWait(driver, null);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		  
		  LoginPageObjectFile LoginPage= new LoginPageObjectFile(driver);
		  LoginPage.setUserName("tomsmith"); 
		  Thread.sleep(3000);
		  LoginPage.setPassword("SuperSecretPassword!"); 
		  Thread.sleep(3000);
		  LoginPage.ClickLogin(); 
		  driver.quit();
		 

		
		

		/*driver.get(Prop.getProperty("urlHome"));
	
		 * WebElement AElement= driver.findElement(By.xpath("//div[@id='column-a']"));
		 * WebElement BElement=driver.findElement(By.xpath("//div[@id='column-b']"));
		 * Actions actions=new Actions(driver);
		 * actions.clickAndHold(BElement).moveToElement(AElement).release(AElement).
		 * build().perform(); actions.dragAndDrop(AElement,BElement ).build().perform();
		 * 
		 * Thread.sleep(5000);
		 */

		
		/*
		 * driver.navigate().to(Prop.getProperty("urldropdoown"));
		 * 
		 * Thread.sleep(5000);
		 * 
		 * Select dropdown=new
		 * Select(driver.findElement(By.xpath("//*[@id='dropdown']")));
		 * dropdown.selectByValue("1");
		 * 
		 * Thread.sleep(5000);
		 *
		  
		  
		  
		  dropdown.selectByValue("2");*/
		  
		 
	}

}
