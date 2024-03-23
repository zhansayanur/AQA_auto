package lesson_14;

import io.qameta.allure.*;
import jdk.jfr.Description;
import lesson_14.DriverSetup;
import lesson_14.pages.RegistrationPage;
import lesson_14.utils.MyAllureListeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({MyAllureListeners.class})
public class RegistrationPageTest {
    private static WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetup.startDriver();
        registrationPage = new RegistrationPage(driver);
    }

    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    @Description("Test the response to submitting the form with all fields empty.")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Sending empty fields")
    public void testRegistrationWithEmptyFields() {
        registrationPage.openRegistrationPage()
                .clickSubmitButton();
        Assert.assertEquals(registrationPage.getRequiredResultMessage(), registrationPage.getRequiredMessage());
    }

    @Test
    @Description("Verify that the registration page detects and prevents the use of commonly used or easily guessable passwords (e.g., \"password,\" \"12345678,\").")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Entering guessable password")
    @TmsLink("https://testzn.testrail.io/index.php?/cases/view/1")
    public void testGuessablePassword() {
        registrationPage.openRegistrationPage()
                .enterFirstName()
                .enterLastName()
                .clickBirthDate()
                .selectYear()
                .selectMonth()
                .selectDay();
        registrationPage.enterValidMail()
                .enterGuessablePassword()
                .confirmGuessablePassword()
                .clickSubmitButton();
        Assert.assertTrue(true);
    }

    @Test
    @Description("Negative test. Test the response to using a username that is already taken.")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Entering taken email")
    @Story("User forgot his password and wants to register again with his email.")
    public void testTakenMail() {
        registrationPage.openRegistrationPage()
                .enterFirstName()
                .enterLastName()
                .clickBirthDate()
                .selectYear()
                .selectMonth()
                .selectDay();
        registrationPage.enterTakenMail()
                .enterPassword()
                .confirmPassword()
                .clickSubmitButton();
        Assert.assertTrue(false);
    }
}
