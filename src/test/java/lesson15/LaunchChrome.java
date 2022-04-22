package lesson15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchChrome {
    public static void main(String[] args) throws InterruptedException {
        String currentProjectLocation = System.getProperty("user.dir");
        String relativeChromeDriverPath = "\\src\\test\\resources\\drivers\\chromedriver.exe";
        String chromeDriverPath = currentProjectLocation.concat(relativeChromeDriverPath);
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        //WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.vn/");
        //driver.get("https://sdetpro.com");

        // DEBUG PURPOSE ONLY
        Thread.sleep(3000);

        // Quit session
        driver.quit();
    }
}
