import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class Saucelab_Test {

    @Test
    public void test() throws MalformedURLException {
       /* UiAutomator2Options options = new UiAutomator2Options();
                //.setApp(System.getProperty("user.dir") + "/src/main/resources/apkfiles/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
*/

        MutableCapabilities capabilities = new UiAutomator2Options();
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='open menu']")).click();
        driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
        driver.findElement((AppiumBy.accessibilityId("Username input field"))).sendKeys("bob@example.com");
        driver.findElement((AppiumBy.accessibilityId("Password input field"))).sendKeys("10203040");
        driver.findElement((AppiumBy.accessibilityId("Login button"))).click();


    }

    @Test
    public void test2() throws MalformedURLException {
        MutableCapabilities capabilities = new UiAutomator2Options().withBrowserName("chrome");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='username']")));
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


    }

    @Test
    public void test3() throws MalformedURLException, InterruptedException {
        MutableCapabilities capabilities = new UiAutomator2Options();
                //.setApp(System.getProperty("user.dir") + "/src/main/resources/apkfiles/Android-MyDemoAppRN.1.3.0.build-244.apk");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='open menu']")).click();
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='container header']")).click();

        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("URL input field")).sendKeys("https://www.google.com");
       Thread.sleep(5000);
       driver.findElement(AppiumBy.accessibilityId("Go To Site button")).click();
        Set<String> contextHandles = driver.getContextHandles();
        for (String contextHandle : contextHandles) {
            System.out.println(contextHandle);
            if (contextHandle.equalsIgnoreCase("WEBVIEW_com.saucelabs.mydemoapp.rn")) {
                driver.context(contextHandle);
                break;
            }
        }

        driver.findElement(By.name("q")).sendKeys("appium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);




    }
    @Test
    public void test4() throws MalformedURLException {
            UiAutomator2Options options = new UiAutomator2Options()
                    .withBrowserName("Chrome");
            //

            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            driver.get("http://google.com");



        }

}
