using "thucydides"

import net.thucydides.demos.jobboard.requirements.JobBoardApplication.ManageCategories.AddNewCategory
import net.thucydides.demos.jobboard.steps.AdministratorSteps

thucydides.uses_default_base_url "http://localhost:9000"
thucydides.uses_steps_from AdministratorSteps
thucydides.tests_story AddNewCategory

scenario "The administrator rename a category in the system",
{
	given "the administrator is on the categories list page"
	when "the user renames a category"
    then "the system will confirm that the category has been renamed"
    and "the category should appear with its new name in the category list"
}
