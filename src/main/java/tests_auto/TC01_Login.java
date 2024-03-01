package tests_auto;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Verify the login functionality of website. Enter a valid username and valid password.

public class TC01_Login {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\05 Programming\\chromedriver-win64\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.get("https://qa-course-01.andersenlab.com/");

            WebElement emailField = driver.findElement(By.name("email"));
            emailField.sendKeys("snzhansaya@gmail.com");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("123456@#$");

            WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
            signInButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("https://qa-course-01.andersenlab.com/"));

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://qa-course-01.andersenlab.com/")) {
                System.out.println("The login has been completed successfully.");
            } else {
                System.out.println("Login error.");
            }
            driver.quit();
        } catch (TimeoutException e) {
            System.err.println("Test failed.");
        }
    }
}
