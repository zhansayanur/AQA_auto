package lesson_12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VisualElementsClass {
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @BeforeMethod
    public void startDriver() {
        driver = DriverSetup.setUpDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://andersenlab.com/");
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void testBookingButton() {
        WebElement bookingButton = driver.findElement(By.xpath("//div[@class='Header-module--communicationWrapper--0f5ce']//button[@class='BookingButton-module--button--440fc']"));
        assert bookingButton.isDisplayed() : "There's no booking button";
    }

    @Test
    public void testService() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//footer")));
        WebElement serviceQA = driver.findElement(By.xpath("//section[@class='Footer-module--section--109c7 Footer-module--navigation--6d64c']//div[3]//a[3]"));
        serviceQA.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Quality Assurance Services']")));
        WebElement serviceQAPage = driver.findElement(By.xpath("//h1[text()='Quality Assurance Services']"));
        assert serviceQAPage.isDisplayed() : "There's no such service";
    }
}
