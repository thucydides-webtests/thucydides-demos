package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.Application.ManageCompanies.DeleteCompany;
import net.thucydides.demos.jobboard.steps.AdministratorSteps;
import net.thucydides.junit.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@Story(DeleteCompany.class)
public class DeleteACompanyStory {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://localhost:9000")
    public Pages pages;

    @Steps
    public AdministratorSteps steps;

    @Before
    public void login_if_required() {
        steps.logs_in_to_admin_page_if_first_time();
        steps.adds_new_company("Test Company", "boss@acme.com", "secret", "http://acme.website.com", "/uploads/logo.gif");
    }

    @Test
    public void remove_a_company() {
        steps.opens_companies_list();
        steps.should_see_company("Test Company");

        steps.displays_company_details_for("Test Company");
        steps.deletes_company();

        steps.opens_companies_list();
        steps.should_not_see_company("Test Company");
    }

}
