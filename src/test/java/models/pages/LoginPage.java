package models.pages;

import models.components.LoginComponent;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginComponent loginComponent(){
        return findComponent(LoginComponent.class, driver);
    }
}
