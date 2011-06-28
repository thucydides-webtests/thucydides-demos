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
	public void searches_for(String keyword) {
		HomePage homePage = getPages().currentPageAt(HomePage.class);
		homePage.enter_keywords(keyword);
	}

	@Step
	public void should_see_article_with_title(String title) {
		HomePage homePage = getPages().currentPageAt(HomePage.class);
		assertThat(homePage.getTitle(), is(title));
	}
}
