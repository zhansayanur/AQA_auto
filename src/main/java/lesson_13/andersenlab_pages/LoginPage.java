package lesson_13.andersenlab_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private static class Strings {
        private static final String correctMail = "snzhansaya@gmail.com";
        private static final String uppercaseMail = "SNZHANSAYA@GMAIL.COM";
        private static final String passwordWithSpecialCharacters = "123456@#$";
        private static final String emailPasswordErrorMessage = "Email or password is not valid";
        private static final String passwordRequiredMessage = "Required";
    }

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class = 'flex flex-col gap-6']//div[1]//div[@class='text-right relative']//span[@class='absolute right-0 text-rose-500 text-sm']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class = 'flex flex-col gap-6']//div[2]//div[@class='text-right relative']//span[@class='absolute right-0 text-rose-500 text-sm']")
    private WebElement requiredErrorMessage;

    public LoginPage openLoginPage() {
        driver.get("https://qa-course-01.andersenlab.com/login");
        return this;
    }

    public LoginPage waitForEmail() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        return this;
    }

    public LoginPage enterValidMail() {
        emailField.sendKeys(Strings.correctMail);
        return this;
    }

    public LoginPage enterUppercaseMail() {
        emailField.sendKeys(Strings.uppercaseMail);
        return this;
    }

    public LoginPage enterPassword() {
        passwordField.sendKeys(Strings.passwordWithSpecialCharacters);
        return this;
    }

    public void emptyPasswordField() {
        passwordField.sendKeys(Keys.TAB);
    }

    public void pressSigninButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public String getFailedResultMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public String getFailedMessage() {
        return Strings.emailPasswordErrorMessage;
    }

    public String getRequiredResultMessage() {
        wait.until(ExpectedConditions.visibilityOf(requiredErrorMessage));
        return requiredErrorMessage.getText();
    }

    public String getRequiredMessage() {
        return Strings.passwordRequiredMessage;
    }

}