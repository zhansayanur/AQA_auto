package tests_auto;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TC01_EditAccount {
    public static void main(String[] args) {
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qa-course-01.andersenlab.com/"));

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://qa-course-01.andersenlab.com/")) {
            System.out.println("Account information is updated and saved successfully.");
        } else {
            System.out.println("Test failed.");
        }
        driver.quit();
    }
}
