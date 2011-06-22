package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.Application.ManageCategories.AddNewCategory;
import net.thucydides.demos.jobboard.steps.AdministratorSteps;
import net.thucydides.junit.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@Story(AddNewCategory.class)
public class AddCategoryStory {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://localhost:9000")
    public Pages pages;

    @Steps
    public AdministratorSteps steps;

    @After
    public void cleanup() {
        steps.deletes_category("Java Developers");
    }

    @Test
    public void administrator_adds_a_new_category_to_the_system() {
        steps.logs_in_to_admin_page_if_first_time();
        steps.opens_categories_list();
        steps.selects_add_category();
        steps.adds_new_category("Java Developers", "JAVA");
        steps.should_see_confirmation_message("The Category has been created");

        steps.should_see_category("Java Developers");
    }

    @Pending @Test
    public void administrator_adds_an_existing_category_to_the_system() {}

    @Pending @Test
    public void administrator_adds_a_category_with_an_existing_code_to_the_system() {}

}
