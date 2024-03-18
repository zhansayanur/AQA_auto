package lesson_10.tests_auto;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//The check success message should be displayed if the record was updated successfully.

public class TC05_EditAccount {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\05 Programming\\chromedriver-win64\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.get("https://qa-course-01.andersenlab.com/");

            WebElement emailField = driver.findElement(By.name("email"));
            emailField.sendKeys("snzhansaya@gmail.com");

            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("emma1995");

            WebElement signInButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
            signInButton.click();

            WebDriverWait waitLogin = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement editAccountButton = waitLogin.until(ExpectedConditions.elementToBeClickable(By.linkText("Edit account")));

            editAccountButton.click();

            Actions a = new Actions(driver);

            WebElement firstNameInput = driver.findElement(By.name("firstName"));
            a.moveToElement(firstNameInput).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            firstNameInput.sendKeys("Emma");

            WebElement lastNameInput = driver.findElement(By.name("lastName"));
            a.moveToElement(lastNameInput).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            lastNameInput.sendKeys("Stone");

            WebElement dobInput = driver.findElement(By.name("dateOfBirth"));
            a.moveToElement(dobInput).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
            dobInput.sendKeys("05/05/1995");
            dobInput.sendKeys(Keys.ENTER);

            WebElement newPasswordInput = driver.findElement(By.name("password"));
            newPasswordInput.sendKeys("emma1995");

            WebElement confirmPasswordInput = driver.findElement(By.name("passwordConfirmation"));
            confirmPasswordInput.sendKeys("emma1995");

            WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
            submitButton.click();

            WebDriverWait waitSuccessMessage = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement successMessage = waitSuccessMessage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Your changes have been successfully saved!')]")));

            if (successMessage.isDisplayed()) {
                System.out.println("Success message: Your changes have been successfully saved!");
            } else {
                System.out.println("Test failed. Success message not displayed.");
            }
            driver.quit();
        } catch (TimeoutException e) {
            System.err.println("Test failed.");
        }
    }
}
