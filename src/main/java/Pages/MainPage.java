package Pages;

import Consts.Consts;

public class  MainPage extends BasePage{

    private static final String logo = "//img[@itemprop='logo']";
    private static final String login="//a[@class='site-header__account']";
    private static final String createAccount="//a[@id='customer_register_link']";
    private static final String FirstNameField="//input[@name='customer[first_name]']";
    private static final String LastNameField="//input[@name='customer[last_name]']";
    private static final String EmailField="//input[@name='customer[email]']";
    private static final String PasswordField="//input[@name='customer[password]']";
    private static final String createButton="//input[@value='Create']";
    private static final String cartLogo="//a[@class='site-header__cart']";
    private static final String countryLogo="//div[@class='cbb-currency-flag']";
    //private static final String BRLflag="//li[@class='currency-converter-chooser-item cbb-currency-code-BRL']//descendant::span[text()='BRL']";
    //private static final String BRLflag="//span[text()='currency-converter-chooser-item cbb-currency-code-BRL']";
    private static final String BRLflag="//*[text()='BRL']";
    private static final String autoCurrency="//span[text()='Auto']";
    private static final String loginField="//input[@id='CustomerEmail']";
    private static final String passwordField="//input[@id='CustomerPassword']";
    private static final String signInButton="//input[@value='Sign In']";

    public void navigateToMainPage(){
        webDriver.get(Consts.mainURL);
    }

    public static boolean isLogoVisible() {
        Boolean isVisible=elementExists(logo);
        return isVisible;
    }

    public static LoginPage openLoginPage(){
        clickElementByXpath(login);
        return new LoginPage();
    }

    public static CreateAccountForm opencreateAcountForm() throws InterruptedException {
        clickElementByXpath(login);
        Thread.sleep(1000);
        clickElementByXpath(createAccount);
        return new CreateAccountForm();
    }

    public CreateAccountForm fillOutNewAccountForm() throws InterruptedException {
        clickElementByXpath(login);
        Thread.sleep(1000);
        clickElementByXpath(createAccount);
        findElementByXpath(FirstNameField).sendKeys("Julia");
        findElementByXpath(LastNameField).sendKeys("Kel");
        findElementByXpath(EmailField).sendKeys("jk@gmail.com");
        findElementByXpath(PasswordField).sendKeys("abc123");
        clickElementByXpath(createButton);
        //CAPTCHA NEEDED!
        return new CreateAccountForm();
    }

    public LoginPage loginToNewAccount() throws InterruptedException {
        clickElementByXpath(login);
        Thread.sleep(1000);
        findElementByXpath(loginField).sendKeys("jk@gmail.com");
        findElementByXpath(passwordField).sendKeys("abc123");
        clickElementByXpath(signInButton);
        return new LoginPage();
    }

    public CreateAccountForm firstNameInputTest(String a) throws InterruptedException {
        clickElementByXpath(login);
        Thread.sleep(1000);
        clickElementByXpath(createAccount);
        findElementByXpath(FirstNameField).sendKeys(a);
        findElementByXpath(LastNameField).sendKeys("Kel");
        findElementByXpath(EmailField).sendKeys("jk@gmail.com");
        findElementByXpath(PasswordField).sendKeys("Abc123");
        clickElementByXpath(createButton);
        //clickElementByXpath(captcha);
        return new CreateAccountForm();
    }

    public CreateAccountForm lastNameInputTest(String a) throws InterruptedException {
        clickElementByXpath(login);
        Thread.sleep(1000);
        clickElementByXpath(createAccount);
        findElementByXpath(FirstNameField).sendKeys("Jul");
        findElementByXpath(LastNameField).sendKeys(a);
        findElementByXpath(EmailField).sendKeys("jk@gmail.com");
        findElementByXpath(PasswordField).sendKeys("Abc123");
        clickElementByXpath(createButton);
        //clickElementByXpath(captcha);
        return new CreateAccountForm();
    }

    public CreateAccountForm emailInputTest(String a) throws InterruptedException {
        clickElementByXpath(login);
        Thread.sleep(1000);
        clickElementByXpath(createAccount);
        findElementByXpath(FirstNameField).sendKeys("Jul");
        findElementByXpath(LastNameField).sendKeys("Kel");
        findElementByXpath(EmailField).sendKeys(a);
        findElementByXpath(PasswordField).sendKeys("Abc123");
        clickElementByXpath(createButton);
        //clickElementByXpath(captcha);
        return new CreateAccountForm();
    }

    public CreateAccountForm passwordInputTest(String a) throws InterruptedException {
        clickElementByXpath(login);
        Thread.sleep(1000);
        clickElementByXpath(createAccount);
        findElementByXpath(FirstNameField).sendKeys("Jul");
        findElementByXpath(LastNameField).sendKeys("Kel");
        findElementByXpath(EmailField).sendKeys("jk@gmail.com");
        findElementByXpath(PasswordField).sendKeys(a);
        clickElementByXpath(createButton);
        //clickElementByXpath(captcha);
        return new CreateAccountForm();
    }

    public static CartPage openCartPage(){
        clickElementByXpath(cartLogo);
        return new CartPage();
    }

    public static CartPage chooseBRLcountry() throws InterruptedException {
        clickElementByXpath(countryLogo);
        Thread.sleep(1000);
        clickElementByXpath(BRLflag);
        return new CartPage();

    }

    public static CartPage chooseAutoCurrency() throws InterruptedException {
        clickElementByXpath(countryLogo);
        Thread.sleep(1000);
        clickElementByXpath(autoCurrency);
        return new CartPage();
    }




}
