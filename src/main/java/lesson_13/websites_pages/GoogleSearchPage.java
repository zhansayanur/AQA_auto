package lesson_13.websites_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    static Actions actions;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//textarea[@class='gLFyf']")
    private WebElement searchFieldLocator;

    @FindBy(xpath = "//div[@class='BKRPef']//div[@class='M2vV3 vOY7J']")
    private WebElement clearSearchLocator;

    public GoogleSearchPage openGooglePage() {
        driver.get("https://www.google.com/search");
        return this;
    }

    public GoogleSearchPage openGuinnessWorldRecordsPage() {
        searchFieldLocator.sendKeys("https://www.guinnessworldrecords.com/account/register?");
        searchFieldLocator.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dURPMd']//div[@class='hlcw0c']//h3[text()='Create account']")));
        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//div[@class='dURPMd']//div[@class='hlcw0c']//h3[text()='Create account']"))).keyUp(Keys.CONTROL).build().perform();
        return this;
    }

    public GoogleSearchPage openHyrTutorialsPage() {
        clearSearchLocator.click();
        searchFieldLocator.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        searchFieldLocator.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dURPMd']//h3[text()='AlertsDemo']")));
        actions.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//div[@class='dURPMd']//h3[text()='AlertsDemo']"))).keyUp(Keys.CONTROL).build().perform();
        return this;
    }

    public GoogleSearchPage openW3SchoolsPage() {
        clearSearchLocator.click();
        searchFieldLocator.sendKeys("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        searchFieldLocator.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='dURPMd']//h3[text()='W3Schools Tryit Editor - HTML Forms']")));
        actions.click(driver.findElement(By.xpath("//div[@class='dURPMd']//h3[text()='W3Schools Tryit Editor - HTML Forms']"))).perform();
        return this;
    }
}
