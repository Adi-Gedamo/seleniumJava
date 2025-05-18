package firstTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utilities {


    private By driver;

    public void clearAndClick(List<WebElement> inputs, int num, String text ){
        System.out.println("");
      WebElement input =  inputs.get(num);

        input.clear();
        input.sendKeys(text);
        input.click();

    }
}
