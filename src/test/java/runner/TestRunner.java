package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",glue = "stepsDefs",plugin={ "json:target/cucumber_report.json"})


public class TestRunner {
    @AfterClass
    public static void generateReports() {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber_report.json");
        //jsonFiles.add("cucumber-report-2.json");

        String buildNumber = "12122020";
        String projectName = "MIwebTableDemo";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }
}
