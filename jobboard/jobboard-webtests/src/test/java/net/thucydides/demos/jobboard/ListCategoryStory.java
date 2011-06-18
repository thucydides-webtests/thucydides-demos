package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.Application.ManageCategories.AddNewCategory;
import net.thucydides.demos.jobboard.steps.AdminSteps;
import net.thucydides.junit.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@Story(AddNewCategory.class)
public class ListCategoryStory {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://localhost:9000")
    public Pages pages;

    @Steps
    public AdminSteps steps;

    @Before
    public void login_if_required() {
        steps.login_to_admin_page_if_first_time();
        steps.add_category("Java Developers", "JAVA");
        steps.add_category("Ruby Developers", "RUBY");
        steps.add_category(".NET Developers", "NET");
    }

    @After
    public void remove_test_category() {
        steps.delete_category("Java Developers");
        steps.delete_category("Ruby Developers");
        steps.delete_category(".NET Developers");
    }

    @Test
    public void administrator_lists_all_available_categories_in_the_system() {
        steps.open_categories_list();

        steps.category_should_appear("Java Developers");
        steps.category_should_appear("Ruby Developers");
        steps.category_should_appear(".NET Developers");

    }

}
