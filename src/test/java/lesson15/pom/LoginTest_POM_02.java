package lesson15.pom;

import lesson16.DriverFactory;
import lesson17.Urls;
import models.pages.LoginPageOld;
import org.openqa.selenium.WebDriver;

public class LoginTest_POM_02 implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
        driver.get(baseUrl.concat(loginSlug));

        LoginPageOld loginPage = new LoginPageOld(driver);
        loginPage.inputUsername("Tanfff");
        loginPage.inputPassword("12345");
        loginPage.clickLoginBtn();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
