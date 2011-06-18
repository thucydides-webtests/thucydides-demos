package net.thucydides.demos.jobboard.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.demos.jobboard.pages.FindAJobPage;

/**
 * A steps library contains a set of reusable actions that manipulate page objects.
 * Methods annotated with @Step will be recorded and reported in the Thucydides
 * reports.
 *
 * Step libraries can be organized in whatever structure suites you - by feature,
 * by module, by user,...
 */
public class JobSeekerSteps extends ScenarioSteps {
    public JobSeekerSteps(Pages pages) {
        super(pages);
    }


    @Step
    public void open_jobs_page() {
        FindAJobPage page = getPages().get(FindAJobPage.class);
        page.open();
    }

    @Step
    public void search_for_jobs_using(String keywords) {
        FindAJobPage page = getPages().get(FindAJobPage.class);
        page.look_for_jobs_with_keywords(keywords);

    }

    @Step
    public void page_should_display(String message) {
        FindAJobPage page = getPages().get(FindAJobPage.class);
        page.shouldContainText(message);
    }


}
