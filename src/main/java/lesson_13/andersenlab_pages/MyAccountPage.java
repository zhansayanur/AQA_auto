package lesson_13.andersenlab_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//a[contains(text(),'Edit account')]")
    private WebElement editButton;

    @FindBy(xpath = "//div[@class='text-left mt-5 mb-8']//div[1]//p[@class='text-base text-gray-700']")
    private WebElement firstNameLocator;

    public void clickEditButton() {
        wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButton.click();
    }

    public String getEditedFirstNameValue() {
        wait.until(ExpectedConditions.visibilityOf(firstNameLocator));
        return firstNameLocator.getText();
    }
}
