package utilities;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;

public class Utilities {
    public static WebDriver driver;
    public static void setUtilityDriver(){
        driver = BasePage.driver;
    }
    public static String getSystemDownloadPath(){
        return Paths.get(System.getProperty("user.home"), "Downloads").toString();
    }
}
