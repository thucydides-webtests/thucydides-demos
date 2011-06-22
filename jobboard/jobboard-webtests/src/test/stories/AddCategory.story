using "thucydides"

import net.thucydides.demos.jobboard.requirements.Application.ManageCategories.AddNewCategory
import net.thucydides.demos.jobboard.steps.AdministratorSteps
import net.thucydides.demos.jobboard.steps.JobSeekerSteps

thucydides.uses_default_base_url "http://localhost:9000"
thucydides.uses_steps_from AdministratorSteps
thucydides.uses_steps_from JobSeekerSteps
thucydides.tests_story AddNewCategory

def cleanup_database() {
    administrator.deletes_category("Scala Developers");
}

scenario "The administrator adds a new category to the system",
{
	given "a new category needs to be added to the system",
    {
      administrator.logs_in_to_admin_page_if_first_time()
      administrator.opens_categories_list()
    }
	when "the administrator adds a new category",
    {
       administrator.selects_add_category()
       administrator.adds_new_category("Scala Developers","SCALA")
    }
    then "the system should confirm that the category has been created",
    {
        administrator.should_see_confirmation_message "The Category has been created"
    }
    and "the new category should be visible to job seekers",
    {
        job_seeker.opens_jobs_page()
        job_seeker.should_see_job_category "Scala Developers"
        cleanup_database()
    }
}

scenario "The administrator adds a category with an existing code to the system",
{
    given "the administrator is on the categories list page"
	when "the user adds a new category with an existing code"
	then "an error message should be displayed"
}