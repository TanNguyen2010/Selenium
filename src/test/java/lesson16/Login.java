package lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Login {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            //Navigator to target page
            driver.get("https://the-internet.herokuapp.com/login");

            //Define locator
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("[type='submit']");

            //Find elements
            WebElement userNameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            //Interact with elements
            userNameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginBtnElem.click();

            //--- on the next page---
//            System.out.println("\n----->" + driver.getTitle());
//            System.out.println("\n----->" + driver.getCurrentUrl());
//            By welcomeTextSel = By.cssSelector("h4");
            printTitleUrl(driver);
            By welcomeTextSel = By.tagName("h4");
            WebElement welcomeTextElem = driver.findElement(welcomeTextSel);
            System.out.println("\n----->" + welcomeTextElem.getText());

            // goback
            driver.navigate().back();
            printTitleUrl(driver);

            //Multiple matching elements
            List<WebElement> loginInputFieldElems = driver.findElements(By.tagName("input"));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            userNameElem = loginInputFieldElems.get(USERNAME_INDEX);
            userNameElem.clear();
            userNameElem.sendKeys("teo");
            loginInputFieldElems.get(PASSWORD_INDEX).sendKeys("password");

            loginBtnElem = driver.findElement(loginBtnSel);
            loginBtnElem.click();

            //Find the footer by link text
            By powerByLinkSel = By.linkText("Elemental Selenium");
//          By powerByLinkSel = By.partialLinkText("Selenium");
            WebElement powerByLinkElem = driver.findElement(powerByLinkSel);
            System.out.println("\n----->powerByLink Text: " + powerByLinkElem.getText());
            // Get flash error message
            By flashErrorSel = By.cssSelector(".error");
            WebElement flashErrorElem = driver.findElement(flashErrorSel);
            String loginErrorMessageBackgroundColor = flashErrorElem.getCssValue("background-color");
            System.out.println("----->login Error Message Background Color: " + loginErrorMessageBackgroundColor);

            System.out.println(flashErrorElem.getAttribute("class"));

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
    public static void printTitleUrl(WebDriver driver){
        System.out.print("\n----->" + driver.getTitle());
        System.out.print("\n----->" + driver.getCurrentUrl());
    }
}
