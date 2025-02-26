package com.demoqa.test.elements;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import static com.demoqa.pages.BasePage.delay;


public class LinkTest extends BaseTest {
    //region TC009
    /*
       Test Case ID: TC009
       Test Summary: Verify that navigation links open correctly and API links send the correct response.
    */
    private String actual = "";
    private String expected = "https://demoqa.com/https://demoqa.com/truetruetruetruetruetruetrue";

    @Test(description = "TC009: Verify that navigation links open correctly and API links send the correct response.")
    public void TC009() {
        homePage.goToElements();
        elementsPage.clickLinksCard();
        //link 1
        actual = clickNavigationLinks(linksPage.homeLink);
        //link 2
        actual += clickNavigationLinks(linksPage.dynamicHomeLink);
        //link 3
        actual += clickLinks(linksPage.createdLink,"201","Created");
        //link 4
        actual += clickLinks(linksPage.noContentLink,"204","No Content");
        //link 5
        actual += clickLinks(linksPage.movedLink,"301","Moved Permanently");
        //link 6
        actual += clickLinks(linksPage.badRequestLink,"400","Bad Request");
        //link 7
        actual += clickLinks(linksPage.unauthorizedLink,"401","Unauthorized");
        //link 8
        actual += clickLinks(linksPage.forbiddenLink,"403","Forbidden");
        //link 9
        actual += clickLinks(linksPage.notFoundLink,"404","Not Found");
        Assert.assertEquals(actual, expected);
    }
    //endregion

    //region Methods
    String currentURL = "";
    public String clickNavigationLinks(By link){
        basePage.click(link);
        ArrayList<String> tabs = new ArrayList<>(basePage.getDriver().getWindowHandles());
        basePage.getDriver().switchTo().window(tabs.get(1));
        currentURL = basePage.getDriver().getCurrentUrl();
        basePage.getDriver().close();
        basePage.getDriver().switchTo().window(tabs.get(0));
        return currentURL;
    }
    public String clickLinks(By link, String statusCode, String message){
        basePage.click(link);
        delay(2000);
        return String.valueOf(basePage.find(linksPage.linkResponse).getText().contains(statusCode) &&basePage.find(linksPage.linkResponse).getText().contains(message));
    }
    //endregion
}
