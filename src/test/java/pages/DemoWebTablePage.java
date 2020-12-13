package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DemoWebTablePage {
    WebDriver driver;


    public DemoWebTablePage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean checkWebelementIsvisible() {
        return driver.findElement(By.xpath("//a[text()='Home']")).isDisplayed();
    }

    public int numOfStructureValues() {
        List<WebElement> structure = driver.findElements(By.xpath("//table[contains(@class,'tsc_table')]/tbody/tr"));
        return structure.size();
    }

    public int total() {
        WebElement tot = driver.findElement(By.xpath("//table/tfoot/tr/td"));
        // String stotal = tot.getText().substring(0,1);
        String stotal = tot.getText().replace(" buildings", "");
        int totalNum = Integer.parseInt(stotal);
        return totalNum;
    }

    public void readValues() {
        List<WebElement> values = driver.findElements(By.xpath("//table[contains(@class,'tsc_table')]"));
        for (WebElement val : values) {
            System.out.println(val.getText());
        }
    }

    public void readAs2Darray() {
        int numrows = driver.findElements(By.xpath("//table[contains(@class,'tsc_table')]/tbody/tr")).size();
        int numcolumns = driver.findElements(By.xpath("//table[contains(@class,'tsc_table')]/tbody/tr[1]/td")).size();
        for (int i = 1; i <= numrows; i++) {
            for (int j = 1; j <= numcolumns; j++) {
                System.out.print(driver.findElement(By.xpath("//table[contains(@class,'tsc_table')]/tbody/tr[" + i + "]/td[" + j + "]")).getText() + " ");
            }
            System.out.println();
        }
    }

    public int lastRowColumns() {
        return  driver.findElements(By.xpath("//table[contains(@class,'tsc_table')]/tfoot/tr/*")).size();

    }
}
