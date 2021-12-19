package Pages;

public class EnglishPage extends BasePage{

    //public static MainPage mainPage;

    public static final String headerEnglish="//h1[text()='English Only']";
    public static final String amandaBook="//div[contains(text(),'Amanda')]";
    public static final String amandaBookPage="//h1[contains(text(),'Amanda')]";
    public static final String addToCartButton="//button[@name='add']";
    public static final String oneItemInCart="//div[@id='CartCount']//descendant::*[text()='1']";
    public static final String fiveItemsInCart="//div[@id='CartCount']//descendant::*[text()='5']";
    public static final String addBooksField="//input[@id='Quantity']";
    public static final String addBooksArrows="//form[@action='/cart/add']";
    public static final String twoItemsInCart="//div[@id='CartCount']//descendant::*[text()='2']";


    public boolean isEnglishHeaderVisible(){

        return elementExists(headerEnglish);
    }

    public boolean clickOnBook(){
        clickElementByXpath(amandaBook);
        return elementExists(amandaBookPage);
    }

    public boolean addBookToCart(){
        clickElementByXpath(addToCartButton);
        return elementExists(oneItemInCart);
    }

    public boolean addBooksToCart(){
       findElementByXpath(addBooksField).clear();
        findElementByXpath(addBooksField).sendKeys("5");
        clickElementByXpath(addToCartButton);
        return elementExists(fiveItemsInCart);
    }
//failed
    public boolean addBooksToCartByArrows(){
        clickElementByXpath(addBooksArrows);
        clickElementByXpath(addToCartButton);
        return elementExists(twoItemsInCart);
    }





}
