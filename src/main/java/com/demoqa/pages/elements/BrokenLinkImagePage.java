package com.demoqa.pages.elements;

import org.openqa.selenium.By;

public class BrokenLinkImagePage extends ElementsPage{
    public By validImage = By.xpath("//div[@class='col-12 mt-4 col-md-6']//img[@src='/images/Toolsqa.jpg']");
    public By brokenImage = By.xpath("//div[@class='col-12 mt-4 col-md-6']//img[@src='/images/Toolsqa_1.jpg']");
    public By validLink = By.xpath("//a[@href='http://demoqa.com']");
    public By brokenLink = By.xpath("//a[@href='http://the-internet.herokuapp.com/status_codes/500']");
}
