package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseClass{

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    By customerLogin = By.xpath("//button[@ng-click = \"customer()\"]");

    public void NavigateToSite() {
        Driver().navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

   public void Login(){
        findElementWithWait(customerLogin).click();
   }




}
