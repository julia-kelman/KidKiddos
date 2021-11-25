import Pages.*;
import Pages.CreateAccountForm;
import Utlis.UseCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class mainPageTest extends UseCaseBase {
    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static CartPage cartPage;
    public static CreateAccountForm createAccountForm;

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToMainPage();
    }

    @Test
    public void captureElement() throws IOException {
        mainPage.logoCapture();
    }


    @Test
    public void mainPageLoadedTest() {
        boolean success = mainPage.isLogoVisible();
        assertTrue(success);
    }


    @Test
    public void loginPageLoadTest() {
        LoginPage loginPage = mainPage.navigateToLoginPage();
        boolean isLoaded = loginPage.isLoginHeaderVisible();
        assertTrue(isLoaded);
    }


    @Test
    public void userLoginTest() {
        LoginPage loginPage = mainPage.navigateToLoginPage();
        loginPage.emailFieldInput("jk@gmail.com");
        loginPage.passwordInputField("Abc123");
        loginPage.clickSignIn();
        boolean isVisible = loginPage.isLoginHeaderVisible();
        assertTrue(isVisible);
    }


    @Test
    public void incorrectLoginTest() {
        //incorrect email:
        LoginPage loginPage = mainPage.navigateToLoginPage();
        loginPage.emailFieldInput("jk@.gamil.ca");
        loginPage.passwordInputField("Abc123");
        loginPage.clickSignIn();
        boolean isVisible = loginPage.isIncorrectErrorVisible();
        assertTrue(isVisible);
    }


    @Test
    public void createNewAccountTest() {
        LoginPage loginPage = mainPage.navigateToLoginPage();
        CreateAccountForm createAccountForm = loginPage.navigateToCreateAccountPage();
        createAccountForm.inputName("Julia");
        createAccountForm.inputLastName("Kelman");
        createAccountForm.inputEmailField("jk@gmail.com");
        createAccountForm.inputPasswordField("Abc123");
        createAccountForm.clickCreateButton();
        boolean isVisible = createAccountForm.newAccountPageHeaderVisible();
        assertTrue(isVisible);
    }


    //First name field negative tests:
    @ParameterizedTest
    @ValueSource(strings = {"", "98", "%^&", "  ", "123ggg", "$$$$kkkkk", "hhfjhjfjdnfsjbgjdbgfjbjkkfnkdsfkkfmlksfdmlksfnkflnklfngkfnkdsfnkfdnklsd"})
    public void firstNameInputTest(String a) {
        LoginPage loginPage = mainPage.navigateToLoginPage();
        CreateAccountForm createAccountForm = loginPage.navigateToCreateAccountPage();
        createAccountForm.inputName(a);
        createAccountForm.inputLastName("Kelman");
        createAccountForm.inputEmailField("jk@gmail.com");
        createAccountForm.inputPasswordField("Abc123");
        createAccountForm.clickCreateButton();
        boolean isVisible = createAccountForm.errorLoginVisible();
        assertTrue(isVisible);
//test failed! possible to create account without first name field input
    }


    //Last name negative tests
    @ParameterizedTest
    @ValueSource(strings = {"", "98", "%^&", "  ", "123ggg", "$$$$kkkkk", "hhfjhjfjdnfsjbgjdbgfjbjkkfnkdsfkkfmlksfdmlksfnkflnklfngkfnkdsfnkfdnklsd"})
    public void lastNameInputTest(String a) {
        LoginPage loginPage = mainPage.navigateToLoginPage();
        CreateAccountForm createAccountForm = loginPage.navigateToCreateAccountPage();
        createAccountForm.inputName("Jul");
        createAccountForm.inputLastName(a);
        createAccountForm.inputEmailField("jk@gmail.com");
        createAccountForm.inputPasswordField("Abc123");
        createAccountForm.clickCreateButton();
        boolean isVisible = createAccountForm.emptyEmailError();
        assertTrue(isVisible);
    }


    //Email negative tests
    @ParameterizedTest
    @ValueSource(strings = {"jk@gmailcom", "jkgmail.com", ".jk@gmail.com", "jk@.com"})
    public void emailNameInputTest(String a) {
        LoginPage loginPage = mainPage.navigateToLoginPage();
        CreateAccountForm createAccountForm = loginPage.navigateToCreateAccountPage();
        createAccountForm.inputName("Jul");
        createAccountForm.inputLastName("Kel");
        createAccountForm.inputEmailField(a);
        createAccountForm.inputPasswordField("Abc123");
        createAccountForm.clickCreateButton();
        boolean isVisible = createAccountForm.emptyEmailError();
        assertTrue(isVisible);
        //accepts .jk@gmail.com, although it starts with "."
    }


    @Test
    public void sameEmailRegister() {
        LoginPage loginPage = mainPage.navigateToLoginPage();
        CreateAccountForm createAccountForm = loginPage.navigateToCreateAccountPage();
        createAccountForm.inputName("Jul");
        createAccountForm.inputLastName("Kel");
        createAccountForm.inputEmailField("jk@gmail.com");
        createAccountForm.inputPasswordField("Abc123");
        createAccountForm.clickCreateButton();
        boolean isVisible = createAccountForm.sameEmailRegistr();
        assertTrue(isVisible);
    }


    @Test
    public void forgotPasswordTest() {
        LoginPage loginPage = mainPage.navigateToLoginPage();
        boolean isVisible = loginPage.forgotPasswordButton();
        assertTrue(isVisible);
    }


    //Password negative tests
    @ParameterizedTest
    @ValueSource(strings = {"Abc123", "Abc123$", "abcdefg", "123456", "$$$$$$$$", "", "  "})
    public void passwordInputTest(String a) {
        LoginPage loginPage = mainPage.navigateToLoginPage();
        CreateAccountForm createAccountForm = loginPage.navigateToCreateAccountPage();
        createAccountForm.inputName("Jul");
        createAccountForm.inputLastName("Kel");
        createAccountForm.inputEmailField("jk@gmail.com");
        createAccountForm.inputPasswordField(a);
        createAccountForm.clickCreateButton();
        boolean isVisible = createAccountForm.emptyPasswordError();
        assertTrue(isVisible);
    }


    @Test
    public void cartPageTest() {
        CartPage cartPage = mainPage.openCartPage();
        boolean isVisible = cartPage.isCartHeaderVisible();
        assertTrue(isVisible);
    }


    @Test
    public void flagsMenuTest() {
        boolean isVisible = mainPage.openCurrencyMenu();
        assertTrue(isVisible);
    }


    @Test
    public void brlCurrencyTest() throws IOException {
        mainPage.chooseBRLcountry();
    }


    @Test
    public void autoCurrencyTest() throws IOException {
        mainPage.chooseAutoCurrency();
    }


    @Test
    public void countryTest() {
        boolean isVisible = cartPage.isBRLbookVisible();
        assertTrue(isVisible);
    }


    //LOGS TESTS:

    @Test
    public void logsTestMainPage(){
        Assertions.assertNotEquals(Level.SEVERE, mainPage.logsMainPage());
    }


    @Test
    public void logsTestCartPage() {
        CartPage cartPage = mainPage.openCartPage();
        Assertions.assertNotEquals(Level.SEVERE, cartPage.logs());
    }


    @Test
    public void logsTestLoginPage() {
        LoginPage loginPage = mainPage.navigateToLoginPage();
        Assertions.assertNotEquals(Level.SEVERE, loginPage.logsLoginPage());
    }


    @Test
    public void logsTestCreateAccountPage() {
        LoginPage loginPage=mainPage.navigateToLoginPage();
        CreateAccountForm createAccountForm=loginPage.navigateToCreateAccountPage();
        Assertions.assertNotEquals(Level.SEVERE, createAccountForm.logsCreateAccountPage());
    }

    //LOGO DIMENSION TEST

    @Test
    public void logoDimensionTest(){
        mainPage.getLogoSize();

    }

}

