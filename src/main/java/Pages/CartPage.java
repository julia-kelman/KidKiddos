package Pages;

public class CartPage extends BasePage{

    public static final String cartPageHeader="//h1[text()='Your cart']";
    public static final String currancyBRL="//span[text()='BRL'])";
    public static final String canadaFlag="//span[text()=' CAD']";


    public static boolean isCartHeaderVisible(){
        return elementExists(cartPageHeader);
    }


    public static boolean isBRLbookVisible(){
        return elementExists(currancyBRL);
    }

    public static String isCandaianFlagVisible(){
        return canadaFlag;
    }

}
