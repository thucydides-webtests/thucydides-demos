package net.thucydides.demos.jobboard.requirements;

import net.thucydides.core.annotations.Feature;

/**
 * The requirements are organized into features and stories.
 * This is a convenience to make organizing and refactoring tests easier.
 */

public class Application {

    @Feature
    public class ManageCompanies {
        public class AddNewCompany {}
        public class DeleteCompany {}
        public class ListCompanies {}
    }

    @Feature
    public class ManageCategories {
        public class AddNewCategory {}
        public class ListCategories {}
        public class DeleteCategory {}
    }

    @Feature
    public class ManageTags {
        public class DisplayTagCloud {}
    }

    @Feature
    public class ManageJobs {}

    @Feature
    public class BrowseJobs {
        public class UserLookForJobs {}
        public class UserBrowsesJobTabs {}
    }
}


