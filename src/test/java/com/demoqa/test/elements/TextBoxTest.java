package com.demoqa.test.elements;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class TextBoxTest extends BaseTest {
    /*
    Test Case ID: TC001
    Test Summary: Verify functionality of the text box
    */
    private String expected = "Name:Chirag Bitoni\nEmail:chiragbitoni4994@gmail.com\nCurrent Address :Plot-11, Greater Noida West 201307\nPermananet Address :A-52 Krishi Vihar, New Delhi 110048";
    @Test(description = "TC001: Verify functionality of the text box.")
    public void TC001(){
        homePage.goToElements();
        elementsPage.clickTextBoxCard();
        basePage.setText(elementsPage.fullNameTextField,"Chirag Bitoni");
        basePage.setText(elementsPage.emailTextField,"chiragbitoni4994@gmail.com");
        basePage.setText(elementsPage.currentAddressField,"Plot-11, Greater Noida West\n201307");
        basePage.setText(elementsPage.permanentAddressField,"A-52 Krishi Vihar, New Delhi\n110048");
        scrollToElementJS(elementsPage.submitButton);
        basePage.click(elementsPage.submitButton);
        scrollToElementJS(elementsPage.outputDiv);
        Assert.assertEquals(elementsPage.find(elementsPage.outputDiv).getText(),expected);
    }
}
