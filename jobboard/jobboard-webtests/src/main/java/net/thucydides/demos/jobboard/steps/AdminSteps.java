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
 * A steps library contains a set of reusable actions that manipulate page objects.
 * Methods annotated with @Step will be recorded and reported in the Thucydides
 * reports.
 * <p/>
 * Step libraries can be organized in whatever structure suites you - by feature,
 * by module, by user,...
 */
public class AdminSteps extends ScenarioSteps {
    public AdminSteps(Pages pages) {
        super(pages);
    }


    @Step
    public void login_to_admin_page_if_first_time() {
        AdminLoginPage page = getPages().get(AdminLoginPage.class);
        if (!page.containsText("Logout")) {
            page.open();
            page.login("admin", "admin");
        }
    }


    @Step
    public void open_categories_list() {
        AdminHomePage page = getPages().get(AdminHomePage.class);
        page.open();
        page.selectObjectType("Categories");
    }

    @StepGroup
    public void add_category(String name, String code) {
        open_categories_list();
        select_add_category();
        add_new_category(name, code);
    }

    @StepGroup
    public void delete_category(String name) {
        display_category_details_for(name);
        delete_category();
    }

    @Step
    public void select_add_category() {
        CategoriesPage categoriesPage = getPages().get(CategoriesPage.class);
        categoriesPage.selectAddCategory();
    }

    @Step
    public void add_new_category(String label, String code) {
        EditCategoryPage newCategoryPage = getPages().get(EditCategoryPage.class);
        newCategoryPage.saveNewCategory(label, code);
    }

    @Step
    public void confirmation_message_should_be_displayed(String message) {
        AdminPage page = getPages().get(AdminPage.class);
        page.shouldContainConfirmationMessage(message);
    }

    @Step
    public void open_companies_list() {
        AdminHomePage page = getPages().get(AdminHomePage.class);
        page.selectObjectType("Companies");
    }

    @Step
    public void select_add_company() {
        CompaniesPage companiesPage = getPages().get(CompaniesPage.class);
        companiesPage.selectAddCompany();
    }


    @Step
    public void add_new_company(String name, String email, String password, String website, String logoFilepath) {
        EditCompanyPage onPage = getPages().get(EditCompanyPage.class);
        onPage.setName(name);
        onPage.setEmail(email);
        onPage.setPassword(password);
        onPage.setWebsite(website);
        onPage.loadLogoFrom(logoFilepath);
        onPage.createNewCompany();
    }

    @Step
    public void error_message_should_be_displayed(String message) {
        AdminPage page = getPages().get(AdminPage.class);
        assertThat(page.getErrorMessages(), hasItem(message));
    }

    public void display_category_details_for(String name) {
        CategoriesPage categoriesPage = getPages().get(CategoriesPage.class);
        categoriesPage.selectCategoryInList(name);
    }

    public void delete_category() {
        EditCategoryPage categoryPage = getPages().get(EditCategoryPage.class);
        categoryPage.clickOnDelete();
    }

    public void category_should_appear(String name) {
        CategoriesPage categoriesPage = getPages().get(CategoriesPage.class);
        assertThat(categoriesPage.getCategories(), hasItem(name));

    }

    public void category_should_not_appear(String name) {
        CategoriesPage categoriesPage = getPages().get(CategoriesPage.class);
        assertThat(categoriesPage.getCategories(), not(hasItem(name)));
    }

}
