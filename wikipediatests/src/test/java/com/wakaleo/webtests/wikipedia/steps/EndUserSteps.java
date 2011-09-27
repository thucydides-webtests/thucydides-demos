package com.wakaleo.webtests.wikipedia.steps;

import com.wakaleo.webtests.wikipedia.pages.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EndUserSteps extends ScenarioSteps {

	public EndUserSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void enters(String keyword) {
        onHomePage().enter_keywords(keyword);
	}

    @Step
    public void starts_search() {
        onHomePage().starts_search();
    }

    private HomePage onHomePage() {
        return getPages().currentPageAt(HomePage.class);
    }

    @Step
	public void should_see_article_with_title(String title) {
        assertThat(onHomePage().getTitle(), is(title));
	}

    @Step
    public void is_on_the_wikipedia_home_page() {
        onHomePage().open();
    }

    @Step
    public void looks_up_cats() {
        enters("cats");
        starts_search();
		should_see_article_with_title("Cat - Wikipedia, the free encyclopedia");
    }
}
