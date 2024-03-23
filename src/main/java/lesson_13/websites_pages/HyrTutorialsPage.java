package lesson_13.websites_pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HyrTutorialsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HyrTutorialsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//button[@onclick=\"alertFunction()\"]")
    private WebElement alertBoxButtonLocator;

    @FindBy(xpath = "//button[@onclick=\"confirmFunction()\"]")
    private WebElement confirmBoxButtonLocator;

    @FindBy(xpath = "//button[@onclick=\"promptFunction()\"]")
    private WebElement promptBoxButtonLocator;

    @FindBy(id = "output")
    private WebElement outputMessages;

    public void clickAlertBoxButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"alertFunction()\"]")));
        alertBoxButtonLocator.click();
    }

    public HyrTutorialsPage alertBoxAccept() {
        Alert alert = driver.switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return this;
    }

    public HyrTutorialsPage getMessageAlertBoxAccept() {
        System.out.println(outputMessages.getText());
        return this;
    }

    public void clickConfirmBoxButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"confirmFunction()\"]")));
        confirmBoxButtonLocator.click();
    }

    public HyrTutorialsPage confirmBoxDismiss() {
        Alert alert = driver.switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        return this;
    }

    public HyrTutorialsPage getMessageConfirmBoxDismiss() {
        System.out.println(outputMessages.getText());
        return this;
    }

    public void clickPromptBoxButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick=\"promptFunction()\"]")));
        promptBoxButtonLocator.click();
    }

    public HyrTutorialsPage promptBoxEnter() {
        Alert alert = driver.switchTo().alert();
        String text = "Final step of this task";
        alert.sendKeys(text);
        alert.accept();
        return this;
    }

    public HyrTutorialsPage getMessagePromptBoxEnter() {
        System.out.println(outputMessages.getText());
        return this;
    }

    public void switchToChildWindow() {
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentId = (String) it.next();
        String childId = (String) it.next();
        String subChildId = (String) it.next();
        driver.switchTo().window(subChildId);
    }
}
