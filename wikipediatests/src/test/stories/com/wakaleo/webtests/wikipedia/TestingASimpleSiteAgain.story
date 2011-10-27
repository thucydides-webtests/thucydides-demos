package com.wakaleo.webtests.wikipedia

import com.wakaleo.webtests.wikipedia.steps.EndUserSteps
import com.wakaleo.webtests.wikipedia.requirements.Application.Search.SearchByKeyword
import com.wakaleo.webtests.wikipedia.requirements.Application.Search.SearchByAnimalRelatedKeyword
import com.wakaleo.webtests.wikipedia.requirements.Application.Search.SearchByFoodRelatedKeyword

using "thucydides"

thucydides.uses_default_base_url "http://www.wikipedia.com"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SearchByFoodRelatedKeyword

scenario "Searching for fruit", {
    given "the user is on the home page", {
        end_user.is_on_the_wikipedia_home_page()
    }
    when "the end user searches for 'bananas'", {
        end_user.looks_for('bananas')
    }
    then "they should see the corresponding article", {
       end_user.should_see_article_with_title("Banana - Wikipedia, the free encyclopedia")
    }
}
