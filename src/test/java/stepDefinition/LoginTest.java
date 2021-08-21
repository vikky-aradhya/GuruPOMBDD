package stepDefinition;

import org.testng.Assert;

import PageOperations.LoginPageOperations;
import base.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginTest extends BasePage {

    public LoginPageOperations loginPageOperations = new LoginPageOperations();

    @Given("^Login page is loaded$")
    public void login_page_is_loaded() {

        boolean isVerifyLoginPageTitle = loginPageOperations.verifyLoginPageTitle();
        Assert.assertTrue(isVerifyLoginPageTitle);
    }

    @And("^user Enters the user name and password and clicks on login button$")
    public void user_Enters_the_user_name_and_password() {
        boolean isLoginInToApplication = loginPageOperations.LoginInToApplication();
        Assert.assertTrue(isLoginInToApplication);
    }

    @Then("^user validates HomePage$")
    public void user_validates_HomePage() {
        boolean isHomePageValidation = loginPageOperations.HomePageValidation();
        Assert.assertTrue(isHomePageValidation);
    }

}
