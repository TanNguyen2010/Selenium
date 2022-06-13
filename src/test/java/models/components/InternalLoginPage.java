package models.components;

import org.openqa.selenium.WebDriver;

public class InternalLoginPage extends LoginPage{

    public InternalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void inputUsername(String username) {
        System.out.println("Internal|input username");
    }

    @Override
    protected void inputPassword(String password) {
        System.out.println("Internal|input password");
    }

    @Override
    protected void clickOnLoginBtn() {
        System.out.println("Internal|Click On Bottom");
    }
}
