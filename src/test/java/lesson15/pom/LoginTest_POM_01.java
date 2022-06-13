package lesson15.pom;

import lesson16.DriverFactory;
import lesson17.Urls;
import models.pages.LoginPageOld;
import org.openqa.selenium.WebDriver;

public class LoginTest_POM_01 implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
        driver.get(baseUrl.concat(loginSlug));

        LoginPageOld loginPage = new LoginPageOld(driver);
        loginPage.usernameElem().sendKeys("Tanfff");
        loginPage.passwordElem().sendKeys("12345");
        loginPage.loginBtnElem().click();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
