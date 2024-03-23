package lesson_14.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class RegistrationPage {
    static final Logger logger = LoggerFactory.getLogger(RegistrationPage.class);

    private static class Strings {
        private static final String firstName = "Zhansaya";
        private static final String lastName = "Nurlybekova";
        private static final String correctMail = "zhansayanur19999@gmail.com";
        private static final String takenMail = "snzhansaya@gmail.com";
        private static final String password = "123456@#$";
        private static final String guessablePassword = "12345678";
        private static final String requiredMessage = "Required";
    }

    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(name = "firstName")
    private WebElement firstNameField;

    @FindBy(name = "lastName")
    private WebElement lastNameField;

    @FindBy(name = "dateOfBirth")
    private WebElement dobField ;

    @FindBy(xpath = "//div[@class='react-datepicker__header react-datepicker__header--custom']//div//select[1]")
    private WebElement yearOfBirthSelect;

    @FindBy(xpath = "//div[@class='react-datepicker__header react-datepicker__header--custom']//div//select[2]")
    private WebElement monthOfBirthSelect;

    @FindBy(xpath = "//div[text()='10']")
    private WebElement dayOfBirthSelect;

    @FindBy(name = "email")
    private WebElement emailField ;

    @FindBy(name = "password")
    private WebElement passwordField ;

    @FindBy(name = "passwordConfirmation")
    private WebElement confirmPasswordField ;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='flex flex-col gap-4']//div[1]//div[@class='text-right relative']//span[@class='absolute right-0 text-rose-500 text-sm']")
    private WebElement requiredErrorMessage;

    @Step("I opened link that opens registration page.")
    public RegistrationPage openRegistrationPage() {
        driver.get(Constants.REGISTRATION_PAGE_URL);
        return this;
    }

    @Step("Click submit button when you finish registration.")
    public void clickSubmitButton() {
        logger.info("Click submit button when you finish registration.");
        submitButton.click();
    }

    @Step("This method gets message 'Required' from empty field.")
    public String getRequiredResultMessage() {
        wait.until(ExpectedConditions.visibilityOf(requiredErrorMessage));
        logger.info("Getting 'required' message from element" + requiredErrorMessage.toString());
        return requiredErrorMessage.getText();
    }

    @Step("This method gets String requiredMessage = 'Required'.")
    public String getRequiredMessage() {
        return RegistrationPage.Strings.requiredMessage;
    }

    @Step("Entering first name 'Zhansaya'.")
    public RegistrationPage enterFirstName() {
        firstNameField.sendKeys(RegistrationPage.Strings.firstName);
        return this;
    }

    @Step("Entering last name 'Nurlybekova'.")
    public RegistrationPage enterLastName() {
        lastNameField.sendKeys(Strings.lastName);
        return this;
    }

    @Step("Entering valid email 'zhansayanur19999@gmail.com'.")
    public RegistrationPage enterValidMail() {
        emailField.sendKeys(Strings.correctMail);
        return this;
    }

    @Step("Entering taken email 'snzhansaya@gmail.com'.")
    public RegistrationPage enterTakenMail() {
        emailField.sendKeys(Strings.takenMail);
        return this;
    }

    @Step("Clicking on birth date so i can select date.")
    public RegistrationPage clickBirthDate() {
        dobField.click();
        return this;
    }

    @Step("Selecting year '2002'.")
    public RegistrationPage selectYear() {
        Select year = new Select(yearOfBirthSelect);
        year.selectByValue("2002");
        return this;
    }

    @Step("Selecting month 'October'.")
    public RegistrationPage selectMonth() {
        Select month = new Select(monthOfBirthSelect);
        month.selectByValue("October");
        return this;
    }

    @Step("Selecting day '10'.")
    public void selectDay() {
        dayOfBirthSelect.click();
        dobField.sendKeys(Keys.ENTER);
    }

    @Step("Entering password '123456@#$'.")
    public RegistrationPage enterPassword() {
        passwordField.sendKeys(Strings.password);
        return this;
    }

    @Step("Confirming password '123456@#$'.")
    public RegistrationPage confirmPassword() {
        confirmPasswordField.sendKeys(Strings.password);
        return this;
    }

    @Step("Entering guessable password '12345678'.")
    public RegistrationPage enterGuessablePassword() {
        passwordField.sendKeys(Strings.guessablePassword);
        return this;
    }

    @Step("Confirming guessable password '12345678'.")
    public RegistrationPage confirmGuessablePassword() {
        confirmPasswordField.sendKeys(Strings.guessablePassword);
        return this;
    }

}
