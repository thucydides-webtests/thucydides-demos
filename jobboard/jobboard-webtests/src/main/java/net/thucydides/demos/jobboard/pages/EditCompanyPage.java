package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://localhost:9000/admin/categories/new")
public class EditCompanyPage extends PageObject {

    @FindBy(id="object_name")
    WebElement nameField;

    @FindBy(id="object_email")
    WebElement emailField;

    @FindBy(id="object_password")
    WebElement passwordField;

    @FindBy(id="object_website")
    WebElement websiteField;

    @FindBy(id="object_logo")
    WebElement logoField;

    @FindBy(name="_save")
    WebElement saveButton;

    public EditCompanyPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String name) {
        typeInto(nameField, name);
    }

    public void setEmail(String email) {
        typeInto(emailField, email);
    }

    public void setPassword(String password) {
        typeInto(passwordField, password);
    }

    public void setWebsite(String website) {
        typeInto(passwordField, website);
    }

    public void loadLogoFrom(String filename) {
        upload(filename).to(logoField);
    }

    public void createNewCompany() {
        saveButton.click();
    }

}
