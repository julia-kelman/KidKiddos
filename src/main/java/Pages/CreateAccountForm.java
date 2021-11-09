package Pages;

import static Pages.LoginPage.createAccountHeader;

public class CreateAccountForm extends BasePage{

    private static final String FirstNameField="//input[@name='customer[first_name]']";
    private static final String LastNameField="//input[@name='customer[last_name]']";
    private static final String EmailField="//input[@name='customer[email]']";
    private static final String PasswordField="//input[@name='customer[password]']";
    private static final String createButton="//input[@value='Create']";
    public static final String createAccountHeader="//*[text()='Create Account']";
    public static final String createdAccountHeader="";

    public boolean createAccountFormVisible(){
        return elementExists(createAccountHeader);
    }

    public void inputName(String name){
        findElementByXpath(FirstNameField).sendKeys(name);
    }

    public void inputLastName(String lastName){
        findElementByXpath(LastNameField).sendKeys(lastName);
    }

    public void inputEmailField(String email){
        findElementByXpath(EmailField).sendKeys(email);
    }

    public void inputPasswordField(String password){
        findElementByXpath(PasswordField).sendKeys(password);
    }

    public void clickCreateButton(){
        clickElementByXpath(createButton);
    }

    public boolean newAccountPageHeaderVisible(){
        return elementExists(createdAccountHeader);
    }




//    public static CreateAccountForm opencreateAcountForm() {
//        clickElementByXpath(loginIcon);
//        clickElementByXpath(createAccount);
//        return new CreateAccountForm();
//    }
//
//
//
//    public CreateAccountForm fillOutNewAccountForm()  {
//        clickElementByXpath(loginIcon);
//
//        clickElementByXpath(createAccount);
//        findElementByXpath(FirstNameField).sendKeys("Julia");
//        findElementByXpath(LastNameField).sendKeys("Kel");
//        findElementByXpath(EmailField).sendKeys("jk@gmail.com");
//        findElementByXpath(PasswordField).sendKeys("abc123");
//        clickElementByXpath(createButton);
//        //CAPTCHA NEEDED!
//        return new CreateAccountForm();
//    }
//
//
//
//    public CreateAccountForm firstNameInputTest(String a)  {
//        clickElementByXpath(loginIcon);
//
//        clickElementByXpath(createAccount);
//        findElementByXpath(FirstNameField).sendKeys(a);
//        findElementByXpath(LastNameField).sendKeys("Kel");
//        findElementByXpath(EmailField).sendKeys("jk@gmail.com");
//        findElementByXpath(PasswordField).sendKeys("Abc123");
//        clickElementByXpath(createButton);
//        //clickElementByXpath(captcha);
//        return new CreateAccountForm();
//    }
//
//    public CreateAccountForm lastNameInputTest(String a)  {
//        clickElementByXpath(loginIcon);
//
//        clickElementByXpath(createAccount);
//        findElementByXpath(FirstNameField).sendKeys("Jul");
//        findElementByXpath(LastNameField).sendKeys(a);
//        findElementByXpath(EmailField).sendKeys("jk@gmail.com");
//        findElementByXpath(PasswordField).sendKeys("Abc123");
//        clickElementByXpath(createButton);
//        //clickElementByXpath(captcha);
//        return new CreateAccountForm();
//    }
//
//    public CreateAccountForm emailInputTest(String a)  {
//        clickElementByXpath(loginIcon);
//
//        clickElementByXpath(createAccount);
//        findElementByXpath(FirstNameField).sendKeys("Jul");
//        findElementByXpath(LastNameField).sendKeys("Kel");
//        findElementByXpath(EmailField).sendKeys(a);
//        findElementByXpath(PasswordField).sendKeys("Abc123");
//        clickElementByXpath(createButton);
//        //clickElementByXpath(captcha);
//        return new CreateAccountForm();
//    }
//
//    public CreateAccountForm passwordInputTest(String a){
//        clickElementByXpath(loginIcon);
//
//        clickElementByXpath(createAccount);
//        findElementByXpath(FirstNameField).sendKeys("Jul");
//        findElementByXpath(LastNameField).sendKeys("Kel");
//        findElementByXpath(EmailField).sendKeys("jk@gmail.com");
//        findElementByXpath(PasswordField).sendKeys(a);
//        clickElementByXpath(createButton);
//        //clickElementByXpath(captcha);
//        return new CreateAccountForm();
//    }
//
//    public  boolean createNewAccount(){
//        return elementExists(createdAccountHeader);
//    }



}
