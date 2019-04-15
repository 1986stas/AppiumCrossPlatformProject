package com.stas.osikov.appium.Test;

import com.stas.osikov.appium.AppiumSupport.AppiumBaseClass;
import com.stas.osikov.appium.AppiumSupport.AppiumController;
import com.stas.osikov.appium.PageObjects.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class BaseTestClass extends AppiumBaseClass {
    ContactSearchPage searchPage;
    ContactDetailPage detailPage;

    @BeforeAll
    public void setUp() throws Exception {
        AppiumController.instance.start();
        switch (AppiumController.executionOS) {
            case ANDROID:
            case ANDROID_BROWSERSTACK:
                searchPage = new ContactSearchPageAndroid(driver());
                detailPage = new ContactDetailPageAndroid(driver());
                break;
            case IOS:
            case IOS_BROWSERSTACK:
                searchPage = new ContactSearchPageIOS(driver());
                detailPage = new ContactDetailPageIOS(driver());
                break;
        }
    }

    @AfterAll
    public void tearDown() {
        AppiumController.instance.stop();
    }
}
