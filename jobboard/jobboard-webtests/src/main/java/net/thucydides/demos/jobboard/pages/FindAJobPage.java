package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.on;

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

    public List<String> getJobTabs() {
        List<WebElement> tabs = getDriver().findElements(By.xpath("//div[@id='tabs']//a"));
        return extract(tabs, on(WebElement.class).getText());
    }
}
