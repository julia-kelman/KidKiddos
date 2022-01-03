package Pages;

import Consts.Consts;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class  MainPage extends BasePage{

    private static final String logo = "//img[@itemprop='logo']";
    private static final String loginIcon="//a[@class='site-header__account']";
    private static final String countryLogo="//div[@class='cbb-currency-flag']";
    private static final String cartLogo="//a[@class='site-header__cart']";
    private static final String flagsMenu="//ul[@class='currency-converter-chooser skiptranslate notranslate']";
     private static final String BRLflag="//li[@class='currency-converter-chooser-item cbb-currency-code-BRL']";
     private static final String booksByLanguage="//a[@aria-controls='SiteNavLabel-books-by-language']";
     private static final String englishBooks="//a[text()='English Only']";
    private static final String hebrewBooks="//a[text()='Hebrew - עִבְרִית']";

    public boolean openCurrencyMenu(){
        WebElement cartButton=findElementByXpath(cartLogo);
        WebElement currencyMenu= webDriver.findElement(with(By.xpath("//span")).toRightOf(cartButton));
        currencyMenu.click();
        return elementExists(flagsMenu);
    }

    public void navigateToMainPage(){
        webDriver.get(Consts.mainURL);
    }

    public LoginPage navigateToLoginPage() {
        clickElementByXpath(loginIcon);
        return new LoginPage();
    }

//    public  CartPage navigateToCartPage(){
//        clickElementByXpath(cartLogo);
//        return new CartPage();
//    }

    public void logoCapture() throws IOException {
        WebElement Logo=findElementByXpath(logo);
        File file=Logo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));
    }

    public static boolean isLogoVisible() {
        Boolean isVisible=elementExists(logo);
        return isVisible;
    }


    public CartPage openCartPage(){
        clickElementByXpath(cartLogo);
        return new CartPage();
    }

    public EnglishPage openEnglishPage(){
        clickElementByXpath(booksByLanguage);
        clickElementByXpath(englishBooks);
        return new EnglishPage();
    }

    public HebrewPage openHebrewPage(){
        clickElementByXpath(booksByLanguage);
        clickElementByXpath(hebrewBooks);
        return new HebrewPage();
    }

    public void chooseBRLcountry() throws IOException {
        WebElement flagButton=findElementByXpath(countryLogo);
        flagButton.click();
        WebElement brlFlag=webDriver.findElement(with(By.xpath(BRLflag)).near(flagButton));
        brlFlag.click();
        WebElement cadFlag= webDriver.findElement(with(By.xpath("//*[text()='BRL']")).below(flagButton));
        File file=cadFlag.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("BRLFlag.png"));
    }

    public void chooseAutoCurrency() throws IOException {
    WebElement flagButton=findElementByXpath(countryLogo);
    flagButton.click();
    WebElement autoOption= webDriver.findElement(with(By.xpath("//*[text()='Auto']")).below(flagButton));
    autoOption.click();
    WebElement cadFlag= webDriver.findElement(with(By.xpath("//*[text()='CAD']")).below(flagButton));
    File file=cadFlag.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(file, new File("autoCadFlag.png"));
    }



    public Level logsMainPage() {
        LogEntries entries = webDriver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logim = entries.getAll();

        for (LogEntry e : logim) {
            System.out.println("Message" + e.getMessage());
            System.out.println("Level" + e.getLevel());
            e.getLevel();
        }
        return (Level) logim;
    }

    public void getLogoSize(){
        WebElement kidkiddosLogo=webDriver.findElement(By.xpath(logo));
        int height=kidkiddosLogo.getRect().getHeight();
        int width=kidkiddosLogo.getRect().getWidth();
        System.out.println(height+"x"+width);
        Assertions.assertEquals(114,height);
        Assertions.assertEquals(600,width);
    }

}
