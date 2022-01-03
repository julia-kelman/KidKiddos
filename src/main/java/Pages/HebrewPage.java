package Pages;

public class HebrewPage extends BasePage{

    public static final String autumnBookHebrew="//div[contains(text(),'I Love Autumn')]";
    public static final String autumnBookPage="//h1[contains(text(),'I Love Autumn')]";
    public static final String oneItemInCart="//div[@id='CartCount']//descendant::*[text()='1']";
    public static final String addToCartButton="//button[@name='add']";

    public boolean clickOnHebrewBook(){
        clickElementByXpath(autumnBookHebrew);
        return elementExists(autumnBookPage);
    }

    public boolean addHebrewBookToCart(){
        clickElementByXpath(addToCartButton);
        return elementExists(oneItemInCart);
    }


}
