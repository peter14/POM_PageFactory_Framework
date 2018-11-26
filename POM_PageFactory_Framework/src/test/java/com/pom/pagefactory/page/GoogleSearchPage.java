/**
 * 
 */
package com.pom.pagefactory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pom.pagefactory.core.BasePage;

/**
 * @author peter
 *
 */

public class GoogleSearchPage extends BasePage {

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "q")
	WebElement txtSearchBox;

	@FindBy(name = "btnK")
	WebElement btnGoogleSearch;

	public void performSearch(String textToSearch) {
		txtSearchBox.sendKeys(textToSearch);
		txtSearchBox.submit();
	}

}
