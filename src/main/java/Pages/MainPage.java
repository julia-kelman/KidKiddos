package Pages;

import Consts.Consts;

public class  MainPage extends BasePage{

    private static final String logo = "//img[@itemprop='logo']";
    private static final String loginIcon="//a[@class='site-header__account']";
    private static final String cartLogo="//a[@class='site-header__cart']";
    private static final String countryLogo="//div[@class='cbb-currency-flag']";
    //private static final String BRLflag="//li[@class='currency-converter-chooser-item cbb-currency-code-BRL']//descendant::span[text()='BRL']";
    //private static final String BRLflag="//span[text()='currency-converter-chooser-item cbb-currency-code-BRL']";
    private static final String BRLflag="//*[text()='BRL']";
    private static final String autoCurrency="//span[text()='Auto']";
    public static final String currancyBRL="//span[text()='BRL'])";
    public static final String canadaFlag="//span[text()=' CAD']";


    public void navigateToMainPage(){
        webDriver.get(Consts.mainURL);
    }

    public static boolean isLogoVisible() {
        Boolean isVisible=elementExists(logo);
        return isVisible;
    }

    public LoginPage openLoginPage(){
        clickElementByXpath(loginIcon);
        return new LoginPage();
    }


    public CartPage openCartPage(){
        clickElementByXpath(cartLogo);
        return new CartPage();
    }

    public void openCurrencyMenu(){
        clickElementByXpath(countryLogo);
    }

    public void chooseBRLcountry() {
        clickElementByXpath(BRLflag);
        //return new BRLpage;
    }

    public CartPage chooseAutoCurrency() throws InterruptedException {
        clickElementByXpath(countryLogo);

        clickElementByXpath(autoCurrency);
        return new CartPage();
    }




}
