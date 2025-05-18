package firstTraining;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class eCommersTest {
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
    public void searchForProduct(){
        driver.get("https://ecommerce-playground.lambdatest.io/");


        WebElement search = driver.findElement(By.name("search"));
        search.click();
        search.sendKeys("iphone");

        WebElement button = driver.findElement(By.className("type-text"));
        String text = button.getText();
        System.out.println(text);
        button.click();

        Assert.assertEquals("button is not SEARCH","SEARCH",text);

    }
}
