package com.wakaleo.webtests.wikipedia

import com.wakaleo.webtests.wikipedia.steps.EndUserSteps
import com.wakaleo.webtests.wikipedia.requirements.Application.Search.SearchByKeyword
import com.wakaleo.webtests.wikipedia.requirements.Application.Search.SearchByPlaceRelatedKeyword

using "thucydides"

thucydides.uses_default_base_url "http://www.wikipedia.com"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SearchByPlaceRelatedKeyword

thucydides.tests_issue "#WIKI-3"

scenario "Searching for cats", {
    given "the user is on the home page", {
        end_user.is_on_the_wikipedia_home_page()
    }
    when "the end user searches for 'bethany'", {
        end_user.looks_for("bethany")
    }
    then "they should see the corresponding article", {
       end_user.should_see_article_with_title("Bethany - Wikipedia, the free encyclopedia")
    }
}
