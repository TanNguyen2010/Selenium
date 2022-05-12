package lesson16;

import org.openqa.selenium.WebDriver;

public class LaunchChrome {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://www.google.com.vn/");

        // DEBUG PURPOSE ONLY
        Thread.sleep(3000);

        // Quit session
        driver.quit();
    }
}
