package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CarbCalculatorPage;

public class Test02_MetricUnits extends BaseTest {

    @Test
    public void testMetricUnitsActiveUser() {
        driver.get("https://www.calculator.net/carbohydrate-calculator.html");

        CarbCalculatorPage page = new CarbCalculatorPage(driver);

        // Navigate to Metric Units
        page.clickMetricUnits();

        // Enter metric inputs
        page.enterAge("30");
        page.selectFemale();
        page.enterHeightCm("165");
        page.enterWeightKg("60");
        page.selectActivity("1.55");  // Active user

        page.clickCalculate();

        Assert.assertTrue(
                page.isResultVisible(),
                "Result should be displayed for valid Metric Unit calculation"
        );
    }
}
