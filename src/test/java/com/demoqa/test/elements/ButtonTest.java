package com.demoqa.test.elements;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;
import static com.demoqa.pages.BasePage.delay;


public class ButtonTest extends BaseTest {

    //region TC008
    /*
        Test Case ID: TC008
        Test Summary: Verify that Right Click, Double Click and Single Click works correctly.
    */
    private String actual = "";
    private String expected = "truetruetrue";
    @Test(description = "TC008: Verify that Right Click, Double Click and Single Click works correctly.")
    public void TC008(){
        homePage.goToElements();
        elementsPage.clickButtonsCard();
        Actions action = new Actions(basePage.getDriver());
        action.doubleClick(basePage.find(elementsPage.doubleClickMeButton)).perform();
        delay(1000);
        action.contextClick(basePage.find(elementsPage.rightClickMeButton)).perform();
        basePage.click(elementsPage.dynamicClickButton);
        actual = String.valueOf(basePage.find(elementsPage.doubleClickMessage).isDisplayed());
        actual += String.valueOf(basePage.find(elementsPage.rightClickMessage).isDisplayed());
        actual += String.valueOf(basePage.find(elementsPage.dynamicClickMessage).isDisplayed());
        Assert.assertEquals(actual,expected);
    }
    //endregion
}
