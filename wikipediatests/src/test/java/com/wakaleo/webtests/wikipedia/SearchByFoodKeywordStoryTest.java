package com.wakaleo.webtests.wikipedia;

import com.wakaleo.webtests.wikipedia.requirements.Application;
import com.wakaleo.webtests.wikipedia.steps.EndUserSteps;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
@Story(Application.Search.SearchByKeyword.class)
public class SearchByFoodKeywordStoryTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://www.wikipedia.com")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    @Test
    public void searching_by_keyword_guava_should_display_the_corresponding_article() {
        endUser.is_on_the_wikipedia_home_page();
		endUser.enters("guava");
        endUser.starts_search();
		endUser.should_see_article_with_title_starting_with("Guava");
    }

    @Test
    public void searching_by_keyword_pineapples_should_display_the_corresponding_article() {
        endUser.is_on_the_wikipedia_home_page();
		endUser.enters("pineapples");
        endUser.starts_search();
        endUser.should_see_article_with_title_starting_with("Pineapple");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }
} 