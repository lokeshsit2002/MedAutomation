package au.com.nab.qa.runners;


import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cucumber.listener.Reporter;

import au.com.nab.qa.base.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		// use this parameter to generate Gherkin scenarios      dryRun=true,
	features= "src/test/java/au/com/nab/qa/features",
	glue= {"au.com.nab.qa.steps"},strict=true,tags= {"@browser"},
	//plugin = {"pretty","junit:target/Jenkins/MedfinJunitReport.xml"},
	plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtentReport1.html"},
	
	monochrome = true
	)

public class TestRunnerChrome extends AbstractTestNGCucumberTests{

	@BeforeClass
	public void selectBrowser()
	{
		TestBase.browserName="Chrome";
	}
	
	 @AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(TestBase.prop.getProperty("reportConfigPath")));
	 }
	
	
}
