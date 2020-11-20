package au.com.nab.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.nab.qa.pages.GlobalPassPage;
import au.com.nab.qa.pages.InitiaterPage;

//import com.cvx.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public static Properties prop;
	public static WebDriverWait wait;
	public static Actions action;
	public static EventFiringWebDriver e_driver;
//	public static WebEventListener eventListener;
	public static String browserName = "NoBrowser";
	DesiredCapabilities capabilities;
	String projectPath = System.getProperty("user.dir");
	
	
	public static GlobalPassPage gPassPage;
	public static InitiaterPage iPage;

	public TestBase() {

		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(projectPath + "//src//main//java//au//com/nab//qa//config//medfinConfig.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void getBrowserName(String selectedBrowserName) {
		browserName = selectedBrowserName;
	}
	
	// Method to initialize the browser and launch the browser

		public void initialization() {

			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("Chrome Browser detected");
				driver.manage().window().maximize();
			}
			
			else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("Firefox Browser detected");
				driver.manage().window().maximize();
			}

			else if (browserName.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println("Microsoft Edge Browser detected");
				driver.manage().window().maximize();
			}

	
			else {
				System.out.println(browserName + "Browser has not been implemented");

			}
			
			driver.manage().deleteAllCookies();
//			driver.get(prop.getProperty("CVXUrl"));
			driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageLoadTimeout")),
					TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicitlyWait")), TimeUnit.SECONDS);
			action = new Actions(driver);
			wait = new WebDriverWait(driver, 50);
		}
		

}
