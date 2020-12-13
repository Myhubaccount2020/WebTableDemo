package stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DemoWebTablePage;

import java.util.concurrent.TimeUnit;

public class DemoWebTableSteps {
   public  static WebDriver driver;

    DemoWebTablePage demoWebTablePage ;

    @Given("user enter the url for the demo practice website")
    public void user_enter_the_url_for_the_demo_practice_website() {
          System.setProperty("webdriver.chrome.driver","c:\\Drivers\\chromedriver.exe");
          driver=new ChromeDriver();
         // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          driver.navigate().to("https://www.techlistic.com/p/demo-selenium-practice.html");
          driver.manage().window().maximize();

    }

    @Then("user should land on the demo web table page")
      public void user_should_land_on_the_demo_web_table_page() {
        demoWebTablePage = new DemoWebTablePage(driver);
          Assert.assertTrue(demoWebTablePage.checkWebelementIsvisible());

    }


    @Then("verify that the number of structure values")
    public void verifyThatTheNumberOfStructureValues() {
        Assert.assertTrue(demoWebTablePage.numOfStructureValues()==4);

    }

    @And("verify that the number of structure values equal to the total")
    public void verifyThatTheNumberOfStructureValuesEqualToTheTotal() {
        Assert.assertEquals(demoWebTablePage.total(), demoWebTablePage.numOfStructureValues());
    }

    @And("Read the values of the table")
    public void readTheValuesOfTheTable() {
        demoWebTablePage.readValues();

    }

    @And("verify that the last row has only two columns")
    public void verifyThatTheLastRowHasOnlyTwoColumns() {
        Assert.assertTrue(demoWebTablePage.lastRowColumns()==2);
    }
}
