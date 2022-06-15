package lesson19.global;

import lesson16.DriverFactory;
import models.components.global.footer.FooterComponent;
import models.components.global.footer.InformationColumnComponent;
import models.components.global.header.TopMenuComponent;
import static models.components.global.header.TopMenuComponent.MainCatItem;
import static models.components.global.header.TopMenuComponent.CatItemComponent;
import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;

public class FooterTest {

    @Test
    public void testFooterHomePage() {
//        System.out.println("Footer Test | Home page");
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get("http://demowebshop.tricentis.com/");
            HomePage homePage = new HomePage(driver);
            FooterComponent footerComponent = homePage.footerComp();

            InformationColumnComponent informationColumnComponent = footerComponent.informationColumnComp();
            System.out.println(informationColumnComponent.headerElem().getText());
            if (informationColumnComponent.linkElems().isEmpty()){
                throw new IllegalArgumentException("[ERR]There is no links");
            }
            informationColumnComponent.linkElems().forEach(link ->{
                System.out.println("\t-->" + link.getText());
                System.out.println("\t-->" + link.getAttribute("href"));
            });



//            System.out.println(footerComponent.informationColumnComp().headerElem().getText());
            System.out.println(footerComponent.customerColumnComp().headerElem().getText());
            System.out.println(footerComponent.myAccountColumnComp().headerElem().getText());
            System.out.println(footerComponent.followUsColumnComp().headerElem().getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testFooterCategoryPage() {
//        System.out.println("Footer Test | Category page");

        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get("http://demowebshop.tricentis.com/");
            HomePage homePage = new HomePage(driver);
            TopMenuComponent topMenuComponent = homePage.topMenuComp();

            List<MainCatItem> mainItemElem = topMenuComponent.mainItemElem();
            //TODO : Throw Err when mainItemElem is empty
            MainCatItem randomMainItemElem = mainItemElem.get(new SecureRandom().nextInt(mainItemElem.size()));
            String randomCatHref = randomMainItemElem.catItemLinkElem().getAttribute("href");

            //Get sublist
            List<CatItemComponent> catItemComps = randomMainItemElem.catItemComponents();

            //If mainItem has sublist click on random item
            if (catItemComps.isEmpty()){
                randomMainItemElem.catItemLinkElem().click();
            }else {
                int randomIndex = new SecureRandom().nextInt(catItemComps.size());
                CatItemComponent randomCatItemComponent = catItemComps.get(randomIndex);
                randomCatHref = randomCatItemComponent.getComponent().getDomAttribute("href");
                randomCatItemComponent.getComponent().click();
            }


//            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains(randomCatHref));

            homePage = new HomePage(driver);
            FooterComponent footerComponent = homePage.footerComp();
            InformationColumnComponent informationColumnComponent = footerComponent.informationColumnComp();
            System.out.println(informationColumnComponent.headerElem().getText());
            if (informationColumnComponent.linkElems().isEmpty()){
                throw new IllegalArgumentException("[ERR]There is no links");
            }
            informationColumnComponent.linkElems().forEach(link ->{
                System.out.println("\t-->" + link.getText());
                System.out.println("\t-->" + link.getAttribute("href"));
            });

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
