package reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {

    private static ThreadLocal<ExtentTest> td = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return td.get();
    }

    public static void setTest(ExtentTest test) {

        td.set(test);
    }

    public static void unload() {
        td.remove();
    }


}
