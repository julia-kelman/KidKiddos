package Pages;

public class LoginPage extends BasePage{

    public static final String LoginPageHeader="//h1[@class='text-center']";
    private static final String emailField="//input[@id='CustomerEmail']";
    private static final String passwordField="//input[@id='CustomerPassword']";
    private static final String createAccountButton="//a[@id='customer_register_link']";
    private static final String forgotPasswordButton="";
    private static final String signInButton="//input[@value='Sign In']";
    public static final String createAccountHeader="//*[text()='Create Account']";
    public static final String incorrectError="//li[text()='Incorrect email or password.']";
    public static final String userLoggedInHeader="";

    public boolean isLoginHeaderVisible(){
        return elementExists(LoginPageHeader);
    }

    public void emailFieldInput(String email){
        findElementByXpath(emailField).sendKeys(email);
    }

    public void passwordInputField(String password){
        findElementByXpath(passwordField).sendKeys(password);
    }

    public void forgotPasswordButton(){
        clickElementByXpath(forgotPasswordButton);
    }

    public void signInButton(){
        clickElementByXpath(signInButton);
    }

    public void createAccountButton(){
        clickElementByXpath(createAccountButton);
    }

    public boolean isIncorrectErrorVisible(){
        return elementExists(incorrectError);
    }

}
