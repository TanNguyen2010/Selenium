package lesson17;

import lesson16.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrame implements Urls{
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(iFramePage));

//            driver.findElement(By.cssSelector("[id=\"tinymce\"]")).sendKeys("abcd");
            // Locate iFrame
            By iFrameSel = By.cssSelector("[id$='ifr']");
            WebElement iFrameElem = driver.findElement(iFrameSel);

            //switch to that frame
            driver.switchTo().frame(iFrameElem);

            //inside input text filed
            WebElement inputTextElem = driver.findElement(By.id("tinymce"));
            inputTextElem.click();
            inputTextElem.clear();
            Thread.sleep(3000);
            inputTextElem.sendKeys("New text");

            //DEBUG PURPOSE ONLY
            Thread.sleep(3000);

            //switch to parent frame
            driver.switchTo().defaultContent();
            System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getAttribute("href"));

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }
}
