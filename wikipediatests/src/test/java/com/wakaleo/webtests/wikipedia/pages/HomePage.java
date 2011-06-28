package com.wakaleo.webtests.wikipedia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {

	private WebElement searchInput;
	
	@FindBy(name="go")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void enter_keywords(String keyword) {
		searchInput.sendKeys(keyword);
		searchButton.click();
	}
}
