package Pages;

import static Pages.LoginPage.createAccountHeader;

public class CreateAccountForm extends BasePage {

    private static final String FirstNameField = "//input[@name='customer[first_name]']";
    private static final String LastNameField = "//input[@name='customer[last_name]']";
    private static final String EmailField = "//input[@name='customer[email]']";
    private static final String PasswordField = "//input[@name='customer[password]']";
    private static final String createButton = "//input[@value='Create']";
    public static final String createAccountHeader = "//*[text()='Create Account']";
    public static final String createdAccountHeader = "";
    public static final String errorLogin="";
    public static final String sameEmailRegistrationError="//a[text()='reset your password']";
    public static final String blankPasswordError="//li[text()='Password can't be blank.']";

    public boolean createAccountFormVisible() {
        return elementExists(createAccountHeader);
    }

    public void inputName(String name) {
        findElementByXpath(FirstNameField).sendKeys(name);
    }

    public void inputLastName(String lastName) {
        findElementByXpath(LastNameField).sendKeys(lastName);
    }

    public void inputEmailField(String email) {
        findElementByXpath(EmailField).sendKeys(email);
    }

    public void inputPasswordField(String password) {

        findElementByXpath(PasswordField).sendKeys(password);
    }

    public void clickCreateButton() {
        clickElementByXpath(createButton);
    }

    public boolean newAccountPageHeaderVisible() {
        return elementExists(createdAccountHeader);
    }

    public boolean sameEmailRegistr(){
        return elementExists(sameEmailRegistrationError);
    }

    public boolean emptyPasswordError(){
        return elementExists(blankPasswordError);
    }

    public boolean emptyEmailError(){
        return elementExists("Email can't be blank.");
    }

    public boolean errorLoginVisible(){
        return elementExists(errorLogin);
        //no error appeared when
    }
}