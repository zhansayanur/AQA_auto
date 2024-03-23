package lesson_13.websites_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GuinnessWorldRecordsPage {
    private static class Strings {
        private static final String firstName = "Zhansaya";
        private static final String lastName = "Nurlybekova";
        private static final String dateOfBirthDay = "15";
        private static final String dateOfBirthMonth = "10";
        private static final String dateOfBirthYear = "2002";
        private static final String stateInput = "Kazakhstan";
        private static final String emailAddress = "zhansaya@gmail.com";
        private static final String passwordInput = "12345678";
        private static final String wrongPassword = "qwertyui";
    }
    private WebDriver driver;
    private WebDriverWait wait;

    public GuinnessWorldRecordsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "FirstName")
    private WebElement firstNameLocator;

    @FindBy(id = "LastName")
    private WebElement lastNameLocator;

    @FindBy(id = "DateOfBirthDay")
    private WebElement dateOfBirthDayLocator;

    @FindBy(id = "DateOfBirthMonth")
    private WebElement dateOfBirthMonthLocator;

    @FindBy(id = "DateOfBirthYear")
    private WebElement dateOfBirthYearLocator;

    @FindBy(xpath = "//select[@name='Country']")
    private WebElement countrySelectLocator;

    @FindBy(id = "State")
    private WebElement stateInputLocator;

    @FindBy(id = "EmailAddress")
    private WebElement emailAddressLocator;

    @FindBy(id = "ConfirmEmailAddress")
    private WebElement confirmEmailAddressLocator;

    @FindBy(id = "Password")
    private WebElement passwordInputLocator;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordLocator;

    @FindBy(xpath = "//span[@for='ConfirmPassword']")
    private WebElement messageConfirmPasswordLocator;

    public GuinnessWorldRecordsPage enterLastName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LastName")));
        lastNameLocator.sendKeys(Strings.lastName);
        return this;
    }

    public GuinnessWorldRecordsPage enterFirstName() {
        firstNameLocator.sendKeys(Strings.firstName);
        return this;
    }

    public GuinnessWorldRecordsPage enterDateOfBirthDay() {
        dateOfBirthDayLocator.sendKeys(Strings.dateOfBirthDay);
        return this;
    }

    public GuinnessWorldRecordsPage enterDateOfBirthMonth() {
        dateOfBirthMonthLocator.sendKeys(Strings.dateOfBirthMonth);
        return this;
    }

    public GuinnessWorldRecordsPage enterDateOfBirthYear() {
        dateOfBirthYearLocator.sendKeys(Strings.dateOfBirthYear);
        return this;
    }

    public GuinnessWorldRecordsPage selectCountry() {
        Select countrySelectValue = new Select(countrySelectLocator);
        countrySelectValue.selectByValue("KZ");
        return this;
    }

    public GuinnessWorldRecordsPage enterStateInput() {
        stateInputLocator.sendKeys(Strings.stateInput);
        return this;
    }

    public GuinnessWorldRecordsPage enterEmailAddress() {
        emailAddressLocator.sendKeys(Strings.emailAddress);
        return this;
    }

    public GuinnessWorldRecordsPage enterConfirmEmailAddress() {
        confirmEmailAddressLocator.sendKeys(Strings.emailAddress);
        return this;
    }

    public GuinnessWorldRecordsPage enterPasswordInput() {
        passwordInputLocator.sendKeys(Strings.passwordInput);
        return this;
    }

    public GuinnessWorldRecordsPage enterConfirmPassword() {
        confirmPasswordLocator.sendKeys(Strings.wrongPassword);
        confirmPasswordLocator.sendKeys(Keys.ENTER);
        return this;
    }

    public GuinnessWorldRecordsPage printMessageConfirmPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@for='ConfirmPassword']")));
        WebElement messageConfirmPassword = messageConfirmPasswordLocator;
        System.out.println(messageConfirmPassword.getText());
        return this;
    }

    public void switchToSubChildWindow() {
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentId = (String) it.next();
        String childId = (String) it.next();
        String subChildId = (String) it.next();
        driver.switchTo().window(childId);
    }
}
