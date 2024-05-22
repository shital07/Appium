import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BrowserStack {
    @Test
    public void testOnBS() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .withBrowserName("Chrome")
                .chromedriverUseSystemExecutable()
                .autoWebview();
        //

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.get("http://google.com");




    }
}
