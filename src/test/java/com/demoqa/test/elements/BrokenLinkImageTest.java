package com.demoqa.test.elements;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;


public class BrokenLinkImageTest extends BaseTest {
    //region TC010
    /*
        Test case ID: TC010
        Test Summary: Verify that both broken and non-broken images are correctly identified on the page.
     */
    private String url = "";
    private final String basePageURL = "https://demoqa.com";
    private String imageSrc = "";
    private String actual = "";
    private String expected = "falsetrue";
    @Test(description = "TC010: Verify that both broken and non-broken images are correctly identified on the page.")
    public void TC010(){
        homePage.goToElements();
        elementsPage.clickBrokenLinkImageCard();
        actual = String.valueOf(basePage.find(brokenLinkImagePage.validImage).getAttribute("naturalWidth").equals("0"));
        actual += String.valueOf(basePage.find(brokenLinkImagePage.brokenImage).getAttribute("naturalWidth").equals("0"));
        Assert.assertEquals(actual,expected);
    }
    //endregion

    //region TC011
    /*
        Test case ID: TC011
        Test summary: Verify that the valid link redirects to the correct page and the broken link results in an error page.
     */
    @Test(description = "TC011: Verify that the valid link redirects to the correct page and the broken link results in an error page.")
    public void TC011(){
        actual = "";
        expected = "200500";
        homePage.goToElements();
        elementsPage.clickBrokenLinkImageCard();
        basePage.find(brokenLinkImagePage.validLink).sendKeys(Keys.CONTROL,Keys.RETURN);
        ArrayList<String> tabs = new ArrayList<>(basePage.getDriver().getWindowHandles());
        basePage.getDriver().switchTo().window(tabs.get(1));
        url = basePage.getDriver().getCurrentUrl();
        actual = String.valueOf(checkStatusCode(url));
        basePage.getDriver().close();
        basePage.getDriver().switchTo().window(tabs.get(0));
        basePage.find(brokenLinkImagePage.brokenLink).sendKeys(Keys.CONTROL,Keys.RETURN);
        tabs = new ArrayList<>(basePage.getDriver().getWindowHandles());
        basePage.getDriver().switchTo().window(tabs.get(1));
        url = basePage.getDriver().getCurrentUrl();
        actual += String.valueOf(checkStatusCode(url));
        Assert.assertEquals(actual,expected);
    }
    //endregion

    //region Methods
    public int checkStatusCode(String linkUrl) {
        try{
            URL url = new URL(linkUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        }catch(Exception e){
            throw new RuntimeException("Failed to fetch HTTP status");
        }
    }
    //endregion
}
