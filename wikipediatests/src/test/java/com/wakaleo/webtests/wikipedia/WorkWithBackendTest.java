package com.wakaleo.webtests.wikipedia;

import com.wakaleo.webtests.wikipedia.requirements.Application;
import com.wakaleo.webtests.wikipedia.steps.BackendSteps;
import com.wakaleo.webtests.wikipedia.steps.EndUserSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@Story(Application.Backend.ProcessSales.class)
public class WorkWithBackendTest {

    @Steps
    public BackendSteps backend;

    @Issue("#WIKI-1")
    @Test
    public void when_processing_a_sale_transation() {
        backend.accepts_a_sale_transaction();
        backend.should_the_update_mainframe();
    }
}