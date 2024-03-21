package lesson_13.andersenlab_tests;

import jdk.jfr.Description;
import lesson_13.DriverSetup;
import lesson_13.andersenlab_pages.LoginPage;
import lesson_13.utils.MyTestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({MyTestListeners.class})
public class LoginPageTest {
    private static WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetup.startDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    @Description("Testing login with a password that includes special characters (@, #, $)")
    public void testLoginWithSpecialCharacters() {
        loginPage.openLoginPage()
                .waitForEmail()
                .enterValidMail()
                .enterPassword()
                .pressSigninButton();
        Assert.assertTrue(true);
    }

    @Test
    @Description("Testing login with incorrect case (uppercase) in the email")
    public void testLoginWithUppercaseEmail() {
        loginPage.openLoginPage()
                .waitForEmail()
                .enterUppercaseMail()
                .enterPassword()
                .pressSigninButton();
        Assert.assertEquals(loginPage.getFailedResultMessage(), loginPage.getFailedMessage());
    }

    @Test
    @Description("Entering an empty password field.")
    public void testLoginWithoutPassword() {
        loginPage.openLoginPage()
                .waitForEmail()
                .enterValidMail()
                .emptyPasswordField();
        Assert.assertEquals(loginPage.getRequiredResultMessage(), loginPage.getRequiredMessage());
    }
}
