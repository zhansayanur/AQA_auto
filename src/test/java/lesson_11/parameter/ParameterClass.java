package lesson_11.parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson_11.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class ParameterClass {
    @Test
    @Parameters({"email", "password"})
    public void loginTest(String email, String password){
        WebDriver driver = DriverSetup.setUpDriver();
        driver.get("https://qa-course-01.andersenlab.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        WebDriverWait waitLogin = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitLogin.until(ExpectedConditions.urlToBe("https://qa-course-01.andersenlab.com/"));
        driver.quit();
    }
}
