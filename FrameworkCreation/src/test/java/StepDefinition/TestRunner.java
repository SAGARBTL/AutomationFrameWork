package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
                 glue={"StepDefinition"}, 
                 monochrome=true, tags="@SmokeTest",
                 plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
                 )
public class TestRunner {
	

}
//plugin= {"pretty","json:target/JSONReports/report.xml"}