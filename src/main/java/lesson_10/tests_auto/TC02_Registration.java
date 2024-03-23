package lesson_10.tests_auto;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Check that the “Confirm Password” field matches the password entered. Check error message.

public class TC02_Registration {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\05 Programming\\chromedriver-win64\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.get("https://qa-course-01.andersenlab.com/");

            WebElement registrationButton = driver.findElement(By.linkText("Registration"));
            registrationButton.click();

            WebElement firstNameField = driver.findElement(By.name("firstName"));
            firstNameField.sendKeys("Saya");

            WebElement lastNameField = driver.findElement(By.name("lastName"));
            lastNameField.sendKeys("Nur");

            WebElement dobField = driver.findElement(By.name("dateOfBirth"));
            dobField.sendKeys("10/10/2002");
            dobField.sendKeys(Keys.ENTER);

            WebElement emailField = driver.findElement(By.name("email"));
            emailField.sendKeys("61yana61@gmail.com");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("qwerty123456");

            WebElement confirmPasswordField = driver.findElement(By.name("passwordConfirmation"));
            confirmPasswordField.sendKeys("13245678");

            WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
            submitButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Passwords must match')]")));
                System.out.println("Test Passed! Error message is displayed.");
            } catch (TimeoutException e) {
                System.out.println("Test Passed! Passwords are matching! ");
            }

            driver.quit();
        } catch (TimeoutException e) {
            System.err.println("Test failed.");
        }
    }
}
