package firstTraining;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class guru99SeleniumPractice {

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
    public void guru99UrlTest() {
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        String url = driver.getCurrentUrl();
        assertEquals("https://demo.guru99.com/test/newtours/index.php", url, "Page URL  is not as expected ");

        WebElement user = driver.findElement(By.name("userName"));
        user.click();
        user.sendKeys("tutorial");
        ;

        WebElement pw = driver.findElement(By.name("password"));
        pw.click();
        pw.sendKeys("tutorial");
        ;

        WebElement submit = driver.findElement(By.name("submit"));
        submit.click();

        String url2 = driver.getCurrentUrl();
        assertEquals("https://demo.guru99.com/test/newtours/login_sucess.php", url2, "Page URL  is not as expected");

    }

    @Test
    public void linkTest() {
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        WebElement contact = driver.findElement(By.linkText("CONTACT"));
        contact.click();
        String url = driver.getCurrentUrl();
        assertEquals("https://demo.guru99.com/test/newtours/support.php", url, "Page URL  is not as expected");

    }

    @Test
    public void partialLinkTest() {
        driver.get("https://demo.guru99.com/test/newtours/index.php");
        WebElement sign = driver.findElement(By.partialLinkText("SIGN"));
        sign.click();
        String url = driver.getCurrentUrl();
        assertEquals("https://demo.guru99.com/test/newtours/login.php", url, "Page URL  is not as expected");

    }

    @Test
    public void radioButtonsTest() {
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement first = driver.findElement(By.name("servClass"));
        first.click();

        List<WebElement> radioButtons = driver.findElements(By.name("tripType"));
        radioButtons.get(1).click();

        WebElement pass = driver.findElement(By.name("passCount"));
        Select viewAsSelect =  new Select(pass);
        viewAsSelect.selectByIndex(1);

        WebElement go = driver.findElement(By.name("findFlights"));
        go.click();



    }

}
