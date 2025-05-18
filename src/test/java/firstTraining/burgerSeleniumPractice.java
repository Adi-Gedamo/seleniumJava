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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class burgerSeleniumPractice {
    private WebDriver driver;
    Utilities utils = new Utilities();

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
    public void burgerTest() {
        driver.get("https://svburger1.co.il/#/HomePage");

        WebElement search = driver.findElement(By.className("form-control"));

        search.clear();
        search.sendKeys("Hadera");

        WebElement button = driver.findElement(By.className("btn-primary"));
        button.click();

    }

    @Test
    public void burgerCSSTest() {
        driver.get("https://svburger1.co.il/#/HomePage");

        WebElement sign = driver.findElement(By.cssSelector("a[href='#/SignUp']"));
        sign.click();

        List<WebElement> inputs = driver.findElements(By.cssSelector("input[class='form-control']"));

        utils.clearAndClick(inputs,0,"Adi");
        utils.clearAndClick(inputs,1,"Gedamo");
        utils.clearAndClick(inputs,2,"Adi@gmail.com");
        utils.clearAndClick(inputs,3,"1234@!A");
        utils.clearAndClick(inputs,4,"1234@!A");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        String link = driver.getCurrentUrl();


    }

}
