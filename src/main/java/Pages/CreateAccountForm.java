package Pages;

import static Pages.LoginPage.createAccountHeader;

public class CreateAccountForm extends BasePage{

    public static final String createAccountHeader="//*[text()='Create Account']";
    public static final String newAccountHeader="";

    public static boolean createAccountFormVisible(){
        return elementExists(createAccountHeader);
    }

    public static boolean createNewAccount(){
        return elementExists(newAccountHeader);
    }


}
