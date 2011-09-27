package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.JobBoardApplication.ManageCategories.AddNewCategory;
import net.thucydides.demos.jobboard.steps.AdministratorSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("test-data/categories.csv")
@Story(AddNewCategory.class)
public class AddMultipleCategoriesStory {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://localhost:9000")
    public Pages pages;

    @Steps
    public AdministratorSteps administrator;

    private String name;

    private String code;


    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Test
    public void adding_and_deleting_categories_should_be_easy() throws IOException {
        administrator.logs_in_to_admin_page_if_first_time();
        administrator.opens_categories_list();

        administrator.adds_category(name, code);
        administrator.deletes_category(name);
    }

    @Override
    public String toString() {
        return name + "/" + code;
    }
}
