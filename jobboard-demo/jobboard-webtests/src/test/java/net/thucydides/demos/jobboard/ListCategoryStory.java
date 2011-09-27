package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.JobBoardApplication.ManageCategories.ListCategories;
import net.thucydides.demos.jobboard.steps.AdministratorSteps;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@Story(ListCategories.class)
public class ListCategoryStory {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://localhost:9000")
    public Pages pages;

    @Steps
    public AdministratorSteps steps;

    @Before
    public void login_if_required() {
        steps.logs_in_to_admin_page_if_first_time();
        steps.adds_category("Java Developers", "JAVA");
        steps.adds_category("Ruby Developers", "RUBY");
        steps.adds_category(".NET Developers", "NET");
    }

    @After
    public void remove_test_category() {
        steps.deletes_category("Java Developers");
        steps.deletes_category("Ruby Developers");
        steps.deletes_category(".NET Developers");
    }

    @Test
    public void administrator_lists_all_available_categories_in_the_system() {
        steps.opens_categories_list();

        steps.should_see_category("Java Developers");
        steps.should_see_category("Ruby Developers");
        steps.should_see_category(".NET Developers");

    }

}
