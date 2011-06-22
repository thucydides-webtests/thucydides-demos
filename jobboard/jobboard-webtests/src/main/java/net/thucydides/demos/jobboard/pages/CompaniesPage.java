package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.on;

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

    public Iterable<String> getCompanies() {
        List<WebElement> companies = getDriver().findElements(By.xpath("//div[@id='crudListTable']//td/a"));
        return extract(companies, on(WebElement.class).getText());
    }

    public void selectCompanyInList(String name) {
        getDriver().findElement(By.linkText(name)).click();
    }
}
