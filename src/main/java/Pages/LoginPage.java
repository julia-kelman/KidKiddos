package Pages;

public class LoginPage extends BasePage{

    public static final String LoginPageHeader="//h1[@class='text-center']";
    public static final String createAccountHeader="//*[text()='Create Account']";
    public static final String incorrectError="//li[text()='Incorrect email or password.']";

    public static boolean isLoginHeaderVisible(){
        return elementExists(LoginPageHeader);
    }

    public static boolean isIncorrectErrorVisible(){
        return elementExists(incorrectError);
    }



}
