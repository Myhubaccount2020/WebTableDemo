package stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DemoWebTablePage;

import java.util.List;
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


    @And("verify the height of buj khalifa")
    public void verifyTheHeightOfBujKhalifa() {
       // Assert.assertEquals("829m",demoWebTablePage.heightofBurjkhalifa());
        List<WebElement> rowheaders = driver.findElements(By.xpath("//table[contains(@class,'tsc_table')]/tbody/tr/th"));
        List<WebElement> columnheaders = driver.findElements(By.xpath("//table[contains(@class,'tsc_table')]/thead/tr/th"));
        int j = 0;
        for (int i =0;i<columnheaders.size();i++) {
            String colheader = columnheaders.get(i).getText();
            if (colheader.equals("Height")){
                j = i;
            }
        }

        for (int i =0;i<rowheaders.size();i++){
            String rowheader = rowheaders.get(i).getText();
            String height = driver.findElement(By.xpath("//table[contains(@class,'tsc_table')]/tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
            switch (rowheader){
                case "Burj Khalifa":
                    System.out.println(height);
                    Assert.assertEquals("829m",height);
                    break;
                case "Clock Tower Hotel":
                    System.out.println(height);
                    Assert.assertTrue(height.equals("601m"));
                    break;
                case "Taipei 101":
                    System.out.println(height);
                    Assert.assertTrue(height.equals("509m"));
                    break;
                case "Financial Center":
                    System.out.println(height);
                    Assert.assertEquals("492m",height);
                    break;
                default:
                    System.out.println("Structure not found");


            }


        }


    }
}
