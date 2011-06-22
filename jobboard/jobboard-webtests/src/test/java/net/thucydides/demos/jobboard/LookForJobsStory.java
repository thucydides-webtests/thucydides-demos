package net.thucydides.demos.jobboard;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.demos.jobboard.requirements.Application.BrowseJobs.UserLookForJobs;
import net.thucydides.demos.jobboard.steps.JobSeekerSteps;
import net.thucydides.junit.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@Story(UserLookForJobs.class)
public class LookForJobsStory {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://localhost:9000")
    public Pages pages;

    @Steps
    public JobSeekerSteps job_seeker;

    @Test
    public void user_looks_for_jobs_by_key_word() {
        job_seeker.opens_jobs_page();
        job_seeker.searches_for_jobs_using("Java");
        job_seeker.should_see_message("No jobs found.");
    }

    @Test
    public void when_no_matching_job_found_should_display_error_message() {
        job_seeker.opens_jobs_page();
        job_seeker.searches_for_jobs_using("unknownJobCriteria");
        job_seeker.should_see_message("No jobs found.");
    }

    @Pending @Test
    public void tags_should_be_displayed_to_help_the_user_find_jobs() {}

}
