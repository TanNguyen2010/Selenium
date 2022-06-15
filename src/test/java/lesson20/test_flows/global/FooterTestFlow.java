package lesson20.test_flows.global;

import models.components.global.footer.*;
import models.components.global.header.TopMenuComponent;

import static models.components.global.header.TopMenuComponent.MainCatItem;
import static models.components.global.header.TopMenuComponent.CatItemComponent;

import models.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FooterTestFlow {
    private final WebDriver driver;

    public FooterTestFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFooterComp() {
        HomePage homePage = new HomePage(driver);
        FooterComponent footerComponent = homePage.footerComp();

        /*InformationColumnComponent informationColumnComponent = footerComponent.informationColumnComp();
        System.out.println(informationColumnComponent.headerElem().getText());
        if (informationColumnComponent.linkElems().isEmpty()) {
            throw new IllegalArgumentException("[ERR]There is no links");
        }
        informationColumnComponent.linkElems().forEach(link -> {
            System.out.println("\t-->" + link.getText());
            System.out.println("\t-->" + link.getAttribute("href"));
        });

//      System.out.println(footerComponent.informationColumnComp().headerElem().getText());
        System.out.println(footerComponent.customerColumnComp().headerElem().getText());
        System.out.println(footerComponent.myAccountColumnComp().headerElem().getText());
        System.out.println(footerComponent.followUsColumnComp().headerElem().getText());*/

        verifyInformationColumn(footerComponent);
        verifyCustomerColumn(footerComponent);
        verifyMyAccountColumn(footerComponent);
        verifyFollowUsColumn(footerComponent);
    }

    private void verifyInformationColumn(FooterComponent footerComponent) {
        InformationColumnComponent informationColumnComp = footerComponent.informationColumnComp();

        String actualColumnTitle = informationColumnComp.headerElem().getText().trim();
        String expectedTitle = "INFORMATION";
        Assert.assertEquals(actualColumnTitle,expectedTitle,"[ERR] Column Title incorrect");
        List<String> expectedLinkTexts = Arrays.asList(
                "Sitemap","Shipping & Returns","Privacy Notice","Conditions of Use","About us","Contact us"
        );
        List<String> expectedHrefs = Arrays.asList(
                "/sitemap","/shipping-returns","/privacy-policy","/conditions-of-use","/about-us","/contactus"
        );

        verifyColumnData(informationColumnComp,expectedLinkTexts,expectedHrefs);
    }

    private void verifyCustomerColumn(FooterComponent footerComponent) {
        CustomerColumnComponent customerColumnComp = footerComponent.customerColumnComp();

        String actualColumnTitle = customerColumnComp.headerElem().getText().trim();
        String expectedTitle = "CUSTOMER SERVICE";
        Assert.assertEquals(actualColumnTitle,expectedTitle,"[ERR] Column Title incorrect");
        List<String> expectedLinkTexts = Arrays.asList(
                "Search","News","Blog","Recently viewed products","Compare products list","New products"
        );
        List<String> expectedHrefs = Arrays.asList(
                "/search","/news","/blog","/recentlyviewedproducts","/compareproducts","/newproducts"
        );

        verifyColumnData(customerColumnComp,expectedLinkTexts,expectedHrefs);
    }

    private void verifyMyAccountColumn(FooterComponent footerComponent) {
        MyAccountColumnComponent myAccountColumnComp = footerComponent.myAccountColumnComp();

        String actualColumnTitle = myAccountColumnComp.headerElem().getText().trim();
        String expectedTitle = "MY ACCOUNT";
        Assert.assertEquals(actualColumnTitle,expectedTitle,"[ERR] Column Title incorrect");
        List<String> expectedLinkTexts = Arrays.asList(
                "My account","Orders","Addresses","Shopping cart","Wishlist"
        );
        List<String> expectedHrefs = Arrays.asList(
                "/login?ReturnUrl=%2fcustomer%2finfo","/login?ReturnUrl=%2fcustomer%2forders",
                "/login?ReturnUrl=%2fcustomer%2faddresses","/cart","/wishlist"
        );

        verifyColumnData(myAccountColumnComp,expectedLinkTexts,expectedHrefs);
    }

    private void verifyFollowUsColumn(FooterComponent footerComponent) {
        FollowUsColumnComponent followUsColumnComp = footerComponent.followUsColumnComp();

        String actualColumnTitle = followUsColumnComp.headerElem().getText().trim();
        String expectedTitle = "FOLLOW US";
        Assert.assertEquals(actualColumnTitle,expectedTitle,"[ERR] Column Title incorrect");
        List<String> expectedLinkTexts = Arrays.asList(
                "Facebook","Twitter","RSS","YouTube","Google+"
        );
        List<String> expectedHrefs = Arrays.asList(
                "https://www.facebook.com/nopCommerce",
                "https://twitter.com/nopCommerce",
                "/news/rss/1",
                "https://www.youtube.com/user/nopCommerce",
                "https://plus.google.com/+nopcommerce"
        );

        verifyColumnData(followUsColumnComp,expectedLinkTexts,expectedHrefs);
    }

    private void verifyColumnData(
            FooterColumnComponent footerColumnComp, List<String> expectedLinkTexts, List<String> expectedHrefs) {

        List<String> actualLinkTexts = new ArrayList<>();
        List<String> actualLinkHrefs = new ArrayList<>();

        for (WebElement link : footerColumnComp.linkElems()) {
            actualLinkTexts.add(link.getText().trim());
            actualLinkHrefs.add(link.getAttribute("href"));
        }
        if (actualLinkTexts.isEmpty() || actualLinkHrefs.isEmpty()){
            Assert.fail("[ERR]Text or hyperlink is empty");
        }

        //Link text verify
        Assert.assertTrue(actualLinkTexts.size() == expectedLinkTexts.size(),
                "[ERR] Text in footer is incorrect");
        //TODO: Search so sanh 2 list, hien tai chi so sanh 1 chieu
        for (String actualLinkText : actualLinkTexts) {
            System.out.println(actualLinkText);
            Assert.assertTrue(actualLinkTexts.contains(actualLinkText),"[ERR]" + actualLinkText + "is incorrect");
        }

        //Href verify
        Assert.assertTrue(actualLinkHrefs.size() == expectedHrefs.size(),
                "[ERR] Href in footer is incorrect");
        //TODO: Search so sanh 2 list, hien tai chi so sanh 1 chieu
        for (String actualLinkHref : actualLinkHrefs) {
            System.out.println(actualLinkHref);
            Assert.assertTrue(actualLinkHrefs.contains(actualLinkHref),"[ERR]" + actualLinkHref + "is incorrect");
        }

    }

    public void verifyProductCatFooterComponent() {
        //Random pickup an item
        HomePage homePage = new HomePage(driver);
        TopMenuComponent topMenuComponent = homePage.topMenuComp();

        List<MainCatItem> mainItemElem = topMenuComponent.mainItemElem();
        //TODO : Throw Err when mainItemElem is empty
        MainCatItem randomMainItemElem = mainItemElem.get(new SecureRandom().nextInt(mainItemElem.size()));
        String randomCatHref = randomMainItemElem.catItemLinkElem().getAttribute("href");

        //Get sublist
        List<CatItemComponent> catItemComps = randomMainItemElem.catItemComponents();

        //If mainItem has sublist click on random item
        if (catItemComps.isEmpty()) {
            randomMainItemElem.catItemLinkElem().click();
        } else {
            int randomIndex = new SecureRandom().nextInt(catItemComps.size());
            CatItemComponent randomCatItemComponent = catItemComps.get(randomIndex);
            randomCatHref = randomCatItemComponent.getComponent().getDomAttribute("href");
            randomCatItemComponent.getComponent().click();
        }


//            Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(randomCatHref));
        //Call verifyFooterComp
        verifyFooterComp();

    }
}
