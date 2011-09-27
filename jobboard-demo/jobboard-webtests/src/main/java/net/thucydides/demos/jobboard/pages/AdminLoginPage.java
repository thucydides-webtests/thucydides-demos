package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://localhost:9000/admin")
public class AdminLoginPage extends PageObject {


    @FindBy(id="email")
    WebElement emailField;

    @FindBy(id="password")
    WebElement passwordField;

    WebElement signin;

    @FindBy(linkText = "Logout")
    WebElement logout;

    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String emailAddress, String password) {
        enter(emailAddress).into(emailField);
        enter(password).into(passwordField);
        signin.click();
    }

    public void logout() {
        logout.click();
    }
}
