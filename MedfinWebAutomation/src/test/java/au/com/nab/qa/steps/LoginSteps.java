package au.com.nab.qa.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import au.com.nab.qa.base.TestBase;
import au.com.nab.qa.pages.GlobalPassPage;
import au.com.nab.qa.utilities.TestUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends TestBase {
	
	public static Logger log = LogManager.getLogger(LoginSteps.class.getName());

	TestUtil testutil;
	
	public LoginSteps() {
		super();
	}
	
	@When("^User navigates to CVX url$")
	public void user_navigates_to_cvx_url() {
		driver.get(prop.getProperty("CVXUrl"));
		log.info("The url is received successfully");
		gPassPage = new GlobalPassPage();
		testutil = new TestUtil();
	}
	
	 @When("^In Microsoft login page,Enter UserId (.+)$")
	    public void in_microsoft_login_pageenter_userid(String userid) {
		  gPassPage.SigninUser(userid);
	    }
	 
	 @And("^In Global Pass login,Enter Password (.+)$")
	    public void in_global_pass_loginenter_password(String password) throws InterruptedException {
		  gPassPage.GlobalSignIn(password);
		
	    }
	 
		@Then("^Validate that CVX landing initiator page url contains \"([^\"]*)\"$")
		public void validate_cvx_landing_page_url(String strArg1) {
			System.out.println(driver.getCurrentUrl());
			Assert.assertTrue(driver.getCurrentUrl().contains(strArg1));
		}
}
