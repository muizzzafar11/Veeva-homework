package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarbCalculatorPage;

public class Test03_KatchFormula extends BaseTest {

    @Test
    public void testKatchMcArdleFormula() {
        driver.get("https://www.calculator.net/carbohydrate-calculator.html");

        CarbCalculatorPage page = new CarbCalculatorPage(driver);

        // Ensure US units tab is selected
        page.clickUsUnits();

        // Fill inputs
        page.enterAge("28");
        page.selectMale();
        page.enterHeight("6", "0");
        page.enterWeight("180");
        page.selectActivity("1.375"); // Light exercise

        // Open settings
        page.openSettings();

        // Switch formula
        page.selectKatchFormula();

        // Body fat%
        page.enterBodyFat("18");

        page.clickCalculate();

        Assert.assertTrue(
                page.isResultVisible(),
                "Result should be displayed for Katch-McArdle calculation"
        );
    }
}
