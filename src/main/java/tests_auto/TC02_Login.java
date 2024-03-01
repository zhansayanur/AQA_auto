package tests_auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Enter an invalid username and invalid password.

public class TC02_Login {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\05 Programming\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qa-course-01.andersenlab.com/");

        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("xxxxx@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("qwertyuio");

        WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        signInButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'flex flex-col gap-6']//div[1]//div[@class='text-right relative']//span[@class='absolute right-0 text-rose-500 text-sm']")));

        if(errorMessage.isDisplayed()) {
            System.out.println("Test Passed! Error message is displayed.");
        } else {
            System.out.println("Test Failed! Error message is not displayed.");
        }
        driver.quit();
    }
}
