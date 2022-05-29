package lesson17;

import lesson16.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown implements Urls{
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(dropdownOptionPage));

            //Dropdown locator & element
            By dropdownSel = By.id("dropdown");
            WebElement dropdownElem = driver.findElement(dropdownSel);

            //Select dropdown
            Select select = new Select(dropdownElem);

            //Select by visible text
            select.selectByVisibleText("Option 1");
            Thread.sleep(1000);

            //Select by index
            Thread.sleep(1000);
            select.selectByIndex(2);

            //Select by value
            Thread.sleep(1000);
            select.selectByValue("1");


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }
}
