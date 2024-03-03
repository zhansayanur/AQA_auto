package lesson_10.shop_compare;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClothesComparisonTest {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\05 Programming\\chromedriver-win64\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            driver.get("http://www.automationpractice.pl/index.php");

            WebElement searchInput = driver.findElement(By.name("search_query"));
            searchInput.sendKeys("Printed chiffon dress");
            driver.findElement(By.name("submit_search")).click();

            driver.findElement(By.xpath("//a[contains(text(),'List')]")).click();

            WebElement addToCompareButton1 = driver.findElement(By.xpath("//a[@data-id-product = \"7\"]"));
            addToCompareButton1.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bottom-pagination-content clearfix']//strong[@class='total-compare-val']"), "1"));

            driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li//a[text()='Women']")).click();

            searchInput = driver.findElement(By.name("search_query"));
            searchInput.sendKeys("Faded Short");
            driver.findElement(By.name("submit_search")).click();

            driver.findElement(By.xpath("//a[@data-id-product = \"1\"]")).click();

            wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bottom-pagination-content clearfix']//strong[@class='total-compare-val']"), "2"));

            driver.findElement(By.xpath("//div[@class='top-pagination-content clearfix']//strong[@class='total-compare-val'][text() = 2]")).click();

            if (driver.getCurrentUrl().contains("http://www.automationpractice.pl/index.php?controller=products-comparison&compare_product_list=1%7C7")) {
                System.out.println("Test passed! Compare page opens.");
            } else {
                System.out.println("Test failed: Compare page did not open.");
            }

            try {
                Thread.sleep(5000); //
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            driver.quit();
        } catch (TimeoutException e) {
            System.err.println("Test failed.");
        }
    }
}
