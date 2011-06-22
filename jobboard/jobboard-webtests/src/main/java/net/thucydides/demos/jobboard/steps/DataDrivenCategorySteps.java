package net.thucydides.demos.jobboard.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class DataDrivenCategorySteps extends ScenarioSteps {
    public DataDrivenCategorySteps(Pages pages) {
        super(pages);
    }

    private String name;
    private String code;

    @Steps
    public AdministratorSteps administratorSteps;

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Step
    public void add_a_category() {
        System.out.println("Adding category for " + name + "/" + code);
        administratorSteps.adds_category(name, code);
    }

    @Step
    public void delete_a_category() {
        System.out.println("Deleting category for " + name);
        administratorSteps.deletes_category(name);
    }

}
