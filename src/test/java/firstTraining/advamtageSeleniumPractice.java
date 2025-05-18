package firstTraining;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class advamtageSeleniumPractice {
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
    public void getAllButtons() throws InterruptedException {
        driver.get("https://advantageonlineshopping.com/#/");


        List<WebElement> buttons = driver.findElements(By.className("nav-li-Links"));
        Thread.sleep(3000);
        for (WebElement button : buttons) {

            String text = button.getText();
            System.out.println(text);
        }

    }
}
