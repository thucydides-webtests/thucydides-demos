package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://localhost:9000/admin")
public class AdminLoginPage extends PageObject {


    WebElement email;
    WebElement password;
    WebElement signin;

    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String emailValue, String passwordValue) {
        typeInto(email, emailValue);
        typeInto(password, passwordValue);
        signin.click();
    }



}
