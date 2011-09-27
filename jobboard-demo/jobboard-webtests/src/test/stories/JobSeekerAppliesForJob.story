using "thucydides"

import net.thucydides.demos.jobboard.requirements.JobBoardApplication.LookForJobs.JobSeekerBrowsesJobAds
import net.thucydides.demos.jobboard.steps.JobSeekerSteps
import net.thucydides.demos.jobboard.steps.EmployerSteps

thucydides.uses_default_base_url "http://localhost:9000"
thucydides.uses_steps_from JobSeekerSteps
thucydides.uses_steps_from EmployerSteps
thucydides.tests_story JobSeekerAppliesForJob

scenario "A job seeker can apply for a job online",
{
    given "the job seeker is looking for a job as a Java developer", {
        job_seeker.called("Joe Blogs").opens_jobs_page()
        job_seeker.looks_for_jobs_by_keyword("Java")
    }
    when "the job seeker find a job post for a Java Developer at Acme Consulting", {
        job_seeker.should_see_job_posting_called("Java Developer at Acme Consulting")
    }
    and "the job seeker applies for the job", {
        job_seeker.opens_job_posting_called("Java Developer at Acme Consulting")
        job_seeker.applies_for_job()
    }
    then "the job seeker should see a confirmation of the job application", {
        job_seeker.should_see_confirmation_page_for("Java Developer at Acme Consulting")
    }
    and "And the employer (Acme Consulting) should be notified", {
        employer.called("Acme Consulting").opens_job_postings()
        employer.should_see_candidate("Joe Blogs").for_job_posting("Java Developer at Acme Consulting")
    }
}
