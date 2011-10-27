package com.wakaleo.webtests.wikipedia

import com.wakaleo.webtests.wikipedia.requirements.Application.Backend.ProcessSubscriptions
import com.wakaleo.webtests.wikipedia.steps.BackendSteps

using "thucydides"

thucydides.uses_steps_from BackendSteps
thucydides.tests_story ProcessSubscriptions

scenario "Processing a substription transation", {
    when "the backend processes a subscription"
    then "the mainframe should be updated"
}

scenario "Cancelling a substription", {
    when "the backend cancels a subscription"
    then "the mainframe should be updated"
}

scenario "Renewing a substription", {
    when "the backend renewing a subscription"
    then "the mainframe should be updated"
}
