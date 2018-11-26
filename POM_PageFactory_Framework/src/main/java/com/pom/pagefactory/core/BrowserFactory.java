package com.pom.pagefactory.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class BrowserFactory {

	public static WebDriver driver;
	public static ChromeOptions options;
	public static SessionId session;

	public static WebDriver getInstance() {

		switch (Constants.BROWSER_NAME.toUpperCase()) {

		case "CHROME":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			options = new ChromeOptions();

			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-extensions");
			options.addArguments("--test-type");
			options.addArguments("--ignore-certificate-errors");
			driver = new ChromeDriver(options);

			// session = ((ChromeDriver) driver).getSessionId(); // To get the driver
			// session id
			// System.out.println("Current session ID : " + session.toString());

			getSessionID();
			System.out.println("Initialize Web driver: " + driver.hashCode());

			break;

		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();

			session = ((FirefoxDriver) driver).getSessionId(); // To get the driver session id
			System.out.println("Current session ID : " + session.toString());

			break;

		case "IE":
			break;

		case "EDGE":
			break;

		case "HEADLESS":
			break;

		case "REMOTE":

			/*
			 * DesiredCapabilities capability = DesiredCapabilities.chrome();
			 * capability.setBrowserName("Chrome");
			 * capability.setPlatform(Platform.WINDOWS);
			 */

			try {
				driver = new RemoteWebDriver(new URL(Constants.NODE_URL), options);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;

		default:
			throw new RuntimeException("Invalid Browser Name ---> : " + Constants.BROWSER_NAME.toUpperCase());
		}

		return driver;
	}

	// try to extend this method for other browsers also
	public static void getSessionID() {
		session = ((ChromeDriver) driver).getSessionId(); // To get the driver session id
		System.out.println("Current session ID : " + session.toString());

	}

}
