package Pages;

public class CartPage extends BasePage{

    public static final String cartPageHeader="//h1[text()='Your cart']";
    public static final String letsGetReadingButton="";


    public static boolean isCartHeaderVisible(){
        return elementExists(cartPageHeader);
    }

    public void clickLetsGetReading(){
        clickElementByXpath(letsGetReadingButton);
    }


//    public static boolean isBRLbookVisible(){
//        return elementExists(currancyBRL);
//    }
//
//    public static String isCandaianFlagVisible(){
//        return canadaFlag;
//    }

}
