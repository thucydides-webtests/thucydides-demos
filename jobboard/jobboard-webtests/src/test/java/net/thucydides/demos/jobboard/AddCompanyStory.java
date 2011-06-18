package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.Application.ManageCompanies.AddNewCompany;
import net.thucydides.demos.jobboard.steps.AdminSteps;
import net.thucydides.junit.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@Story(AddNewCompany.class)
public class AddCompanyStory {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://localhost:9000")
    public Pages pages;

    @Steps
    public AdminSteps steps;

    @Test
    public void administrator_adds_a_new_company_to_the_system() {
        steps.login_to_admin_page_if_first_time();
        steps.open_companies_list();
        steps.select_add_company();
        steps.add_new_company("ACME","boss@acme.com","secret","http://acme.website.com","/uploads/logo.gif");
        steps.confirmation_message_should_be_displayed("The Company has been created");
    }

    @Test
    public void administrator_enters_an_invalid_email_address() {
        steps.login_to_admin_page_if_first_time();
        steps.open_companies_list();
        steps.select_add_company();
        steps.add_new_company("ACME","bossATacme.com","secret","http://acme.website.com","/uploads/logo.gif");
        steps.error_message_should_be_displayed("Invalid email address");
    }

    @Test
    public void administrator_adds_an_existing_company_to_the_system() {}

    @Test
    public void administrator_adds_an_existing_company_to_the_broken_system() {
        steps.error_message_should_be_displayed("Oh crap");
    }

    @Test
    public void administrator_adds_a_company_but_forgets_to_add_mandatory_fields() {}

    @Pending @Test
    public void administrator_adds_a_company_with_an_existing_code_to_the_system() {
        steps.login_to_admin_page_if_first_time();
        steps.open_companies_list();
        steps.select_add_company();
        // More to come
    }

}
