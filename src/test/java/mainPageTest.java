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
    public static LoginPage loginPage;
    public static CartPage cartPage;
    public static CreateAccountForm createAccountForm;

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
        LoginPage loginPage=mainPage.openLoginPage();
        boolean isLoaded=loginPage.isLoginHeaderVisible();
            assertTrue(isLoaded);
        }

    @Test
    public void userLoginTest() {
        loginPage.emailFieldInput("jk@gmail.com");
        loginPage.passwordInputField("Abc123");
        loginPage.createAccountButton();
        boolean isVisible=loginPage.isLoginHeaderVisible();
        assertTrue(isVisible);
    }

    @Test
    public void createNewAccountTest() {
        mainPage.inputName("kgjkf");
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
        CartPage cartPage=mainPage.openCartPage();
        boolean isVisible=cartPage.isCartHeaderVisible();
        assertTrue(isVisible);
    }

    @Test
    public void countryTest() throws InterruptedException {
        CartPage cartPage=mainPage.chooseBRLcountry();
        boolean isVisible=cartPage.isBRLbookVisible();
        assertTrue(isVisible);
    }

    @Test
    public void autoCountryTest() throws InterruptedException {
        CartPage cartPage=mainPage.chooseAutoCurrency();
        String canada=cartPage.isCandaianFlagVisible();
        assertEquals(canada,cartPage);
        System.out.println(" ");
    }

    }

