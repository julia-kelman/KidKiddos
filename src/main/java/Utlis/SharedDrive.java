package Utlis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;


public class SharedDrive {
    private static WebDriver webDriver;


    public enum Browser {
        CHROME,
        FIREFOX,
        EI,
        OPERA
    }
    //browsers:

    protected static WebDriver getWebDriver(Browser browser) {

        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            break;

            case EI:
                WebDriverManager.edgedriver().setup();
                webDriver = new InternetExplorerDriver();
            break;

            case OPERA:
                WebDriverManager.operadriver().setup();
                webDriver = new OperaDriver();
            break;
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return webDriver;

    }

    protected static void closeDriver() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}

