package com.pom.pagefactory.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.pagefactory.core.BaseTest;
import com.pom.pagefactory.page.GoogleSearchPage;
import com.pom.pagefactory.page.GoogleSearchResultPage;

public class C001_GoogleSearchTest extends BaseTest {

	/**
	 * without page object model
	 */

	@Test(description = "Scenario : Searching a given text without POM_PageFactory")
	public void TC001_GoogleSearchTest() {
		driver().get("https://google.com");
		driver().manage().window().maximize();
		driver().findElement(By.name("q")).sendKeys("Selenium Webdriver");
		driver().findElement(By.name("q")).submit();
		String pageUrl = driver().getCurrentUrl();
		Assert.assertTrue(pageUrl.startsWith("https://www.google.com/search?"),
				"Page Url : " + pageUrl + "was not starting with -> https://google.com");

	}

	/**
	 * with POM and page object factory
	 */

	@Test(description = "Scenario : Searching a given text using POM_PageFactory")
	public void TC002_GoogleSearchTest() {

		driver().get("https://google.com");

		GoogleSearchPage searchPage = PageFactory.initElements(driver(), GoogleSearchPage.class);
		searchPage.performSearch("Selenium Webdriver");
		GoogleSearchResultPage resultPage = PageFactory.initElements(driver(), GoogleSearchResultPage.class);
		/*
		 * String expectedSearchResultUrl = "https://www.google.com/search?";
		 * Assert.assertTrue(resultPage.getUrl().startsWith(expectedSearchResultUrl),
		 * "Page Url : " + expectedSearchResultUrl +
		 * "was not starting with -> https://google.com");
		 */
		Assert.assertEquals(resultPage.getSearchedText(), "Selenium Webdriver");

	}

}
