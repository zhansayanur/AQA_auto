package lesson_13.andersenlab_pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class EditAccountPage {
    private static class Strings {
        private static final String newEmail = "zhansayanur19999@gmail.com";
        private static final String newFirstName = "1@#$";
        private static final String newLastName = "@#$2";
        private static final String requiredMessage = "Required";
    }
    private WebDriver driver;
    private WebDriverWait wait;

    public EditAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(xpath = "//div[@class='flex flex-col gap-4']//div[1]//div[@class='text-right relative']//span[@class='absolute right-0 text-rose-500 text-sm']")
    private WebElement requiredErrorMessage;

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    public EditAccountPage editMailField() {
        if (!emailField.isEnabled() || !emailField.isDisplayed()) {
            System.out.println("Email field is disabled or non-clickable.");
        } else {
            Actions actions = new Actions(driver);
            actions.moveToElement(emailField).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            emailField.sendKeys(Strings.newEmail);
        }
        return this;
    }

    public boolean isEmailFieldEditable() {
        return emailField.isEnabled() && emailField.isDisplayed();
    }

    public EditAccountPage enterFirstName() {
        Actions actions = new Actions(driver);
        actions.moveToElement(firstNameInput).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        firstNameInput.sendKeys(Strings.newFirstName);
        return this;
    }

    public EditAccountPage enterLastName() {
        Actions actions = new Actions(driver);
        actions.moveToElement(lastNameInput).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        lastNameInput.sendKeys(Strings.newLastName);
        return this;
    }

    public String getNewFirstNameFieldValue() {
        return Strings.newFirstName;
    }

    public EditAccountPage clearFirstName() {
        Actions actions = new Actions(driver);
        actions.moveToElement(firstNameInput).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        return this;
    }

    public EditAccountPage clearLastName() {
        Actions actions = new Actions(driver);
        actions.moveToElement(lastNameInput).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        return this;
    }

    public String getRequiredResultMessage() {
        wait.until(ExpectedConditions.visibilityOf(requiredErrorMessage));
        return requiredErrorMessage.getText();
    }

    public String getRequiredMessage() {
        return Strings.requiredMessage;
    }
}
