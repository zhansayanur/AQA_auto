package lesson_12;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WebsitesTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @BeforeMethod
    public void startDriver() {
        driver = DriverSetup.setUpDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void websitesTest() throws InterruptedException {
        driver.get("https://www.google.com/search");

        WebElement searchField = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchField.sendKeys("https://www.guinnessworldrecords.com/account/register?");
        searchField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dURPMd']//div[@class='hlcw0c']//h3[text()='Create account']")));
        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//div[@class='dURPMd']//div[@class='hlcw0c']//h3[text()='Create account']"))).keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(5000);

        WebElement clearSearch = driver.findElement(By.xpath("//div[@class='BKRPef']//div[@class='M2vV3 vOY7J']"));
        clearSearch.click();
        WebElement searchField2 = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchField2.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        searchField2.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dURPMd']//h3[text()='AlertsDemo']")));
        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//div[@class='dURPMd']//h3[text()='AlertsDemo']"))).keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(5000);

        WebElement clearSearch2 = driver.findElement(By.xpath("//div[@class='BKRPef']//div[@class='M2vV3 vOY7J']"));
        clearSearch2.click();
        WebElement searchField3 = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchField3.sendKeys("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        searchField3.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dURPMd']//h3[text()='W3Schools Tryit Editor - HTML Forms']")));
        actions.click(driver.findElement(By.xpath("//div[@class='dURPMd']//h3[text()='W3Schools Tryit Editor - HTML Forms']"))).perform();

        // В открытом окне заполнить поля своим именем и фамилией и нажать кнопку ‘Submit’.
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
        WebElement firstNameField = driver.findElement(By.id("fname"));
        firstNameField.clear();
        firstNameField.sendKeys("Zhansaya");
        WebElement lastNameField = driver.findElement(By.id("lname"));
        lastNameField.clear();
        lastNameField.sendKeys("Nur");

        WebElement buttonSubmit = driver.findElement(By.xpath("//input[@value='Submit']"));
        buttonSubmit.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']//p")));
        WebElement messageNote = driver.findElement(By.xpath("//div[@class='w3-panel w3-pale-yellow w3-leftbar w3-border-yellow']//p"));
        System.out.println(messageNote.getText());

        Set<String> handles = driver.getWindowHandles();
        Iterator it = handles.iterator();
        String parentId = (String) it.next();
        String childId = (String) it.next();
        String subChildId = (String) it.next();

        // Переключиться на вкладку, в котором открыта следующая ссылка: https://www.guinnessworldrecords.com/account/register?
        driver.switchTo().window(subChildId);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LastName")));
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Nurlybekova");

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Zhansaya");

        WebElement dateOfBirthDay = driver.findElement(By.id("DateOfBirthDay"));
        dateOfBirthDay.sendKeys("15");

        WebElement dateOfBirthMonth = driver.findElement(By.id("DateOfBirthMonth"));
        dateOfBirthMonth.sendKeys("10");

        WebElement dateOfBirthYear = driver.findElement(By.id("DateOfBirthYear"));
        dateOfBirthYear.sendKeys("2002");

        WebElement countrySelect = driver.findElement(By.xpath("//select[@name='Country']"));
        Select countrySelectValue = new Select(countrySelect);
        countrySelectValue.selectByValue("KZ");

        WebElement stateInput = driver.findElement(By.id("State"));
        stateInput.sendKeys("Kazakhstan");

        WebElement emailAddress = driver.findElement(By.id("EmailAddress"));
        emailAddress.sendKeys("zhansaya@gmail.com");

        WebElement confirmEmailAddress = driver.findElement(By.id("ConfirmEmailAddress"));
        confirmEmailAddress.sendKeys("zhansaya@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("12345678");

        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("qwertyui");
        confirmPassword.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@for='ConfirmPassword']")));
        WebElement messageConfirmPassword = driver.findElement(By.xpath("//span[@for='ConfirmPassword']"));
        System.out.println(messageConfirmPassword.getText());

        // Переключиться на окно, в котором открыта следующая ссылка: https://www.hyrtutorials.com/p/alertsdemo.html
        driver.switchTo().window(childId);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"alertFunction()\"]"))).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement alertMessage1 = driver.findElement(By.id("output"));
        System.out.println(alertMessage1.getText());

        driver.findElement(By.xpath("//button[@onclick=\"confirmFunction()\"]")).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        WebElement alertMessage2 = driver.findElement(By.id("output"));
        System.out.println(alertMessage2.getText());

        driver.findElement(By.xpath("//button[@onclick=\"promptFunction()\"]")).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = "Final step of this task";
        alert.sendKeys(text);
        alert.accept();
        WebElement alertMessage3 = driver.findElement(By.id("output"));
        System.out.println(alertMessage3.getText());
    }
}
