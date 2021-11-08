package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);

    }

    public static WebElement findElementByXpath(String xpath){
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

        element=webDriver.findElement(By.xpath(xpath));
        return element;
    }

    public static void clickElementByXpath(String xpath){
        findElementByXpath(xpath).click();
    }

    protected void sendTextElementByXpath(String xpath, String text) {

        findElementByXpath(xpath).sendKeys(text);
    }

    protected static boolean elementExists(String xpath){
        try{
            findElementByXpath(xpath);
            return true;
        }
        catch (Exception err){
            return false;
        }

    }

    protected String getCurrentURL(){
        return webDriver.getCurrentUrl();
    }
}
