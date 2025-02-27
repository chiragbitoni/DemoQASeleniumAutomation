package com.demoqa.base;

import com.demoqa.pages.BasePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.elements.BrokenLinkImagePage;
import com.demoqa.pages.elements.ElementsPage;
import com.demoqa.pages.elements.LinksPage;
import com.demoqa.pages.elements.UploadAndDownloadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.demoqa.pages.BasePage.delay;
import static utilities.Utilities.setUtilityDriver;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    protected ElementsPage elementsPage;
    protected LinksPage linksPage;
    protected BrokenLinkImagePage brokenLinkImagePage;
    protected UploadAndDownloadPage uploadAndDownloadPage;
    private String url = "https://demoqa.com/";

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void loadUrl(){
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        homePage = new HomePage();
        elementsPage = new ElementsPage();
        linksPage = new LinksPage();
        brokenLinkImagePage = new BrokenLinkImagePage();
        uploadAndDownloadPage = new UploadAndDownloadPage();
    }
    @AfterClass
    public void tearDown(){
        try {
            delay(3000);
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
