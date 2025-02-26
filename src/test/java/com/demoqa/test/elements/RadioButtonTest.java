package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class RadioButtonTest extends BaseTest {
    /*
    Test Case ID: TC004
    Test Summary: Verify Radio Button selected state after selecting any of the radio button.
     */
    private String actual = "";
    private String expected = "YesImpressive";
    @Test(description = "TC004: Verify Radio Button selected state after selecting any of the radio button.")
    public void TC004(){
        homePage.goToElements();
        elementsPage.clickRadioButtonCard();
        scrollToElementJS(elementsPage.yesRadioButton);
        clickJS(elementsPage.yesRadioButton);
        actual = basePage.find(elementsPage.radioButtonOutput).getText();
        clickJS(elementsPage.impressiveRadioButton);
        actual += basePage.find(elementsPage.radioButtonOutput).getText();
        Assert.assertEquals(actual,expected);
    }
}
