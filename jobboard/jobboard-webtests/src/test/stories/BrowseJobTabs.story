using "thucydides"

import net.thucydides.demos.jobboard.requirements.Application.BrowseJobs.UserBrowsesJobTabs
import net.thucydides.demos.jobboard.steps.AdministratorSteps
import net.thucydides.demos.jobboard.steps.JobSeekerSteps

thucydides.uses_default_base_url "http://localhost:9000"
thucydides.uses_steps_from AdministratorSteps
thucydides.uses_steps_from JobSeekerSteps
thucydides.tests_story UserBrowsesJobTabs


def setup_database() {
    administrator.logs_in_to_admin_page_if_first_time()
    administrator.adds_category "Groovy Developers", "Groovy"
    administrator.adds_category "Grails Developers", "Grails"
    administrator.adds_category "Griffon Developers", "Griffon"
    administrator.logout()
}

def cleanup_database() {
    administrator.logs_in_to_admin_page_if_first_time()
    administrator.deletes_category "Groovy Developers"
    administrator.deletes_category "Grails Developers"
    administrator.deletes_category "Griffon Developers"
}

scenario "The user can see the available job categories on the home page",
{
	when "the user is on the home page",
    {
       setup_database()
       job_seeker.opens_jobs_page()
    }
	then "the user can see the available job categories",
    {
       job_seeker.should_see_job_categories "Groovy Developers", "Grails Developers", "Griffon Developers"
       cleanup_database()
    }
}
