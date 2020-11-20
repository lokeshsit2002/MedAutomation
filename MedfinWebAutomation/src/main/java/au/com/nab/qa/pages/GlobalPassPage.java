package au.com.nab.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import au.com.nab.qa.base.TestBase;
import au.com.nab.qa.utilities.TestUtil;

public class GlobalPassPage extends TestBase {

	public static Logger log = LogManager.getLogger(GlobalPassPage.class.getName());

	TestUtil testutil = new TestUtil();

	// microsoft login page

	By signInUser = By.cssSelector("input[id='i0116']");
	By nextMicrosoftBtn = By.cssSelector("input[id='idSIButton9']");

	// GlobalPass login page
	By guserID = By.cssSelector("input[id='userNameInput']");
	By gpassword = By.cssSelector("input[id='passwordInput']");
	By gloginBtn = By.cssSelector("span[id='submitButton']");

	// microsoft
	public void SigninUser(String lUserEmail) {

		log.debug("Enter the User email");
		testutil.doGetElement(signInUser).sendKeys(lUserEmail);
		testutil.doGetElement(nextMicrosoftBtn).click();
		log.info("The User email has been entered successfully"); 
	}

	// global pass login
	public InitiaterPage GlobalSignIn(String globalpasswordtext) throws InterruptedException {

		// Thread.sleep(5000);
		log.debug("Enter the User Password");
		testutil.doEnterText(gpassword, globalpasswordtext);
		testutil.doClick(gloginBtn);

		Thread.sleep(30000);
		log.info("The User password has been entered successfully"); 
		return new InitiaterPage();

	}

}
