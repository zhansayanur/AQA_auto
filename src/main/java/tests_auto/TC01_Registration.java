package tests_auto;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Verify that a new user can register successfully. Fill in all fields with information.

public class TC01_Registration {
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
            confirmPasswordField.sendKeys("qwerty123456");

            WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
            submitButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("https://qa-course-01.andersenlab.com/"));

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://qa-course-01.andersenlab.com/")) {
                System.out.println("Registration has been completed successfully.");
            } else {
                System.out.println("Registration error.");
            }
            driver.quit();
        } catch (TimeoutException e) {
            System.err.println("Test failed.");
        }
    }
}
