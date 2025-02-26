package com.demoqa.test.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.base.BaseTest;


public class WebTablesTest extends BaseTest {
    //region TC005
    /*
       Test Case ID: TC005
       Test Summary: Verify that a user can add, edit, and delete records in the table.
        */
    private String actual = "";
    private String rowData = "";
    private String expected = "ChiragBitoni23chiragbitoni4994@gmail.com70000000ITChiragBitoni23chiragbitoni4994@gmail.com70000000Developer Tools";
    @Test(description = "TC005: Verify that a user can add, edit, and delete records in the table.")
    public void TC005(){
        homePage.goToElements();
        elementsPage.clickWebTablesCard();
        basePage.find(elementsPage.addButton).click();
        basePage.setText(elementsPage.firstName, "Chirag");
        basePage.setText(elementsPage.lastName, "Bitoni");
        basePage.setText(elementsPage.userEmail, "chiragbitoni4994@gmail.com");
        basePage.setText(elementsPage.age, "23");
        basePage.setText(elementsPage.salary, "70000000");
        basePage.setText(elementsPage.department, "IT");
        basePage.find(elementsPage.submitButton).click();
        for(WebElement items : basePage.findElements(elementsPage.addedItem)){
            actual += items.getText().trim();
        };
        actual = actual.replaceAll("\\n","");
        basePage.find(elementsPage.fourthRowEditButton).click();
        basePage.setText((elementsPage.department), "Developer Tools");
        basePage.find(elementsPage.submitButton).click();
        for(WebElement items : basePage.findElements(elementsPage.addedItem)){
            rowData += items.getText().trim();
        };
        actual += rowData.replaceAll("\\n","");
        basePage.find(elementsPage.fourthRowDeleteButton).click();
        for(WebElement items : basePage.findElements(elementsPage.addedItem)){
            actual += items.getText().trim();
        };
        Assert.assertEquals(actual,expected);
    }
    //endregion

    //region TC006
    /*
       Test Case ID: TC006
       Test Summary: Verify that the search and reset functionalities work correctly.
     */
    @Test(description = "TC006: Verify that the search and reset functionalities work correctly.")
    public void TC006(){
        actual = "";
        expected = "CierraVega39cierra@example.com10000InsuranceCierraVega39cierra@example.com10000InsuranceAldenCantrell45alden@example.com12000ComplianceKierraGentry29kierra@example.com2000Legal";
        homePage.goToElements();
        elementsPage.clickWebTablesCard();
        basePage.setText(elementsPage.searchBox,"Insurance");
        actual = getItems();
        for(int i=0;i<="Insurance".length();i++){
            basePage.find(elementsPage.searchBox).sendKeys(Keys.BACK_SPACE);
        }
        actual += getItems();
        Assert.assertEquals(actual,expected);
    }
    //endregion

    //region TC007
    /*
       Test Case ID: TC007
       Test Summary: Verify that sorting works correctly.
     */
    @Test(description = "TC007: Verify that sorting works correctly.")
    public void TC007(){
        actual = "";
        expected = "293945453929";
        homePage.goToElements();
        elementsPage.clickWebTablesCard();
        basePage.findElements(elementsPage.columnHeaders).get(2).click();
        actual = getNthItems(2).trim();
        basePage.findElements(elementsPage.columnHeaders).get(2).click();
        actual += getNthItems(2).trim();
        Assert.assertEquals(actual,expected);
    }
    //endregion

    //region Methods
    private String getItems() {
        String text = "";
        for(WebElement row : basePage.findElements(elementsPage.tableItems)){
            for(WebElement item: row.findElements(By.tagName("div"))){
                text += item.getText().trim();
            }
        }
        return text.replaceAll("\\n","");
    }
    private String getNthItems(int index) {
        String text = "";
        for(WebElement row : basePage.findElements(elementsPage.tableItems)){
            text += row.findElements(By.tagName("div")).get(index).getText();
        }
        return text.replaceAll("\\n","");
    }
    //endregion
}
