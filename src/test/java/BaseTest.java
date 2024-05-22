import com.appium.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reports.ExtentReport;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class BaseTest {

    @BeforeSuite
    public void setUpBeforeSuit(){
        ExtentReport.initReport();
    }

    @BeforeMethod
    public void setUpTest(Method method) throws MalformedURLException {

        Driver.initDriver();
        ExtentReport.createTest(method.getName());

    }

    @AfterMethod
    public void tearDownTest() {
        Driver.quitDriver();
    }

    @AfterSuite
    public void setUpAfterSuit(){
        ExtentReport.flush();
    }
}
