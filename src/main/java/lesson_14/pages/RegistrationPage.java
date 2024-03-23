package lesson_14.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private static class Strings {
        private static final String firstName = "Zhansaya";
        private static final String lastName = "Nurlubekova";
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

    public RegistrationPage openRegistrationPage() {
        driver.get(Constants.REGISTRATION_PAGE_URL);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getRequiredResultMessage() {
        wait.until(ExpectedConditions.visibilityOf(requiredErrorMessage));
        return requiredErrorMessage.getText();
    }

    public String getRequiredMessage() {
        return RegistrationPage.Strings.requiredMessage;
    }

    public RegistrationPage enterFirstName() {
        firstNameField.sendKeys(RegistrationPage.Strings.firstName);
        return this;
    }

    public RegistrationPage enterLastName() {
        lastNameField.sendKeys(Strings.lastName);
        return this;
    }

    public RegistrationPage enterValidMail() {
        emailField.sendKeys(Strings.correctMail);
        return this;
    }

    public RegistrationPage enterTakenMail() {
        emailField.sendKeys(Strings.takenMail);
        return this;
    }

    public RegistrationPage clickBirthDate() {
        dobField.click();
        return this;
    }

    public RegistrationPage selectYear() {
        Select year = new Select(yearOfBirthSelect);
        year.selectByValue("2002");
        return this;
    }

    public RegistrationPage selectMonth() {
        Select month = new Select(monthOfBirthSelect);
        month.selectByValue("October");
        return this;
    }

    public void selectDay() {
        dayOfBirthSelect.click();
        dobField.sendKeys(Keys.ENTER);
    }

    public RegistrationPage enterPassword() {
        passwordField.sendKeys(Strings.password);
        return this;
    }

    public RegistrationPage confirmPassword() {
        confirmPasswordField.sendKeys(Strings.password);
        return this;
    }

    public RegistrationPage enterGuessablePassword() {
        passwordField.sendKeys(Strings.guessablePassword);
        return this;
    }

    public RegistrationPage confirmGuessablePassword() {
        confirmPasswordField.sendKeys(Strings.guessablePassword);
        return this;
    }

}
