package lesson15.pom;

import lesson16.DriverFactory;
import lesson17.Urls;
import models.components.LoginComponent;
import models.pages.LoginPage;
import models.pages.LoginPageOld;
import org.openqa.selenium.WebDriver;

public class LoginTest_POM_04 implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
        driver.get(baseUrl.concat(loginSlug));

        LoginPage loginPage = new LoginPage(driver);
        LoginComponent loginComponent = loginPage.loginComponent();
        loginPage.loginComponent().inputUsername("fadasdas");

        Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
