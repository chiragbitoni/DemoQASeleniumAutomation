package com.demoqa.pages.elements;

import org.openqa.selenium.By;

import com.demoqa.pages.BasePage;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ElementsPage extends BasePage {
    private By elementsHeaderCard = By.xpath("//div[@class='accordion']//div[text()='Elements']");
    //Elements cards
    private By textBoxCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[1]");
    private By checkboxCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[2]");
    private By radioButtonCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[3]");
    private By webTablesCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[4]");
    private By buttonsCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[5]");
    private By linksCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[6]");
    private By brokenLinkImageCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[7]");
    private By uploadAndDownloadCard = By.xpath("//div[@class='element-group'][1]/div/ul/li[8]");

    public By fullNameTextField = By.id("userName");
    public By emailTextField = By.id("userEmail");
    public By currentAddressField = By.id("currentAddress");
    public By permanentAddressField = By.id("permanentAddress");
    public By submitButton = By.id("submit");
    public By outputDiv = By.id("output");
    public By homeCheckbox = By.xpath("//label[@for='tree-node-home']//span[@class='rct-checkbox']");
    public By desktopCheckbox = By.xpath("//label[@for='tree-node-desktop']//span[@class='rct-checkbox']");
    public By homeExpandButton = By.xpath("//div[@id=\"tree-node\"]//span//button");
    public By documentsCheckbox = By.xpath("//label[@for='tree-node-documents']//span[@class='rct-checkbox']");
    public By downloadsCheckbox = By.xpath("//label[@for='tree-node-downloads']//span[@class='rct-checkbox']");
    public By checkboxPageOutput = By.xpath("//div[@id='result']//span");
    public By yesRadioButton = By.xpath("//input[@id='yesRadio']");
    public By radioButtonOutput = By.xpath("//p/span");
    public By impressiveRadioButton = By.xpath("//input[@id='impressiveRadio']");
    // WebTables
    public By addButton = By.id("addNewRecordButton");
    public By firstName = By.id("firstName");
    public By lastName = By.id("lastName");
    public By userEmail = By.id("userEmail");
    public By age = By.id("age");
    public By salary = By.id("salary");
    public By department = By.id("department");
    public By addedItem = By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group'][4]");
    public By fourthRowEditButton = By.id("edit-record-4");
    public By fourthRowDeleteButton = By.id("delete-record-4");
    public By searchBox = By.id("searchBox");
    public By tableItems = By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']/div");
    public By columnHeaders = By.xpath("//div[@class='rt-thead -header']/div/div");
    //Buttons Page Elements
    public By doubleClickMeButton = By.id("doubleClickBtn");
    public By rightClickMeButton = By.id("rightClickBtn");
    public By dynamicClickButton = By.xpath("//button[text()='Click Me']");
    public By doubleClickMessage = By.id("doubleClickMessage");
    public By rightClickMessage = By.id("rightClickMessage");
    public By dynamicClickMessage = By.id("dynamicClickMessage");
    public void clickElementsHeaderCard(){
        scrollToElementJS(elementsHeaderCard);
        click(elementsHeaderCard);
    }
    public void clickTextBoxCard(){
        scrollToElementJS(textBoxCard);
        click(textBoxCard);
    }
    public void clickCheckBoxCard(){
        scrollToElementJS(checkboxCard);
        click(checkboxCard);
    }
    public void clickRadioButtonCard(){
        scrollToElementJS(radioButtonCard);
        click(radioButtonCard);
    }
    public void clickWebTablesCard(){
        scrollToElementJS(webTablesCard);
        click(webTablesCard);
    }
    public void clickButtonsCard(){
        scrollToElementJS(buttonsCard);
        click(buttonsCard);
    }
    public void clickLinksCard(){
        scrollToElementJS(linksCard);
        click(linksCard);
    }
    public void clickBrokenLinkImageCard(){
        scrollToElementJS(brokenLinkImageCard);
        click(brokenLinkImageCard);
    }
    public void clickUploadAndDownloadCard(){
        scrollToElementJS(uploadAndDownloadCard);
        click(uploadAndDownloadCard);
    }
}
