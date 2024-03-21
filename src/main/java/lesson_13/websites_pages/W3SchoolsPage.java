package lesson_13.websites_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class W3SchoolsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public W3SchoolsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "fname")
    private WebElement firstNameFieldLocator;

    @FindBy(id = "lname")
    private WebElement lastNameFieldLocator;

    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement submitButtonLocator;

    @FindBy(xpath = "//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']//p")
    private WebElement messageNoteLocator;

    public W3SchoolsPage waitForIframeResult() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
        return this;
    }

    public W3SchoolsPage changeFirstName() {
        firstNameFieldLocator.clear();
        firstNameFieldLocator.sendKeys("Zhansaya");
        return this;
    }

    public W3SchoolsPage changeLastName() {
        lastNameFieldLocator.clear();
        lastNameFieldLocator.sendKeys("Nur");
        return this;
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButtonLocator.click();
    }

    public W3SchoolsPage printNoteMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']//p")));
        WebElement messageNote = messageNoteLocator;
        System.out.println(messageNote.getText());
        return this;
    }
}