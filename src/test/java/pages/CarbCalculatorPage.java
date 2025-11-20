package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CarbCalculatorPage {

    private WebDriver driver;

    public CarbCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===========================
    // ELEMENT LOCATORS
    // ===========================

    // US Units fields
    By age = By.name("cage");
    By heightFeet = By.id("cheightfeet");
    By heightInches = By.id("cheightinch");
    By weightLb = By.name("cpound");

    // Metric Units fields
    By heightCm = By.name("cheightmeter");
    By weightKg = By.name("ckg");

    // Body fat (for Katch-McArdle)
    By bodyFat = By.name("cfatpct");

    // Gender (we click the label, not input)
    By maleRadio = By.cssSelector("label[for='csex1']");
    By femaleRadio = By.cssSelector("label[for='csex2']");

    // Activity dropdown
    By activity = By.name("cactivity");

    // Buttons
    By calculateBtn = By.xpath("//input[@value='Calculate']");
    By result = By.className("h2result");

    // Tabs
    By usUnitsTab = By.linkText("US Units");
    By metricTab = By.linkText("Metric Units");

    // Settings
    By settings = By.xpath("//a[contains(text(),'Settings')]");
    By katchFormula = By.cssSelector("label[for='cformula2']");

    // ===========================
    // ACTION METHODS
    // ===========================

    public void clickUsUnits() {
        driver.findElement(usUnitsTab).click();
    }

    public void clickMetricUnits() {
        driver.findElement(metricTab).click();
    }

    public void enterAge(String value) {
        driver.findElement(age).clear();
        driver.findElement(age).sendKeys(value);
    }

    public void selectMale() {
        driver.findElement(maleRadio).click();
    }

    public void selectFemale() {
        driver.findElement(femaleRadio).click();
    }

    // ------ US Units ------
    public void enterHeight(String ft, String inch) {
        driver.findElement(heightFeet).clear();
        driver.findElement(heightFeet).sendKeys(ft);

        driver.findElement(heightInches).clear();
        driver.findElement(heightInches).sendKeys(inch);
    }

    public void enterWeight(String lbs) {
        driver.findElement(weightLb).clear();
        driver.findElement(weightLb).sendKeys(lbs);
    }

    // ------ Metric Units ------
    public void enterHeightCm(String value) {
        driver.findElement(heightCm).clear();
        driver.findElement(heightCm).sendKeys(value);
    }

    public void enterWeightKg(String value) {
        driver.findElement(weightKg).clear();
        driver.findElement(weightKg).sendKeys(value);
    }

    // ------ Shared ------
    public void selectActivity(String value) {
        new Select(driver.findElement(activity)).selectByValue(value);
    }

    public void clickCalculate() {
        driver.findElement(calculateBtn).click();
    }

    public boolean isResultVisible() {
        return driver.findElement(result).isDisplayed();
    }

    public void openSettings() {
        driver.findElement(settings).click();
    }

    public void selectKatchFormula() {
        driver.findElement(katchFormula).click();
    }

    public void enterBodyFat(String percent) {
        driver.findElement(bodyFat).clear();
        driver.findElement(bodyFat).sendKeys(percent);
    }
}
