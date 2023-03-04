
  package StepDefinition;
  
  import java.io.FileInputStream; 
  import java.io.IOException;
import java.time.Duration;
import java.util.Properties; 
  import java.util.concurrent.TimeUnit;
  
  import org.openqa.selenium.WebDriver; 
  import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageObjectFiles.LoginPageObjectFile; 
  import io.cucumber.java.en.And;
  import io.cucumber.java.en.Given; 
  import io.cucumber.java.en.Then; 
  import io.cucumber.java.en.When;
  
  import io.cucumber.java.After;
  import io.cucumber.java.Before;
  
  public class LoginStep { 
	  WebDriver driver; 
	  ExtentReports report;
	  ExtentTest test;
	  String configFilePath ="src/main/resources/Config/config.properties";
	  @Before
	  public void BeforeStep() {
		  report = new ExtentReports(System.getProperty("user.dir")+"test-output/ExtesttentReportResults.html");
		  test = report.startTest("ExtentDemo");
		  System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe"); 
		  driver= new ChromeDriver();
		  test.log(LogStatus.INFO, "lanuched chrome browser");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  }
	  @After
		public void Ending() throws Exception
		{
			Thread.sleep(3000);
			driver.quit();
			report.endTest(test);
			report.flush();
		}
 
  @Given("^user navigate to the internet herokuapp form authentication url$")
  public void that_navigate_to_the_internet_herokuapp_form_authentication_url()throws Exception { System.out.
  println("Inside step-user navigate to the internet herokuapp form authentication url"); 
		
  
  Properties Prop = new Properties(); 
  FileInputStream propsInput = new FileInputStream(configFilePath); 
  Prop.load(propsInput);
 
  driver.get(Prop.getProperty("url")); 
  test.log(LogStatus.INFO, "loaded the URL");
  driver.manage().window().maximize();
  
  }
  
  @When("^user enters  username and password$") public void
  user_enters_username_and_password() throws Exception {
  System.out.println("Inside step-user enters  username and password");
  LoginPageObjectFile LoginPage= new LoginPageObjectFile(driver);
  Thread.sleep(3000); 
  LoginPage.setUserName("tomsmith"); 
  test.log(LogStatus.INFO, "given username");
  Thread.sleep(3000);
  LoginPage.setPassword("SuperSecretPassword!"); 
  test.log(LogStatus.INFO, "Given Password");
  }
  
  @When("^user enters username as (.*) and password as (.*)$") 
  public void user_enters_username_as_and_password_as(String arg1, String arg2) throws Exception {
  System.out.println("Inside step-user enters  username and password");
  LoginPageObjectFile LoginPage= new LoginPageObjectFile(driver);
  Thread.sleep(3000); 
  LoginPage.setUserName(arg1); 
  test.log(LogStatus.INFO, "given username");
  Thread.sleep(3000);
  LoginPage.setPassword(arg2); 
  test.log(LogStatus.INFO, "given Password");
  }
  
  @And("^click on login button$")
  public void click_on_login_button() throws InterruptedException {
  System.out.println("Inside step-click on login button"); 
  LoginPageObjectFile LoginPage= new LoginPageObjectFile(driver); 
  Thread.sleep(3000);
  LoginPage.ClickLogin();
  test.log(LogStatus.INFO, "Clicked on login button");
  }
  
  @Then("^It should login successfully$") public void
  it_should_login_successfully() throws Exception {
  System.out.println("Inside step- It should login successfully");
  test.log(LogStatus.PASS, "Successfully login to the page");
  
  
  }
  
  }
 