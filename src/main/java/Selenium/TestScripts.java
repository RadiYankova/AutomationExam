package Selenium;

import org.junit.jupiter.api.Test;

public class TestScripts extends BaseTestClass{

    @Test
    public void LogInWebSite() throws InterruptedException {
        LoginPage loginStepOne = new LoginPage(driver, wait);
        loginStepOne.NavigateToSite();
        loginStepOne.Login();

        LoginPageTwo loginStepTwo= new LoginPageTwo(driver, wait);
        loginStepTwo.yourNameLogin("Harry Potter");

        DepositPage deposit = new DepositPage(driver,wait);

        deposit.successfulDeposit("1000");
        deposit.successfulDeposit("1000");

        deposit.assertDeposit("2000");


        var stop = 0;
    }
}
