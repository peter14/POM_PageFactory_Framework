package com.pom.pagefactory.core;

import org.openqa.selenium.WebDriver;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected WebDriver driver() {
		return driver;
	}

	public String getUrl() {
		return driver.getCurrentUrl();

	}

}
