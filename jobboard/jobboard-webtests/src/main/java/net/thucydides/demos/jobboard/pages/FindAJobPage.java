package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://localhost:9000")
public class FindAJobPage extends PageObject {


    WebElement keywords;
    WebElement searchButton;

    public FindAJobPage(WebDriver driver) {
        super(driver);
    }

    public void look_for_jobs_with_keywords(String values) {
        typeInto(keywords, values);
        searchButton.click();
    }



}
