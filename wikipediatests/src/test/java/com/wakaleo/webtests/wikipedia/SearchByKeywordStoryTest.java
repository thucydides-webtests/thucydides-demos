package com.wakaleo.webtests.wikipedia;

import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.wakaleo.webtests.wikipedia.requirements.Application;
import com.wakaleo.webtests.wikipedia.steps.EndUserSteps;

@RunWith(ThucydidesRunner.class)
@Story(Application.Search.SearchByKeyword.class)
public class SearchByKeywordStoryTest {

    @Managed
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://www.wikipedia.com")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;
    
    @Test
    public void searching_by_unambiguious_keyword_should_display_the_corresponding_article() {
		endUser.searches_for("cats");
		endUser.should_see_article_with_title("Cat - Wikipedia, the free encyclopedia");                                             }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
} 