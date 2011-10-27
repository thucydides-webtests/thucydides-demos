package com.wakaleo.webtests.wikipedia.requirements;

import net.thucydides.core.annotations.Feature;

public class Application {
    @Feature
    public class Search {
        public class SearchByKeyword {}
        public class SearchByAnimalRelatedKeyword {}
        public class SearchByFoodRelatedKeyword {}
        public class SearchByMultipleKeywords {}
        public class SearchForQuote{}
    }

    @Feature
    public class Backend {
        public class ProcessSales {}
        public class ProcessSubscriptions {}
    }

    @Feature
    public class Contribute {
        public class AddNewArticle {}
        public class EditExistingArticle {}
    }
}