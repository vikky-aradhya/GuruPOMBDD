package stepDefinition;

import PageOperations.LoginPageOperations;
import base.BasePage;
import cucumber.api.java.en.Given;
import org.testng.Assert;

public class LoginOutlineTest extends BasePage {

    public LoginPageOperations loginPageOperations = new LoginPageOperations();

    @Given("^user Enters the user name as \"([^\"]*)\" and password as \"([^\"]*)\" and clicks on login button$")
    public void user_Enters_the_user_name_as_and_password_as_and_clicks_on_login_button(String name, String password) throws Throwable {

        boolean isLoginInToApplication = loginPageOperations.LoginInToApplicationOutline(name, password);
        Assert.assertTrue(isLoginInToApplication);

    }
}
