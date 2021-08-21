package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

public class ExtentReportGeneration {

    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReporter;
    public static ExtentTest extentTest;

    public static void init_extentReport() {
        extentHtmlReporter = new ExtentHtmlReporter(new File(
                System.getProperty("user.dir") + "/target/cucumber/reports/ExtentReport_" + System.currentTimeMillis() + ".html"));
        extentReporter = new ExtentReports();
        extentReporter.attachReporter(extentHtmlReporter);
    }

    public static void create_extentTest(String testName) {
        extentTest = extentReporter.createTest(testName);
    }

    public static void generateExtentReport() {
        extentReporter.flush();
    }
}
