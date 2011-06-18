package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.Application.ManageCategories.DeleteCategory;
import net.thucydides.demos.jobboard.steps.AdminSteps;
import net.thucydides.junit.annotations.Managed;
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
    public AdminSteps steps;

    @Before
    public void login_if_required() {
        steps.login_to_admin_page_if_first_time();
        steps.add_category("Category to delete", "DELETABLE");
    }

    @Test
    public void remove_test_category() {
        steps.open_categories_list();
        steps.category_should_appear("Category to delete");

        steps.display_category_details_for("Category to delete");
        steps.delete_category();

        steps.open_categories_list();
        steps.category_should_not_appear("Category to delete");
    }

}
