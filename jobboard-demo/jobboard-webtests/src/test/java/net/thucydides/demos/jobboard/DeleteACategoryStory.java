package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.JobBoardApplication.ManageCategories.DeleteCategory;
import net.thucydides.demos.jobboard.steps.AdministratorSteps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@Story(DeleteCategory.class)
public class DeleteACategoryStory {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://localhost:9000")
    public Pages pages;

    @Steps
    public AdministratorSteps steps;

    @Before
    public void login_if_required() {
        steps.logs_in_to_admin_page_if_first_time();
        steps.adds_category("Category to delete", "DELETABLE");
    }

    @Test
    public void remove_test_category() {
        steps.opens_categories_list();
        steps.should_see_category("Category to delete");

        steps.displays_category_details_for("Category to delete");
        steps.deletes_category();

        steps.opens_categories_list();
        steps.should_not_see_category("Category to delete");
    }

}
