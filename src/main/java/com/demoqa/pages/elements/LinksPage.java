package com.demoqa.pages.elements;

import org.openqa.selenium.By;

public class LinksPage extends ElementsPage{
    public By homeLink = By.id("simpleLink");
    public By dynamicHomeLink = By.id("dynamicLink");
    public By createdLink = By.id("created");
    public By noContentLink = By.id("no-content");
    public By movedLink = By.id("moved");
    public By badRequestLink = By.id("bad-request");
    public By unauthorizedLink = By.id("unauthorized");
    public By forbiddenLink = By.id("forbidden");
    public By notFoundLink = By.id("invalid-url");
    public By linkResponse = By.id("linkResponse");
}
