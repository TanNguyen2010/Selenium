package lesson17;

import lesson16.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JSAlerts implements Urls{
    private final static By jsAlertSel = By.cssSelector("[onclick=\"jsAlert()\"]");
    private final static By jsAlertConfirmSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
    private final static By jsAlertPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");
//    private final static By result = By.id("result");
    private final static By result = By.cssSelector("#result");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(jsAlertPage));
            WebElement triggerJSAlertBtn;
            Alert alert;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            //JS Alert
            triggerJSAlertBtn = driver.findElement(jsAlertSel);
            triggerJSAlertBtn.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert content: "+ alert.getText());
            alert.accept();
            System.out.println(driver.findElement(result).getText());

            //JS Alert Confirm
            triggerJSAlertBtn = driver.findElement(jsAlertConfirmSel);
            triggerJSAlertBtn.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert content: "+ alert.getText());
            alert.dismiss();
            System.out.println(driver.findElement(result).getText());

            //JS Alert Prompt
            triggerJSAlertBtn = driver.findElement(jsAlertPromptSel);
            triggerJSAlertBtn.click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert content: "+ alert.getText());
            alert.sendKeys("My name iss Tan");
            alert.accept();
            System.out.println(driver.findElement(result).getText());


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }
}
