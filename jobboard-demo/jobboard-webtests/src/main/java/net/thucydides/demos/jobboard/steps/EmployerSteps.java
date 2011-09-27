package net.thucydides.demos.jobboard.steps;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.demos.jobboard.pages.FindAJobPage;

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
public class EmployerSteps extends ScenarioSteps {
    public EmployerSteps(Pages pages) {
        super(pages);
    }


    @Step
    @Pending
    public EmployerSteps called(String name) {
        return this;
    }

    @Step
    @Pending
    public void opens_job_postings() {}

    @Step
    @Pending
    public EmployerSteps should_see_candidate(String name) {
        return this;
    }

    @Step
    @Pending
    public void for_job_posting(String jobName) {}

}
