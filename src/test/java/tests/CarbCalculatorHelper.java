package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarbCalculatorHelper {

    private final WebDriver driver;

    public CarbCalculatorHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://www.calculator.net/carbohydrate-calculator.html");
//        driver.manage().window().maximize();
    }

    public void clickUsUnits() {
        driver.findElement(By.linkText("US Units")).click();
    }

    public void clickMetricUnits() {
        driver.findElement(By.linkText("Metric Units")).click();
    }

    public void enterAge(String value) {
        driver.findElement(By.name("cage")).clear();
        driver.findElement(By.name("cage")).sendKeys(value);
    }

    public void selectMale() {
        driver.findElement(By.cssSelector("label[for='csex1']")).click();
    }

    public void selectFemale() {
        driver.findElement(By.cssSelector("label[for='csex2']")).click();
    }

    public void enterUSHeight(String ft, String inch) {
        driver.findElement(By.id("cheightfeet")).clear();
        driver.findElement(By.id("cheightfeet")).sendKeys(ft);

        driver.findElement(By.id("cheightinch")).clear();
        driver.findElement(By.id("cheightinch")).sendKeys(inch);
    }

    public void enterUSWeight(String lbs) {
        driver.findElement(By.name("cpound")).clear();
        driver.findElement(By.name("cpound")).sendKeys(lbs);
    }

    public void enterMetricHeight(String cm) {
        driver.findElement(By.id("cheightmeter")).clear();
        driver.findElement(By.id("cheightmeter")).sendKeys(cm);
    }

    public void enterMetricWeight(String kg) {
        driver.findElement(By.name("ckg")).clear();
        driver.findElement(By.name("ckg")).sendKeys(kg);
    }

    public void selectActivity(String value) {
        new Select(driver.findElement(By.name("cactivity"))).selectByValue(value);
    }

    public void openSettings() {
        driver.findElement(By.xpath("//a[contains(text(),'Settings')]")).click();
    }

    public void selectKatchFormula() {
        driver.findElement(By.cssSelector("label[for='cformula2']")).click();
    }

    public void enterBodyFat(String percent) {
        WebElement e = driver.findElement(By.name("cfatpct"));
        e.clear();
        e.sendKeys(percent);
    }

    public boolean isResultVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("h2result")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void clickCalculate() {
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
    }
}

