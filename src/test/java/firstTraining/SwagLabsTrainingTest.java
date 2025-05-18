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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwagLabsTrainingTest {
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
    public void saucedemoUrlTest() {
        driver.get("https://www.saucedemo.com/");
        String url = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/", url, "Page URL  is not as expected ");

        WebElement user = driver.findElement(By.id("user-name"));
        user.click();
       user.sendKeys("standadrd_user");;

        WebElement pw = driver.findElement(By.name("password"));
        pw.click();
        pw.sendKeys("secret_sauce");;

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
    }
    @Test
    public void getFirstPrice() {
        driver.get("https://www.saucedemo.com/");
        String url = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/", url, "Page URL  is not as expected ");

        WebElement user = driver.findElement(By.id("user-name"));
        user.click();
        user.sendKeys("standard_user");;

        WebElement pw = driver.findElement(By.name("password"));
        pw.click();
        pw.sendKeys("secret_sauce");;

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

//        WebElement price = driver.findElement(By.className("inventory_item_price"));
//        String text = price.getText();
//        System.out.println(text);
    }
    @Test
    public void getAllPrices() {
        driver.get("https://www.saucedemo.com/");
        String url = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/", url, "Page URL  is not as expected ");

        WebElement user = driver.findElement(By.id("user-name"));
        user.click();
        user.sendKeys("standard_user");;

        WebElement pw = driver.findElement(By.name("password"));
        pw.click();
        pw.sendKeys("secret_sauce");

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        for (WebElement price:prices){
        System.out.println(price.getText());}
    }

    @Test
    public void dropDown() {
        getFirstPrice();

        WebElement view = driver.findElement(By.className("product_sort_container"));

        Select viewAsSelect = new Select(view);

        //viewAsSelect.selectByIndex(2);
        viewAsSelect.selectByVisibleText("Price (high to low)");


    }
    @Test
    public void logIn() {
        driver.get("https://www.saucedemo.com/");

        List<WebElement> logIn = driver.findElements(By.className("form_input"));
        logIn.get(0).click();
        logIn.get(0).sendKeys("standard_user");;

        logIn.get(1).click();
        logIn.get(1).sendKeys("secret_sauce");;

        WebElement button = driver.findElement(By.id("login-button"));
        button.click();


    }
    @Test
    public void logInByCSS() {
        driver.get("https://www.saucedemo.com/");

        WebElement logIn = driver.findElement(By.cssSelector("input[class = 'input_error form_input']"));

        logIn.clear();
        logIn.sendKeys("standard_user");

        WebElement pw = driver.findElement(By.cssSelector("input[data-test = 'password']"));

        pw.clear();
        pw.sendKeys("secret_sauce");

        WebElement submit = driver.findElement(By.cssSelector("input[class = 'submit-button btn_action']"));
        submit.click();

        Assert.assertEquals("not working","https://www.saucedemo.com/inventory.html",driver.getCurrentUrl());

    }

    @Test
    public void getAllPrices2() {
        logInByCSS();

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        for (WebElement price:prices){
           String priceText = price.getText();
            priceText = priceText.replace("$","");
            int index = priceText.indexOf(".");

            String priceTextFinale = priceText.substring(0, index);
            System.out.println(priceTextFinale);

            int priceAsInt = Integer.parseInt(priceTextFinale);

            if (priceAsInt>20){

                System.out.println("the price is higher than 20");

            }


        }
    }

}
