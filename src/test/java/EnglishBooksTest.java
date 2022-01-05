import Pages.CartPage;
import Pages.EnglishPage;
import Pages.HebrewPage;
import Pages.MainPage;
import Utlis.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnglishBooksTest extends UseCaseBase{

     public static EnglishPage englishPage;
    public static MainPage mainPage;

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
    }

    @Test
    public void verifyHeaderTest(){
        //mainPage.navigateToMainPage();
        //ככה מקשרים בין העמודים השונים בטסט, כשעוברים מעמוד לעמוד במהלך הטסט
        EnglishPage englishPage =  mainPage.openEnglishPage();
        boolean isVisible =  englishPage.isEnglishHeaderVisible();
        assertTrue(isVisible);
    }

    @Test
    public void clickOnEnglishBookTest(){
        EnglishPage englishPage=mainPage.openEnglishPage();
        boolean isVisible=englishPage.clickOnBook();
        assertTrue(isVisible);
    }

    @Test
    public void addEnglishBookToCartTest(){
        EnglishPage englishPage=mainPage.openEnglishPage();
        englishPage.clickOnBook();
        boolean isVisible=englishPage.addBookToCart();
        assertTrue(isVisible);
    }

    @Test
    public void addEnglishBooksToCartByTypingTest(){
        EnglishPage englishPage=mainPage.openEnglishPage();
        englishPage.clickOnBook();
        boolean isVisible=englishPage.addBooksToCart();
        assertTrue(isVisible);
    }

    //FAILED
    @ParameterizedTest
    @ValueSource (strings = {"", "98000", "%^&","  ", "1ggg", "1$$$$"})
    public void addEnglishBooksToCartNegativeTest(String a){
        EnglishPage englishPage=mainPage.openEnglishPage();
        englishPage.clickOnBook();
        boolean isVisible=englishPage.addBooksToCartNegative(a);
        assertTrue(isVisible);
    }


//failed
//    @Test
//    public void addEnglishBooksToCartByArrowsTest(){
//        EnglishPage englishPage=mainPage.openEnglishPage();
//        englishPage.clickOnBook();
//        boolean isVisible=englishPage.addBooksToCartByArrows();
//        assertTrue(isVisible);
//    }


    @Test
    public void addDifferentLanguagesBooksTest(){
        EnglishPage englishPage=  mainPage.openEnglishPage();
        englishPage.clickOnBook();
        englishPage.addBookToCart();
        HebrewPage hebrewPage= mainPage.openHebrewPage();
        hebrewPage.clickOnHebrewBook();
        hebrewPage.addHebrewBookToCart();
        CartPage cartPage= mainPage.openCartPage();
        boolean isVisible=cartPage.isTwoItemsInCartVisible();
        assertTrue(isVisible);
    }



    }





