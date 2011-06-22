package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.Application.ManageCompanies.AddNewCompany;
import net.thucydides.demos.jobboard.steps.AdministratorSteps;
import net.thucydides.junit.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Ignore;
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
    public AdministratorSteps steps;

    @After
    public void cleanup() {
        steps.deletes_company("ACME");
    }

    @Test
    public void administrator_adds_a_new_company_to_the_system() {
        steps.logs_in_to_admin_page_if_first_time();
        steps.opens_companies_list();
        steps.selects_add_company();
        steps.adds_new_company("ACME", "boss@acme.com", "secret", "http://acme.website.com", "/uploads/logo.gif");
        steps.should_see_confirmation_message("The Company has been created");
    }


    @Test
    public void administrator_adds_an_existing_company_with_no_name() {
        steps.logs_in_to_admin_page_if_first_time();
        steps.opens_companies_list();
        steps.selects_add_company();
        steps.adds_new_company("", "boss@acme.com", "secret", "http://acme.website.com", "/uploads/logo.gif");
        steps.should_see_confirmation_message("The Company has been created");
    }

    @Test
    public void administrator_enters_an_invalid_email_address() {
        steps.logs_in_to_admin_page_if_first_time();
        steps.opens_companies_list();
        steps.selects_add_company();
        steps.adds_new_company("ACME", "bossATacme.com", "secret", "http://acme.website.com", "/uploads/logo.gif");
        steps.should_see_error_message("Invalid email address");
    }

    @Test
    public void administrator_adds_an_existing_company_to_the_system() {}


    @Test
    public void administrator_adds_a_company_but_forgets_to_add_mandatory_fields() {}

    @Test
    public void administrator_adds_an_existing_company_to_the_broken_system() {
        steps.should_see_error_message("Oh crap");
    }

    @Ignore
    @Test
    public void experminental_test() {
        steps.should_see_error_message("Oh crap");
    }

    @Pending
    @Test
    public void administrator_adds_a_company_with_an_existing_code_to_the_system() {
        steps.logs_in_to_admin_page_if_first_time();
        steps.opens_companies_list();
        steps.selects_add_company();
        // More to come
    }

}
