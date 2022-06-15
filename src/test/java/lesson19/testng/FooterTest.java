package lesson19.testng;

import org.testng.annotations.*;

public class FooterTest {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("\t-->Before Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\t-->Before Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\t-->Before Method");
    }
    @Test
    public void testFooterHomePage(){
        System.out.println("Footer Test | Home page");
    }

    @Test
    public void testFooterCategoryPage(){
        System.out.println("Footer Test | Category page");

    }
}
