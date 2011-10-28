package com.wakaleo.webtests.wikipedia

import com.wakaleo.webtests.wikipedia.steps.EndUserSteps
import com.wakaleo.webtests.wikipedia.requirements.Application.Search.SearchByPlaceRelatedKeyword

using "thucydides"

thucydides.uses_default_base_url "http://www.wikipedia.com"
thucydides.uses_steps_from EndUserSteps
thucydides.tests_story SearchByPlaceRelatedKeyword

thucydides.tests_issue "#WIKI-4"

scenario "Searching for multiple terms", {
    given "the user is on the home page", {
        end_user.is_on_the_wikipedia_home_page()
    }
    when "the end user searches for 'cats' and 'dogs'", {
        end_user.enters_terms 'cats', 'dogs'
    }
    and "the end user starts the search", {
        end_user.starts_search()
    }
    then "they should see the corresponding articles", {
       end_user.should_see_all_terms 'Cats', 'Dogs'
    }
}
