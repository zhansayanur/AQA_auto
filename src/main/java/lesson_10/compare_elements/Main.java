package lesson_10.compare_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\05 Programming\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qa-course-01.andersenlab.com/login");

        WebElement element1 = driver.findElement(By.name("password"));
        WebElement element2 = driver.findElement(By.linkText("Registration"));

        ElementComparison.compareElements(element1, element2);

        driver.quit();
    }
}
