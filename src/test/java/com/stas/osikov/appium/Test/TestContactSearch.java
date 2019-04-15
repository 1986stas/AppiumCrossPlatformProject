package com.stas.osikov.appium.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestContactSearch extends BaseTestClass {

    @Test
    public void searchContact() {
        //Search for contact
        searchPage.search("Sara");

        //Verify result
        searchPage.assertSearchResult("Sara Alston");

        //Navigate to detail page
        searchPage.navigateToSearchResultDetails();

        //Verify that correct page is displayed
        detailPage.assertContactName("Sara Alston");
    }
}
