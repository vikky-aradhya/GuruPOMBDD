package PageOperations;

import com.aventstack.extentreports.Status;
import org.testng.Assert;

import pagesLocators.NewCustomerPageLocators;
import utils.ExtentReportGeneration;

public class NewCustomerPageOperations extends NewCustomerPageLocators {

    @SuppressWarnings("finally")
    public boolean clickOnRegisterPage() {

        boolean success = false;
        try {
            ClickOnElement(geNewCustomerLink());
            String expectedTitle = "Guru99 Bank New Customer Entry Page";
            Assert.assertEquals(getDriver().getTitle(), expectedTitle);
            success = true;
            ExtentReportGeneration.extentTest.log(Status.PASS, "Title matched ");

        } catch (AssertionError error) {
            ExtentReportGeneration.extentTest.log(Status.ERROR, error.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            ExtentReportGeneration.extentTest.log(Status.FAIL, "Title don't matched ");

        } finally {
            return success;
        }
    }

    @SuppressWarnings("finally")
    public boolean CreateNewCustomer(String DOB, String Address, String City, String State, String Pin, String password) {

        boolean success = false;

        try {
            EnterText(geCustometNameTextBox(), randomestring());
            ClickOnElement(geGenderradioButton());
            EnterText(geDOBTextBox(), DOB);
            EnterText(geAddressTextBox(), Address);
            EnterText(geCityTextBox(), City);
            EnterText(geStateTextBox(), State);
            EnterText(gePINTextBox(), Pin);

            EnterText(gePhoneNumberTextBox(), randomeNum());
            EnterText(geEmailIDTextBox(), generateRandomEmail(6));
            EnterText(gepasswordTextBox(), password);

            ExtentReportGeneration.extentTest.log(Status.PASS, "user Entered information sucessfully");
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            ExtentReportGeneration.extentTest.log(Status.FAIL, "Failed to enter required information" + e.getMessage());
        } finally {
            return success;
        }
    }

    @SuppressWarnings("finally")
    public boolean CreateNewCustomerSubmit() {

        boolean success = false;

        try {
            ClickOnElement(geSubmitButton());

            ExtentReportGeneration.extentTest.log(Status.PASS, "user clicked submit button sucessfully");
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            ExtentReportGeneration.extentTest.log(Status.FAIL, "Failed to click submit button" + e.getMessage());
        } finally {
            return success;
        }
    }

    @SuppressWarnings("finally")
    public boolean verifyRegisterMessage() {

        boolean success = false;

        try {
            verifyElementIsDisplayed(geRegisteredMessage());

            ExtentReportGeneration.extentTest.log(Status.PASS, "user Registered sucessfully");
            success = true;
            getScreenshot("Register");
        } catch (Exception e) {
            e.printStackTrace();
            ExtentReportGeneration.extentTest.log(Status.FAIL, "Failed to Registered" + e.getMessage());
        } finally {
            return success;
        }
    }

}
