package models.components;

import org.openqa.selenium.WebDriver;

public abstract class LoginPage {
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    protected final WebDriver driver;

    protected abstract void inputUsername(String username);
    protected abstract void inputPassword(String password);
    protected abstract void clickOnLoginBtn();

}
