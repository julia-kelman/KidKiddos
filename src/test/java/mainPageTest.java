import Pages.*;
import Pages.CreateAccountForm;
import Utlis.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    public void createNewAccountTest() {
        mainPage.openLoginPage();
        loginPage.createAccountButton();
       createAccountForm.inputName("Julia");
       createAccountForm.inputLastName("Kelman");
       createAccountForm.inputEmailField("jk@gmail.com");
       createAccountForm.inputPasswordField("Abc123");
       createAccountForm.clickCreateButton();
        boolean isVisible=createAccountForm.newAccountPageHeaderVisible();
        assertTrue(isVisible);
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
    public void incorrectLoginTest() {
        //incorrect email:
        loginPage.emailFieldInput("jk@gamil.ca");
        loginPage.passwordInputField("Abc123");
        loginPage.createAccountButton();
        boolean isVisible=loginPage.isIncorrectErrorVisible();
        assertTrue(isVisible);
    }


    //First name field negative tests:
    @ParameterizedTest
    @ValueSource(strings= {"", "98", "%^&", "  ", "123ggg", "$$$$kkkkk", "hhfjhjfjdnfsjbgjdbgfjbjkkfnkdsfkkfmlksfdmlksfnkflnklfngkfnkdsfnkfdnklsd" })
    public void firstNameInputTest(String a) {
        createAccountForm.inputName(a);
        createAccountForm.inputLastName("Kelman");
        createAccountForm.inputEmailField("jk@gmail.com");
        createAccountForm.inputPasswordField("Abc123");
        createAccountForm.clickCreateButton();
        boolean isVisible=createAccountForm.errorLoginVisible();
        assertTrue(isVisible);
//test failed! possible to create account without first name field input
    }


    //Last name negative tests
    @ParameterizedTest
    @ValueSource(strings= {"", "98", "%^&", "  ", "123ggg", "$$$$kkkkk", "hhfjhjfjdnfsjbgjdbgfjbjkkfnkdsfkkfmlksfdmlksfnkflnklfngkfnkdsfnkfdnklsd" })
    public void lastNameInputTest(String a) {
        createAccountForm.inputName("Jul");
        createAccountForm.inputLastName(a);
        createAccountForm.inputEmailField("jk@gmail.com");
        createAccountForm.inputPasswordField("Abc123");
        createAccountForm.clickCreateButton();
        boolean isVisible=createAccountForm.emptyEmailError();
        assertTrue(isVisible);

    }

    //Email negative tests
    @ParameterizedTest
    @ValueSource(strings= {"jk@gmailcom", "jkgmail.com", ".jk@gmail.com", "jk@.com"})
    public void emailNameInputTest(String a){
        createAccountForm.inputName("Jul");
        createAccountForm.inputLastName("Kel");
        createAccountForm.inputEmailField(a);
        createAccountForm.inputPasswordField("Abc123");
        createAccountForm.clickCreateButton();
        boolean isVisible=createAccountForm.emptyEmailError();
        assertTrue(isVisible);
    }

    @Test
    public void sameEmailRegister(){
        boolean isVisible=createAccountForm.sameEmailRegistr();
        assertTrue(isVisible);
    }

    @Test
    public void forgotPasswordTest() {
        mainPage.openLoginPage();
        boolean isVisible=loginPage.forgotPasswordButton();
       assertTrue(isVisible);
    }

        //Password negative tests
    @ParameterizedTest
    @ValueSource(strings= {"Abc123", "Abc123$", "abcdefg", "123456","$$$$$$$$", "", "  "})
    public void passwordInputTest(String a) {
        createAccountForm.inputName("Jul");
        createAccountForm.inputLastName("Kel");
        createAccountForm.inputEmailField("jk@gmail.com");
        createAccountForm.inputPasswordField(a);
        createAccountForm.clickCreateButton();
        boolean isVisible=createAccountForm.emptyPasswordError();
        assertTrue(isVisible);
    }

    @Test
    public void flagsMenuTest(){
        boolean isVisible=mainPage.openCurrencyMenu();
        assertTrue(isVisible);
    }

    @Test
    public void cartPageTest(){
        mainPage.openCartPage();
        boolean isVisible=cartPage.isCartHeaderVisible();
        assertTrue(isVisible);
    }

    @Test
    public void countryTest() {
        boolean isVisible=cartPage.isBRLbookVisible();
        assertTrue(isVisible);
    }

    @Test
    public void autoCountryTest() {
        CartPage cartPage=mainPage.chooseAutoCurrency();
        String canada=cartPage.isCandaianFlagVisible();
        assertEquals(canada,cartPage);
        System.out.println(" ");
    }

    }

