package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://localhost:9000/admin")
public class AdminHomePage extends PageObject {


    WebElement keywords;
    WebElement searchButton;

    public AdminHomePage(WebDriver driver) {
        super(driver);
    }

    public void selectObjectType(String objectType) {
        getDriver().findElement(By.linkText(objectType)).click();
    }



}
