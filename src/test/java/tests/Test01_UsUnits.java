package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarbCalculatorPage;

public class Test01_UsUnits extends BaseTest {

    @Test
    public void testHappyPathUSUnits() throws InterruptedException {
        driver.get("https://www.calculator.net/carbohydrate-calculator.html");

        CarbCalculatorPage page = new CarbCalculatorPage(driver);

        page.clickUsUnits();
        page.enterAge("25");
        page.selectFemale();
        page.enterHeight("5", "10");
        page.enterWeight("160");
        page.selectActivity("1.2");
        page.clickCalculate();

        Assert.assertTrue(page.isResultVisible(),
                "Result should be displayed for a valid US unit calculation");
    }
}
