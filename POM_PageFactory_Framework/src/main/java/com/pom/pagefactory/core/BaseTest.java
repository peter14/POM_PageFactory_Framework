package com.pom.pagefactory.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

	private WebDriver driver;
	// public SessionId session;

	@BeforeMethod
	public void beforeMethod() {

		/*
		 * String driverPath = System.getProperty("user.dir");
		 * System.out.println(driverPath);
		 * 
		 * System.setProperty("webdriver.chrome.driver", driverPath +
		 * "\\drivers\\chromedriver.exe"); this.driver = new ChromeDriver();
		 * 
		 * 
		 * System.setProperty("webdriver.gecko.driver", driverPath +
		 * "./drivers/geckodriver.exe"); this.driver = new FirefoxDriver();
		 */

		driver = BrowserFactory.getInstance();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	protected WebDriver driver() {
		return driver;
	}

}
