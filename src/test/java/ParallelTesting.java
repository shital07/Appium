import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ParallelTesting {


    @Test
    public void first() throws MalformedURLException {
        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setApp("/Users/megatron/Desktop/workspace_shital/Appium/ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        WebElement viewEle = driver.findElement(AppiumBy.accessibilityId("Views"));
        viewEle.click();
    }

    @Test
    public void second() throws MalformedURLException {
        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setApp("/Users/megatron/Desktop/workspace_shital/Appium/ApiDemos-debug.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4724"), capabilities);
        WebElement viewEle = driver.findElement(AppiumBy.accessibilityId("Views"));
        viewEle.click();
    }
}
