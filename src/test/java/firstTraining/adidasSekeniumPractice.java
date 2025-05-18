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

public class adidasSekeniumPractice {
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
    public void adidasUrlTest() {
        driver.get("https://www.adidas.com/us");
        WebElement sale = driver.findElement(By.partialLinkText("SALE"));
        sale.click();
        String url = driver.getCurrentUrl();

        assertEquals("https://www.adidas.com/us/sale", url, "Page URL  is not as expected ");


    }


    //
}
