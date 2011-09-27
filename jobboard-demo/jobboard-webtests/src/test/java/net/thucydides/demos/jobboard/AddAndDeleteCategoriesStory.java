package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.JobBoardApplication.ManageCategories.AddNewCategory;
import net.thucydides.demos.jobboard.steps.AdministratorSteps;
import net.thucydides.demos.jobboard.steps.DataDrivenCategorySteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static net.thucydides.core.steps.StepData.withTestDataFrom;

@RunWith(ThucydidesRunner.class)
@Story(AddNewCategory.class)
public class AddAndDeleteCategoriesStory {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://localhost:9000")
    public Pages pages;

    @Steps
    public AdministratorSteps steps;

    @Steps
    public DataDrivenCategorySteps categorySteps;

    @Test
    public void adding_and_deleting_categories_should_be_easy() throws IOException {
        steps.logs_in_to_admin_page_if_first_time();
        steps.opens_categories_list();

        withTestDataFrom("test-data/categories.csv").run(categorySteps).add_a_category();

        withTestDataFrom("test-data/categories.csv").run(categorySteps).delete_a_category();
    }

}
