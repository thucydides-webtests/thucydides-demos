using "thucydides"

import net.thucydides.demos.jobboard.requirements.JobBoardApplication.ManageCategories.AddNewCategory
import net.thucydides.demos.jobboard.steps.AdministratorSteps

thucydides.uses_default_base_url "http://localhost:9000"
thucydides.uses_steps_from AdministratorSteps
thucydides.tests_story AddNewCategory


def setup_database() {
    administrator.logs_in_to_admin_page_if_first_time()
    administrator.adds_category("Category to delete", "DELETABLE");
}

scenario "The administrator deletes a category from the system",
{
	given "the administrator is on the categories list page",
    {
      setup_database()
      administrator.logs_in_to_admin_page_if_first_time()
      administrator.opens_categories_list()
    }
	when "the user deletes a category",
    {
        administrator.displays_category_details_for("Category to delete");
        administrator.deletes_category();
    }
    then "the system will confirm that the category has been deleted",
    {
        administrator.should_see_confirmation_message "The Category has been deleted"
    }
    and "the deleted category should no longer appear in the category list",
    {
        administrator.opens_categories_list();
        administrator.should_not_see_category "Category to delete";
    }
}
