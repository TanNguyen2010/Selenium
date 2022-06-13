package models.components;

import org.openqa.selenium.WebDriver;

public class ExternalLoginPage extends LoginPage{

    public ExternalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void inputUsername(String username) {
        System.out.println("External|input username");
    }

    @Override
    protected void inputPassword(String password) {
        System.out.println("External|input password");
    }

    @Override
    protected void clickOnLoginBtn() {
        System.out.println("External|Click On Bottom");
    }
}
