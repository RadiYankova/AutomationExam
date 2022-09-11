package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageTwo extends BaseClass{

    public LoginPageTwo(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(10)));
    }

    By nameSelection = By.xpath("//select[@name= \"userSelect\"]");
    By secondLogin = By.xpath("//button[@class=\"btn btn-default\"]");

    public void yourNameLogin(String name){
        findElementWithWait(nameSelection).click();
        findElementWithWait(By.xpath("//*[contains(text(),'"+name+"')]")).click();
        findElementWithWait(secondLogin).click();

    }
}
