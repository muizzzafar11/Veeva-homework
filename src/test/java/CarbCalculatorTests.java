import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarbCalculatorTests {

    @Test
    public void test01_USUnitsHappyPath() {
        WebDriver driver = new ChromeDriver();
        CarbCalculatorHelper page = new CarbCalculatorHelper(driver);

        try {
            page.openPage();
            page.clickUsUnits();

            page.enterAge("25");
            page.selectMale();
            page.enterUSHeight("5", "10");
            page.enterUSWeight("160");
            page.selectActivity("1.2");

            page.clickCalculate();

            Assert.assertTrue(page.isResultVisible());

        } finally {
            driver.quit();
        }
    }

    @Test
    public void test02_MetricUnitsHappyPath() {
        WebDriver driver = new ChromeDriver();
        CarbCalculatorHelper page = new CarbCalculatorHelper(driver);

        try {
            page.openPage();
            page.clickMetricUnits();

            page.enterAge("30");
            page.selectFemale();
            page.enterMetricHeight("170");
            page.enterMetricWeight("60");
            page.selectActivity("1.55");

            page.clickCalculate();

            Assert.assertTrue(page.isResultVisible());

        } finally {
            driver.quit();
        }
    }

    @Test
    public void test03_KatchMcArdleFormula() {
        WebDriver driver = new ChromeDriver();
        CarbCalculatorHelper page = new CarbCalculatorHelper(driver);

        try {
            page.openPage();
            page.clickUsUnits();

            page.enterAge("28");
            page.selectMale();
            page.enterUSHeight("6", "0");
            page.enterUSWeight("180");
            page.selectActivity("1.375");

            page.openSettings();
            page.selectKatchFormula();
            page.enterBodyFat("18");

            page.clickCalculate();

            Assert.assertTrue(page.isResultVisible());

        } finally {
            driver.quit();
        }
    }
}

