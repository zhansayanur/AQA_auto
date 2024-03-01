package open_websites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class OpenWebsites {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\05 Programming\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        List<String> urls = new ArrayList<>();
        urls.add("http://www.automationpractice.pl/index.php");
        urls.add("https://zoo.waw.pl/");
        urls.add("https://www.w3schools.com/");
        urls.add("https://www.clickspeedtester.com/click-counter/");
        urls.add("https://andersenlab.com/");

        for (String url : urls) {
            driver.switchTo().newWindow(WindowType.WINDOW);
            driver.get(url);
            System.out.println("Открыта страница: " + driver.getTitle() + ", URL: " + url);
        }

        for (String url : urls) {
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
                if (driver.getTitle().contains("Zoo")) {
                    driver.close();
                    System.out.println("Закрыто окно с Zoo");
                    break;
                }
            }
        }

        try {
            Thread.sleep(10000); //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
