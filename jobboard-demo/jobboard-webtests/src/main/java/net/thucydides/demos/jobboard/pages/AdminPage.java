package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.on;

@DefaultUrl("http://localhost:9000/admin")
public class AdminPage extends PageObject {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getErrorMessages() {
        List<WebElement> errorMessages = getDriver().findElements(By.className("error"));

        return extract(errorMessages, on(WebElement.class).getText());
    }

    public void shouldContainConfirmationMessage(String message) {
        String xpath = "//div[contains(@class,'flashSuccess') and contains(.,'"+ message + "')]";
        getDriver().findElement(By.xpath(xpath));
    }


}
