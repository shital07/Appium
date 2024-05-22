package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import contants.FrameworkContants;

import java.util.Objects;

public class ExtentReport {


    private ExtentReport() {

    }

    public static ExtentReports report;

    public static void initReport() {

        if (Objects.isNull(report)) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkContants.getInstance().getReportPath());
            sparkReporter.config().setReportName("Appium Project Report");
            sparkReporter.config().setDocumentTitle("Automation Report");

            report = new ExtentReports();
            report.attachReporter(sparkReporter);
        }


    }

    public static void flush() {
        if (Objects.nonNull(report)) {
            report.flush();
        }
    }

    public static void createTest(String methodName) {
        ExtentReportManager.setTest(report.createTest(methodName));
    }

}
