package net.thucydides.demos.jobboard.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.demos.jobboard.pages.AdminHomePage;
import net.thucydides.demos.jobboard.pages.AdminLoginPage;
import net.thucydides.demos.jobboard.pages.AdminPage;
import net.thucydides.demos.jobboard.pages.CategoriesPage;
import net.thucydides.demos.jobboard.pages.CompaniesPage;
import net.thucydides.demos.jobboard.pages.EditCategoryPage;
import net.thucydides.demos.jobboard.pages.EditCompanyPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;

/**
 * A job_seeker library contains a set of reusable actions that manipulate page objects.
 * Methods annotated with @Step will be recorded and reported in the Thucydides
 * reports.
 * <p/>
 * Step libraries can be organized in whatever structure suites you - by feature,
 * by module, by user,...
 */
public class AdministratorSteps extends ScenarioSteps {
    public AdministratorSteps(Pages pages) {
        super(pages);
    }


    @Step
    public void logs_in_to_admin_page_if_first_time() {
        AdminLoginPage page = getPages().get(AdminLoginPage.class);
        page.open();
        if (!page.containsText("Logout")) {
            page.login("admin", "admin");
        }
    }

    @Step
    public void logout() {
        AdminLoginPage page = getPages().get(AdminLoginPage.class);
        page.open();
        if (page.containsText("Logout")) {
            page.logout();
        }
    }

    @Step
    public void opens_categories_list() {
        AdminHomePage page = getPages().get(AdminHomePage.class);
        page.open();
        page.selectObjectType("Categories");
    }

    @StepGroup
    public void adds_category(String name, String code) {
        opens_categories_list();
        selects_add_category();
        adds_new_category(name, code);
    }

    @StepGroup
    public void deletes_category(String name) {
        opens_categories_list();
        displays_category_details_for(name);
        deletes_category();
    }

    @Step
    public void selects_add_category() {
        CategoriesPage categoriesPage = getPages().get(CategoriesPage.class);
        categoriesPage.selectAddCategory();
    }

    @Step
    public void adds_new_category(String label, String code) {
        EditCategoryPage newCategoryPage = getPages().get(EditCategoryPage.class);
        newCategoryPage.saveNewCategory(label, code);
    }

    @Step
    public void should_see_confirmation_message(String message) {
        AdminPage page = getPages().get(AdminPage.class);
        page.shouldContainConfirmationMessage(message);
    }

    @Step
    public void opens_companies_list() {
        AdminHomePage page = getPages().get(AdminHomePage.class);
        page.open();
        page.selectObjectType("Companies");
    }

    @Step
    public void selects_add_company() {
        CompaniesPage companiesPage = getPages().get(CompaniesPage.class);
        companiesPage.selectAddCompany();
    }


    @StepGroup
    public void adds_new_company(String name, String email, String password, String website, String logoFilepath) {
        opens_companies_list();
        selects_add_company();
        provides_company_details(name, email, password, website, logoFilepath);
    }

    @Step
    public void provides_company_details(String name, String email, String password, String website, String logoFilepath) {
        EditCompanyPage onPage = getPages().get(EditCompanyPage.class);
        onPage.setName(name);
        onPage.setEmail(email);
        onPage.setPassword(password);
        onPage.setWebsite(website);
        onPage.loadLogoFrom(logoFilepath);
        onPage.createNewCompany();
    }

    @Step
    public void should_see_error_message(String message) {
        AdminPage page = getPages().get(AdminPage.class);
        assertThat(page.getErrorMessages(), hasItem(message));
    }

    public void displays_category_details_for(String name) {
        CategoriesPage categoriesPage = getPages().get(CategoriesPage.class);
        categoriesPage.selectCategoryInList(name);
    }

    public void deletes_category() {
        EditCategoryPage categoryPage = getPages().get(EditCategoryPage.class);
        categoryPage.clickOnDelete();
    }

    public void should_see_category(String name) {
        CategoriesPage categoriesPage = getPages().get(CategoriesPage.class);
        assertThat(categoriesPage.getCategories(), hasItem(name));

    }

    public void should_not_see_category(String name) {
        CategoriesPage categoriesPage = getPages().get(CategoriesPage.class);
        assertThat(categoriesPage.getCategories(), not(hasItem(name)));
    }

    public void should_see_company(String name) {
        CompaniesPage page = getPages().get(CompaniesPage.class);
        assertThat(page.getCompanies(), hasItem(name));
    }

    public void should_not_see_company(String name) {
        CompaniesPage page = getPages().get(CompaniesPage.class);
        assertThat(page.getCompanies(), not(hasItem(name)));
    }

    public void deletes_company() {
        EditCompanyPage page = getPages().get(EditCompanyPage.class);
        page.clickOnDelete();
    }

    public void deletes_company(String name) {
        logs_in_to_admin_page_if_first_time();
        opens_companies_list();

        displays_company_details_for(name);
        deletes_company();
    }

    public void displays_company_details_for(String name) {
        CompaniesPage page = getPages().get(CompaniesPage.class);
        page.selectCompanyInList(name);
    }
}
