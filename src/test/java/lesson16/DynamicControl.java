package lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicControl {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            //Navigator to target page
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            //Navigate to target page
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.id("input-example");

            //Check form interaction
            WebElement checkboxFormEle = driver.findElement(checkboxFormSel);
            WebElement checkboxEle = checkboxFormEle.findElement(By.tagName("input"));
            if (!checkboxEle.isSelected()){
                checkboxEle.click();
            }
            //Input form interaction
            WebElement inputFormEle = driver.findElement(inputFormSel);
            By inputElemSel = By.tagName("input");
            WebElement inputEle = inputFormEle.findElement(inputElemSel);
            WebElement inputBtnEle = inputFormEle.findElement(By.tagName("button"));
            if (!inputEle.isEnabled()){
                inputBtnEle.click();
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            wait.until(ExpectedConditions.elementToBeClickable(inputElemSel));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));

            inputEle.sendKeys("ABD-------.........");

            // DEBUG PURPOSE ONLY
            Thread.sleep(3000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //Close driver session
            driver.quit();
        }


    }
}
