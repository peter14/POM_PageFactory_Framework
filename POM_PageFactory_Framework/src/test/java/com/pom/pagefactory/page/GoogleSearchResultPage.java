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

public class GoogleSearchResultPage extends BasePage {

	public GoogleSearchResultPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "q")
	WebElement txtSearchBox;

	@FindBy(id = "resultStats")
	WebElement txtResultStats;

	public String getSearchedText() {
		return txtSearchBox.getAttribute("value");
	}

}
