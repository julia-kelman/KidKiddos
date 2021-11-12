package Pages;

public class CartPage extends BasePage{

    public static final String cartPageHeader="//h1[text()='Your cart']";
    public static final String currancyBRL="//span[text()='BRL'])";
    public static final String canadaFlag="//span[text()=' CAD']";


    public boolean isCartHeaderVisible(){

        return elementExists(cartPageHeader);
    }

    public boolean isBRLbookVisible(){
        return elementExists(currancyBRL);
    }

    public boolean isCandaianFlagVisible(){
        return elementExists(canadaFlag);
    }

}
