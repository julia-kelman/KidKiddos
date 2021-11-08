package Utlis;

import Pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class UseCaseBase {
    private static WebDriver driver;
    private static BasePage page;

    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        driver = SharedDrive.getWebDriver(SharedDrive.Browser.CHROME);
        page.setWebDriver(driver);
    }

    @AfterAll
    public static void tearDownMain(){
        SharedDrive.closeDriver();
        driver=null;
    }
}
