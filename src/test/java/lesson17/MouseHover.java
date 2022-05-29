package lesson17;

import lesson16.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class MouseHover implements Urls{

    private final static By figureSel = By.className("figure");
    private final static By profileNameSel = By.cssSelector(".figcaption h5");
    private final static By profileLinkSel = By.cssSelector(".figcaption a");

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(baseUrl.concat(hovers));
            List<WebElement> figureElems = driver.findElements(figureSel);
            if (figureElems.isEmpty()){
                throw new RuntimeException("There is no image to test");}
            //Define action object
            Actions action = new Actions(driver);

            //Loop over avatar
            for (WebElement figureElem : figureElems) {
                    WebElement profileNameElem = figureElem.findElement(profileNameSel);
                    WebElement profileLinkElem = figureElem.findElement(profileLinkSel);

                    // Before mouse hover
                    System.out.println("Is profileNameElem displayed: "+ profileNameElem.isDisplayed());
                    System.out.println("Is profileLinkElem displayed: "+ profileLinkElem.isDisplayed());

                    // After mouse hover avatar
                    action.moveToElement(figureElem).perform();
                    // Check after mouse hover
                    System.out.println("Is profileNameElem displayed: "+ profileNameElem.isDisplayed());
                    System.out.println("Is profileLinkElem displayed: "+ profileLinkElem.isDisplayed());
                    //Print
                System.out.println("Profile Name: " + profileNameElem.getText());
                System.out.println("Profile hyperlink: " + profileLinkElem.getAttribute("href"));

            }

            }

         catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }
}
