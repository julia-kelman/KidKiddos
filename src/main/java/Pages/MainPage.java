package Pages;

import Consts.Consts;

public class  MainPage extends BasePage{

    private static final String logo = "//img[@itemprop='logo']";
    private static final String loginIcon="//a[@class='site-header__account']";
    private static final String cartLogo="//a[@class='site-header__cart']";
    private static final String countryLogo="//div[@class='cbb-currency-flag']";
    //private static final String BRLflag="//li[@class='currency-converter-chooser-item cbb-currency-code-BRL']//descendant::span[text()='BRL']";
    //private static final String BRLflag="//span[text()='currency-converter-chooser-item cbb-currency-code-BRL']";
    private static final String flagsMenu="//ul[@class='currency-converter-chooser skiptranslate notranslate']";
    private static final String BRLflag="//*[text()='BRL']";
    private static final String autoCurrency="//span[text()='Auto']";



    public void navigateToMainPage(){
        webDriver.get(Consts.mainURL);
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

    public boolean openCurrencyMenu(){
        clickElementByXpath(countryLogo);
        return elementExists(flagsMenu);
    }

    public void chooseBRLcountry() {
        clickElementByXpath(BRLflag);
        //return new BRLpage;
    }

    public CartPage chooseAutoCurrency() {
        clickElementByXpath(countryLogo);

        clickElementByXpath(autoCurrency);
        return new CartPage();
    }




}
