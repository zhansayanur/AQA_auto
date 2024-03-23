package lesson_13.andersenlab_tests;

import jdk.jfr.Description;
import lesson_13.DriverSetup;
import lesson_13.andersenlab_pages.EditAccountPage;
import lesson_13.andersenlab_pages.LoginPage;
import lesson_13.andersenlab_pages.MyAccountPage;
import lesson_13.utils.MyTestListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({MyTestListeners.class})
public class EditAccountPageTest {
    private static WebDriver driver;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private EditAccountPage editAccountPage;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = DriverSetup.startDriver();
        editAccountPage = new EditAccountPage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    @Description("Check if the user can edit the non-editable fields.")
    public void testNonEditableFields() {
        loginPage.openLoginPage()
                .enterValidMail()
                .enterPassword()
                .pressSigninButton();
        myAccountPage.clickEditButton();
        editAccountPage.editMailField();
        Assert.assertFalse(editAccountPage.isEmailFieldEditable());
    }

    @Test
    @Description("Check if user can change their first name and last name with special characters (@, #, $).")
    public void testFirstAndLastNameWithSpecialCharacters() {
        loginPage.openLoginPage()
                .enterValidMail()
                .enterPassword()
                .pressSigninButton();
        myAccountPage.clickEditButton();
        editAccountPage.enterFirstName()
                .enterLastName()
                .clickSubmitButton();
        Assert.assertEquals(myAccountPage.getEditedFirstNameValue(), editAccountPage.getNewFirstNameFieldValue());
    }

    @Test
    @Description("Check the alert message for all the mandatory fields, when the user leaves the field blank.")
    public void testCheckAlertMessage() {
        loginPage.openLoginPage()
                .enterValidMail()
                .enterPassword()
                .pressSigninButton();
        myAccountPage.clickEditButton();
        editAccountPage.clearFirstName()
                .clearLastName();
        Assert.assertEquals(editAccountPage.getRequiredResultMessage(), editAccountPage.getRequiredMessage());
    }
}
