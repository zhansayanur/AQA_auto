package lesson_12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    static WebDriver driver;

    @BeforeMethod
    public void startDriver() {
        driver = DriverSetup.setUpDriver();
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void editAccountTest() {
        driver.get("https://qa-course-01.andersenlab.com/registration");

        WebElement firstNameField = driver.findElement(By.name("firstName"));
        firstNameField.sendKeys("Sam");

        WebElement lastNameField = driver.findElement(By.name("lastName"));
        lastNameField.sendKeys("Meller");

        WebElement dobField = driver.findElement(By.name("dateOfBirth"));
        dobField.click();

        WebElement yearOfBirthSelect = driver.findElement(By.xpath("//div[@class='react-datepicker__header react-datepicker__header--custom']//div//select[1]"));
        Select monthSelect = new Select(yearOfBirthSelect);
        monthSelect.selectByValue("1990");

        WebElement monthOfBirthSelect = driver.findElement(By.xpath("//div[@class='react-datepicker__header react-datepicker__header--custom']//div//select[2]"));
        Select yearSelect = new Select(monthOfBirthSelect);
        yearSelect.selectByValue("August");

        WebElement dayOfBirthSelect = driver.findElement(By.xpath("//div[text()='10']"));
        dayOfBirthSelect.click();
        dobField.sendKeys(Keys.ENTER);

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("sam@sam.sam");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("12345678");

        WebElement confirmPasswordField = driver.findElement(By.name("passwordConfirmation"));
        confirmPasswordField.sendKeys("12345678");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();
    }
}
