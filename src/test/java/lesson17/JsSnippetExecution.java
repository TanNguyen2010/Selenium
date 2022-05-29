package lesson17;

import lesson16.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsSnippetExecution implements Urls{
    //Javascript - Scroll

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get(baseUrl.concat(floatingPageSlug));
        try {

            //Scroll to Bottom
            scrollToBottom(driver);

            // Debug purpose
            Thread.sleep(3000);

            //Scroll to Top
            scrollToTop(driver);

            // Debug purpose
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }
    private static void scrollToBottom(WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    private static void scrollToTop(WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
    }
}
