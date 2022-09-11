package Cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StepDefinitions {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void SetUp(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath +"/src/main/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void TearDown(){
        driver.quit();
    }

    public WebElement findElementWithWait(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public List<WebElement> findElementsWithWait(By locator){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    @Given("User navigates to the web page")
    public void user_navigates_to_the_web_page() {
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Given("User clicks on Bank manager login")
    public void user_clicks_on_bank_manager_login() {
        WebElement loginButton = findElementWithWait(By.xpath("//button[@ng-click=\"manager()\"]"));
        loginButton.click();
    }
    @When("User selects Customers tab")
    public void user_selects_customers_tab() {
        findElementWithWait(By.xpath("//button[@ng-click=\"showCust()\"]")).click();
    }

    @Then("Delete one customer and confirm the number of customers in the list")
    public void delete_one_customer_and_confirm_the_number_of_customers_in_the_list() throws InterruptedException {
        List<WebElement> deleteButtons = findElementsWithWait(By.xpath("//button[contains(text(),'Delete')]"));
        int numOfCustomers;
        numOfCustomers =deleteButtons.size();
        deleteButtons.get(0).click();
        deleteButtons = findElementsWithWait(By.xpath("//button[contains(text(),'Delete')]"));
        Assert.assertTrue(numOfCustomers-1==deleteButtons.size());
    }

}
