package models.components.global.footer;

import models.components.ComponentCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".column.customer-service")
public class CustomerColumnComponent extends FooterColumnComponent{

    public CustomerColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
}
