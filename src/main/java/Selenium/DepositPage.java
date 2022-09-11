package Selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DepositPage extends BaseClass{

    public DepositPage(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }
    By depositTab = By.xpath("//button[@ng-click=\"deposit()\"]");
    By amountField = By.xpath("//input[@placeholder=\"amount\"]");
    By depositButton = By.xpath("//button[@class =\"btn btn-default\"]");

    public void successfulDeposit(String depositAmount) {
        findElementWithWait(depositTab).click();
        findElementWithWait(amountField).sendKeys(depositAmount);
        findElementWithWait(depositButton).click();
    }
    public void assertDeposit(String expectedAmount){
        List<WebElement> accountDetails = driver.findElements(By.className("ng-binding"));
        String actualAmount = accountDetails.get(2).getText();
        Assert.assertEquals(expectedAmount,actualAmount);
    }


}
