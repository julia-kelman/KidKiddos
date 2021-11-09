import Pages.*;
import Pages.CreateAccountForm;
import Utlis.UseCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class mainPageTest extends UseCaseBase {
    public static MainPage mainPage;

    @BeforeAll
    public static void classSetup(){
        mainPage=new MainPage();
    }

    @BeforeEach
    public void beforeTest(){
        mainPage.navigateToMainPage();
    }


    @Test
    public void mainPageLoadedTest(){
        Boolean success=MainPage.isLogoVisible();
        assertTrue(success);
    }

    @Test
    public void loginPageLoadTest(){
        LoginPage LoginPage=MainPage.openLoginPage();
        boolean isLoaded=LoginPage.isLoginHeaderVisible();
            assertTrue(isLoaded);
        }

    @Test
    public void createAccountFormVisible() throws InterruptedException {
        CreateAccountForm createAccountForm=mainPage.opencreateAcountForm();
        boolean isVisible=createAccountForm.createAccountFormVisible();
        assertTrue(isVisible);
    }

    @Test
    public void createNewAccountTest() throws InterruptedException {
        CreateAccountForm createAccountForm=mainPage.fillOutNewAccountForm();
        boolean isCreated=createAccountForm.createNewAccount();
        assertTrue(isCreated);
    }

    @Test
    public void loginToNewAccountTest() throws InterruptedException {
        LoginPage loginPage=mainPage.loginToNewAccount();
        boolean isVisible=loginPage.isIncorrectErrorVisible();
        assertTrue(isVisible);
    }

    //First name field test
    @ParameterizedTest
    @ValueSource(strings= {"Juli", "", "98", "%^&", "hhfjhjfjdnfsjbgjdbgfjbjk", "  ", "123ggg", "$$$$kkkkk" })
    public void firstNameInputTest(String a) throws InterruptedException {
        CreateAccountForm createAccountForm=mainPage.firstNameInputTest(a);
        boolean isCreated=createAccountForm.createNewAccount();
        assertTrue(isCreated);
    }

    @ParameterizedTest
    @ValueSource(strings= {"Juli", "", "98", "%^&", "hhfjhjfjdnfsjbgjdbgfjbjk", "  ", "123ggg", "$$$$kkkkk" })
    public void lastNameInputTest(String a) throws InterruptedException {
        CreateAccountForm createAccountForm=mainPage.lastNameInputTest(a);
        boolean isCreated=createAccountForm.createNewAccount();
        assertTrue(isCreated);
    }

    @ParameterizedTest
    @ValueSource(strings= {"jk@gmailcom", "jkgmail.com", ".jk@gmail.com", "jk@.com"})
    public void emailNameInputTest(String a) throws InterruptedException {
        CreateAccountForm createAccountForm=mainPage.emailInputTest(a);
        boolean isCreated=createAccountForm.createNewAccount();
        assertTrue(isCreated);
    }

    @ParameterizedTest
    @ValueSource(strings= {"Abc123", "Abc123$", "abcdefg", "123456","$$$$$$$$", "", "  "})
    public void passwordInputTest(String a) throws InterruptedException {
        CreateAccountForm createAccountForm=mainPage.passwordInputTest(a);
        boolean isCreated=createAccountForm.createNewAccount();
        assertTrue(isCreated);
    }

    @Test
    public void cartPageTest(){
        CartPage cartPage=MainPage.openCartPage();
        boolean isVisible=cartPage.isCartHeaderVisible();
        assertTrue(isVisible);
    }

    @Test
    public void countryTest() throws InterruptedException {
        CartPage cartPage=MainPage.chooseBRLcountry();
        boolean isVisible=cartPage.isBRLbookVisible();
        assertTrue(isVisible);
    }

    @Test
    public void autoCountryTest() throws InterruptedException {
        CartPage cartPage=MainPage.chooseAutoCurrency();
        String canada=cartPage.isCandaianFlagVisible();
        assertEquals(canada,cartPage);
        System.out.println(" ");
    }

    }

