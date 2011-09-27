package net.thucydides.demos.jobboard.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.on;

@At("#HOST/admin/categories")
@DefaultUrl("http://localhost:9000/admin/categories")
public class CategoriesPage extends AdminPage {

    @FindBy(linkText = "Add Category")
    WebElement newCategoryButton;

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    public void selectAddCategory() {
        newCategoryButton.click();
    }

    public void selectCategoryInList(String name) {
        getDriver().findElement(By.linkText(name)).click();
    }

    public List<String> getCategories() {
        List<WebElement> categories = getDriver().findElements(By.xpath("//div[@id='crudListTable']//td/a"));
        return extract(categories, on(WebElement.class).getText());
    }

}
