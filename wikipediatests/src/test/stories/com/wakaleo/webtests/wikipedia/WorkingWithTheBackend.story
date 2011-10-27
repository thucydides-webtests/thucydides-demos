package com.wakaleo.webtests.wikipedia

import com.wakaleo.webtests.wikipedia.requirements.Application.Backend.ProcessSales
import com.wakaleo.webtests.wikipedia.steps.BackendSteps

using "thucydides"

thucydides.uses_steps_from BackendSteps
thucydides.tests_story ProcessSales

thucydides.tests_issue "#WIKI-1"

scenario "Processing a sales transation", {
    when "the backend processes a sale", {
        backend.accepts_a_sale_transaction()
    }
    then "the mainframe should be updated", {
       backend.should_the_update_mainframe()
    }
}
