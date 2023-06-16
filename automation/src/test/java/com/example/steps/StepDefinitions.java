package com.example.steps;

import com.example.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertTrue;

public class StepDefinitions {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        options.addArguments("--enable-notifications");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
    }

    @Given("open the MoneyCorp website")
    public void openMoneyCorpWebsite() {
        homePage.openMoneyCorpWebsite();
    }

    @When("change the language and region to {} {}")
    public void iChangeTheLanguageAndRegionTo(String language, String region) throws InterruptedException {
        homePage.changeLanguageAndRegion(language, region);
    }


    @Then("should be on the result page {}")
    public void iShouldBeOnTheResultPage(String region) throws InterruptedException {
        assertTrue(homePage.isResultPageDisplayed(region));
    }

    @When("I click on 'Find out more' for Foreign exchange solutions")
    public void clickFindOutMoreForForeignExchangeSolutions() throws InterruptedException {
        homePage.clickFindOutMoreForForeignExchangeSolutions();
    }

    @When("I search for the word {string}")
    public void searchForKeyword(String keyword) throws InterruptedException {
        homePage.searchForKeyword(keyword);
    }

    @Then("I close the browser")
    public void closeTheBrowser() {
        driver.quit();
    }

    @After
    public void tearDown() {
        // Quit the WebDriver instance after each scenario
        if (driver != null) {
            driver.quit();
        }
    }


    @Then("I should be on the result page")
    public void iShouldBeOnTheResultPage() {
    }
}
