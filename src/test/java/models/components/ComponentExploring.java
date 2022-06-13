package models.components;

import lesson16.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;

public class ComponentExploring {

    public <T extends LoginPage> void login(Class<T> loginPageClass) {
        //Neu T dat thanh Teo van OK
        //public <Teo extends LoginPage> void login(Class<Teo> loginPageClass){
//        Class<T>[] parameter = new Class[]{WebDriver.class};
        Class<?>[] parameter = new Class[]{WebDriver.class};
        try {
            Constructor<T> constructor = loginPageClass.getConstructor(parameter);
//            T loginPageObject = constructor.newInstance();
            T loginPageObject = constructor.newInstance(DriverFactory.getChromeDriver());
            loginPageObject.inputUsername("username");
            loginPageObject.inputPassword("password");
            loginPageObject.clickOnLoginBtn();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ComponentExploring().login(InternalLoginPage.class);
        System.out.println("----------------------");
        new ComponentExploring().login(ExternalLoginPage.class);
    }
}
