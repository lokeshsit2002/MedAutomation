package au.com.nab.qa.steps;

import java.io.IOException;

import au.com.nab.qa.base.TestBase;
import au.com.nab.qa.utilities.TestUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends TestBase {
	
	TestUtil testutil= new TestUtil();
	
	@Before
	 public void Setup() {
	//	Log.info("TestCase Started");
		 initialization();
		 testutil = new TestUtil();
		
	}
	
	 @After
	    public void tearDown(Scenario scenario) throws InterruptedException {
	    	
	    	if (scenario.isFailed()) {
	    	      // Take a screenshot...
	    	      try {
					testutil.getScreenshot(scenario.getName());
					System.out.println(scenario.getSourceTagNames());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	      
	    	    }
	    	
			Thread.sleep(2000);
			if(driver!=null) {
			driver.quit();
		//	Log.info("Driver exit");
			}
			
		//	Log.info("TestCase Completed");
		}

}
