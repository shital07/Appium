import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MobileGesture {

    AndroidDriver driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        getDriver();
    }

    private void getDriver() throws MalformedURLException {

        UiAutomator2Options capabilities = new UiAutomator2Options();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void tapOperation() {
        WebElement viewEle = driver.findElement(AppiumBy.accessibilityId("Views"));
        tap(viewEle);
    }

    @Test
    public void longPressOperation() {
        WebElement viewEle = driver.findElement(AppiumBy.accessibilityId("Views"));
        tap(viewEle);
        //WebElement expandableEle = driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));

        tapByCoordinates(500, 1350);
        WebElement adaptorEle = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']"));
        tap(adaptorEle);

        // Long Press 
        WebElement peopleEle = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPress(peopleEle);


    }

    @Test
    public void swipeOperation() {
        WebElement viewEle = driver.findElement(AppiumBy.accessibilityId("Views"));
        tap(viewEle);
        WebElement dateEle = driver.findElement(AppiumBy.accessibilityId("Date Widgets"));
        tap(dateEle);

        driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();

        WebElement ele1 = driver.findElement(AppiumBy.accessibilityId("3"));
        tap((ele1));
        WebElement source = driver.findElement(AppiumBy.accessibilityId("15"));
        WebElement target = driver.findElement(AppiumBy.accessibilityId("45"));

        swipe(source, target);

    }

    @Test
    public void dragNdropOperation() {

        WebElement viewEle = driver.findElement(AppiumBy.accessibilityId("Views"));
        tap(viewEle);
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = driver.findElement(By.xpath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']"));
        WebElement target = driver.findElement(By.xpath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']"));

        new TouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();

        String text =driver.findElement(By.xpath("//android.widget.TextView[@text='Dropped!']")).getText();
        Assert.assertEquals(text,"Dropped!");
    }

    private void swipe(WebElement source, WebElement target) {
        new TouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
    }

    private void longPress(WebElement peopleEle) {
        new TouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleEle))).perform();
    }

    private void tapByCoordinates(int x, int y) {
        new TouchAction(driver).tap(PointOption.point(x, y)).perform();
    }

    private void tap(WebElement viewEle) {
        TouchAction t = new TouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(viewEle))).perform();
    }


}
