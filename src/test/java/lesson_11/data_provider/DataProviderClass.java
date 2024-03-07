package lesson_11.data_provider;

import lesson_11.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderClass {
    @Test(dataProvider = "loginParameters" )
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

    @DataProvider(name = "loginParameters")
    public Object[][] createData(){
        return new Object[][]{
                {"snzhansaya@gmail.com", "emma1995"}, {"61yana61@gmail.com", "qwerty123456"}, {"hatak3333@gmail.com", "12345678"}
        };
    }
}
