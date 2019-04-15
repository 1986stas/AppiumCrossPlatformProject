package com.stas.osikov.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactSearchPageAndroid implements ContactSearchPage {

    public ContactSearchPageAndroid(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(id = "main_search")
    private MobileElement searchField;

    @FindBy(id = "name")
    private MobileElement firstSearchResultName;


    public void search(String name) {
        searchField.sendKeys(name);
    }

    public void assertSearchResult(String expectedResult) {
        assertEquals(expectedResult, firstSearchResultName.getText());
    }

    public void navigateToSearchResultDetails() {
        firstSearchResultName.click();
    }

}
