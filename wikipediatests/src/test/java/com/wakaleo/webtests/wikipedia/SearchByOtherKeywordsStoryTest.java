package com.wakaleo.webtests.wikipedia;

import com.wakaleo.webtests.wikipedia.requirements.Application;
import com.wakaleo.webtests.wikipedia.steps.EndUserSteps;
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
@Story(Application.Search.SearchByMultipleKeywords.class)
public class SearchByOtherKeywordsStoryTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://www.wikipedia.com")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    @Test
    public void search_by_cities() {
        endUser.is_on_the_wikipedia_home_page();
		endUser.searches_using_several_terms("London","Paris");
        endUser.should_see_all_terms("London", "Paris");
    }

    @Test
    public void search_by_apples_and_oranges() {
        endUser.is_on_the_wikipedia_home_page();
		endUser.searches_using_several_terms("New York","Boston");
        endUser.should_see_all_terms("New York", "Boston");
    }

}