package com.wakaleo.webtests.wikipedia.requirements;

import net.thucydides.core.annotations.Feature;

public class Application {
    @Feature
    public class Search {
        public class SearchByKeyword {}
        public class SearchForQuote{}
    }

    @Feature
    public class Contribute {
        public class AddNewArticle {}
        public class EditExistingArticle {}
    }
}