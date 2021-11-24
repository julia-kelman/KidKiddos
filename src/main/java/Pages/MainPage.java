package Pages;

import Consts.Consts;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
//import static sun.security.krb5.internal.KDCOptions.with;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


import java.io.File;
import java.io.IOException;

public class  MainPage extends BasePage{

    private static final String logo = "//img[@itemprop='logo']";
    private static final String loginIcon="//a[@class='site-header__account']";

    private static final String countryLogo="//div[@class='cbb-currency-flag']";
    //private static final String cadCurrency=webDriver.findElement(with(By.xpath("//text()=CAD")).below(countryLogo));


    //private static final String flagsMenu="//ul[@class='currency-converter-chooser skiptranslate notranslate']";
    //private static final String BRLflag="//*[text()='BRL']";
    private static final String autoCurrency="//span[text()='Auto']";


    private static final String cartLogo="//a[@class='site-header__cart']";
    private static final String flagsMenu="//ul[@class='currency-converter-chooser skiptranslate notranslate']";

    //private static final String BRLflag="//li[@class='currency-converter-chooser-item cbb-currency-code-BRL']//descendant::span[text()='BRL']";
    //private static final String BRLflag="//span[text()='currency-converter-chooser-item cbb-currency-code-BRL']";
     private static final String BRLflag="//li[@class='currency-converter-chooser-item cbb-currency-code-BRL']";


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
//
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

    public boolean openLoginPage(){
        clickElementByXpath(loginIcon);
        return elementExists(logo);
    }


    public CartPage openCartPage(){
        clickElementByXpath(cartLogo);
        return new CartPage();
    }

    //correct last 2 tests

    public BRLpage chooseBRLcountry() {
        WebElement flagButton=findElementByXpath(countryLogo);
        flagButton.click();
        WebElement brlFlag=webDriver.findElement(with(By.xpath(BRLflag)).near(flagButton));
        brlFlag.click();
        return new BRLPage();
    }

    public boolean chooseAutoCurrency() {
    WebElement flagButton=findElementByXpath(countryLogo);
    flagButton.click();
    WebElement autoOption= webDriver.findElement(with(By.xpath("//*[text()='Auto']")).below(flagButton));
    autoOption.click();
    String cadFlag= String.valueOf(webDriver.findElement(with(By.xpath("//*[text()='CAD']")).below(flagButton)));
    return elementExists(cadFlag);

    }

}
