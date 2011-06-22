package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://localhost:9000/admin/categories/new")
public class EditCategoryPage extends PageObject {

    @FindBy(id="object_label")
    WebElement label;

    @FindBy(id="object_code")
    WebElement code;

    @FindBy(name="_save")
    WebElement saveButton;

    @FindBy(xpath = "//input[@value='Delete Category']")
    WebElement deleteButton;

    public EditCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void saveNewCategory(String labelValue, String codeValue) {
        typeInto(label, labelValue);
        typeInto(code, codeValue);
        saveButton.click();
    }

    public void clickOnDelete() {
        deleteButton.click();
    }
}
