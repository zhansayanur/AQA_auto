package lesson_13.websites_test;

import lesson_13.DriverSetup;
import lesson_13.utils.MyTestListeners;
import lesson_13.websites_pages.GoogleSearchPage;
import lesson_13.websites_pages.GuinnessWorldRecordsPage;
import lesson_13.websites_pages.HyrTutorialsPage;
import lesson_13.websites_pages.W3SchoolsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({MyTestListeners.class})
public class WebsitesTest {
    private static WebDriver driver;
    private GoogleSearchPage googleSearchPage;
    private W3SchoolsPage w3SchoolsPage;
    private GuinnessWorldRecordsPage guinnessWorldRecordsPage;
    private HyrTutorialsPage hyrTutorialsPage;

    @BeforeClass
    public void setUp() {
        driver = DriverSetup.startDriver();
        googleSearchPage = new GoogleSearchPage(driver);
        w3SchoolsPage = new W3SchoolsPage(driver);
        guinnessWorldRecordsPage = new GuinnessWorldRecordsPage(driver);
        hyrTutorialsPage = new HyrTutorialsPage(driver);
    }

    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    public void testLinks() {
        googleSearchPage.openGooglePage()
                .openGuinnessWorldRecordsPage()
                .openHyrTutorialsPage()
                .openW3SchoolsPage();
        w3SchoolsPage.waitForIframeResult()
                .changeFirstName()
                .changeLastName()
                .clickSubmitButton();
        w3SchoolsPage.printNoteMessage();
        guinnessWorldRecordsPage.switchToSubChildWindow();
        guinnessWorldRecordsPage.enterLastName()
                .enterFirstName()
                .enterDateOfBirthDay()
                .enterDateOfBirthMonth()
                .enterDateOfBirthYear()
                .selectCountry()
                .enterStateInput()
                .enterEmailAddress()
                .enterConfirmEmailAddress()
                .enterPasswordInput()
                .enterConfirmPassword()
                .printMessageConfirmPassword();
        hyrTutorialsPage.switchToChildWindow();
        hyrTutorialsPage.clickAlertBoxButton();
        hyrTutorialsPage.alertBoxAccept()
                .getMessageAlertBoxAccept();
        hyrTutorialsPage.clickConfirmBoxButton();
        hyrTutorialsPage.confirmBoxDismiss()
                .getMessageConfirmBoxDismiss();
        hyrTutorialsPage.clickPromptBoxButton();
        hyrTutorialsPage.promptBoxEnter()
                .getMessagePromptBoxEnter();
        Assert.assertTrue(true);
    }
}
