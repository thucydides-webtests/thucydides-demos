package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://localhost:9000/admin/companies")
public class CompaniesPage extends AdminPage {

    @FindBy(linkText = "Add Company")
    WebElement newCompanyButton;

    public CompaniesPage(WebDriver driver) {
        super(driver);
    }

    public void selectAddCompany() {
        newCompanyButton.click();
    }


    public void shouldContainConfirmationMessage(String message) {
        String xpath = "//div[contains(@class,'flashSuccess') and contains(.,'"
                + message
                + "')]";
        getDriver().findElement(By.xpath(xpath));
    }
}
