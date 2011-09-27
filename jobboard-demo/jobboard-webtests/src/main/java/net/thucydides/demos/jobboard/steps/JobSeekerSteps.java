package net.thucydides.demos.jobboard.steps;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.demos.jobboard.pages.FindAJobPage;
import org.openqa.selenium.By;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

/**
 * A job_seeker library contains a set of reusable actions that manipulate page objects.
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
    public void opens_jobs_page() {
        FindAJobPage page = getPages().get(FindAJobPage.class);
        page.open();
    }

    @Step
    public void searches_for_jobs_using(String keywords) {
        FindAJobPage page = getPages().get(FindAJobPage.class);
        page.look_for_jobs_with_keywords(keywords);
    }

    @Step
    public void should_see_message(String message) {
        FindAJobPage page = getPages().get(FindAJobPage.class);
        page.shouldContainText(message);
    }

    @Step
    public void should_see_job_categories(String... categories) {
        FindAJobPage page = getPages().get(FindAJobPage.class);
        List<String> jobTabs = page.getJobTabs();
        assertThat(jobTabs,hasItems(categories));
    }

    @Step
    public void should_see_job_category(String category) {
        FindAJobPage page = getPages().get(FindAJobPage.class);
        List<String> jobTabs = page.getJobTabs();
        assertThat(jobTabs,hasItem(category));
    }

    @Step
    @Pending
    public JobSeekerSteps called(String name) {
        return this;
    }

    @Step
    @Pending
    public void looks_for_jobs_by_keyword(String keyword) {}

    @Step
    @Pending
    public void should_see_job_posting_called(String jobName) {}

    @Step
    @Pending
    public void opens_job_posting_called(String jobName) {
     }

    @Step
    @Pending
    public void applies_for_job() {}

    @Step
    @Pending
    public void should_see_confirmation_page_for(String jobName) {
    }

}
