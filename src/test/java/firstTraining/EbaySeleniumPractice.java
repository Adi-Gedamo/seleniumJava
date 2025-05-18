package firstTraining;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EbaySeleniumPractice {
    private WebDriver driver;

    @Before
    public void init() {

        WebDriverManager.chromedriver().setup(); // Automatically downloads the correct driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void teardown() {
        driver.close();

    }

    @Test
    public void EbayUrlTest() {
        driver.get("https://www.ebay.com/");
        String url = driver.getCurrentUrl();
        assertEquals("https://www.ebay.com/", url, "Page URL  is not as expected ");

        WebElement search = driver.findElement(By.id("gh-ac"));
        search.click();
        search.sendKeys("bag");

    }

    @Test
    public void EbayUrlLinkTest() {
        driver.get("https://www.ebay.com/");
        WebElement Advanced = driver.findElement(By.linkText("Advanced"));
        Advanced.click();
        String url = driver.getCurrentUrl();
        assertEquals("https://www.ebay.com/sch/ebayadvsearch", url,"Page URL  is not as expected");
    }

    @Test
    public void checkSign() {
        EbayUrlLinkTest();
        WebElement complete = driver.findElement(By.name("LH_Complete"));
        complete.click();


    }

}
