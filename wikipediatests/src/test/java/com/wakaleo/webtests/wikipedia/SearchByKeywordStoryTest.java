package com.wakaleo.webtests.wikipedia;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.wakaleo.webtests.wikipedia.requirements.Application;
import com.wakaleo.webtests.wikipedia.steps.EndUserSteps;

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
@Issue("#WIKI-1")
public class SearchByKeywordStoryTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://www.wikipedia.com")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    @Issue("#WIKI-1")
    @Test
    public void searching_by_unambiguious_keyword_should_display_the_corresponding_article() {
        endUser.is_on_the_wikipedia_home_page();
		endUser.looks_for("bethany");
        endUser.should_see_article_with_title("Bethany - Wikipedia, the free encyclopedia");

    }

    @Test
    public void searching_by_keyword_attica_should_display_the_corresponding_article() {
        endUser.is_on_the_wikipedia_home_page();
		endUser.looks_for("attica");
		endUser.should_see_article_with_title("Attica - Wikipedia, the free encyclopedia");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
} 