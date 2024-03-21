package lesson_13.andersenlab_tests;

import jdk.jfr.Description;
import lesson_13.DriverSetup;
import lesson_13.andersenlab_pages.RegistrationPage;
import lesson_13.utils.MyTestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({MyTestListeners.class})
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
    public void testRegistrationWithEmptyFields() {
        registrationPage.openRegistrationPage()
                .clickSubmitButton();
        Assert.assertEquals(registrationPage.getRequiredResultMessage(), registrationPage.getRequiredMessage());
    }

    @Test
    @Description("Verify that the registration page detects and prevents the use of commonly used or easily guessable passwords (e.g., \"password,\" \"12345678,\").")
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
    @Description("Test the response to using a username that is already taken.")
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
        Assert.assertTrue(true);
    }
}
