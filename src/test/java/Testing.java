import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class Testing {

    @Test
    public void tap() throws MalformedURLException {
        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setApp("/Users/megatron/Desktop/workspace_shital/Appium/ApiDemos-debug.apk");
        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), capabilities);

        WebElement viewEle = driver.findElement(AppiumBy.accessibilityId("Views"));

        Point location = viewEle.getLocation();
        Dimension size = viewEle.getSize();

        int x = location.getX() + (size.getWidth() / 2);

        int y = location.getY() + (size.getHeight() / 2);

        Point point = new Point(x, y);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1).addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point)).addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).addAction(new Pause(finger1, Duration.ofMillis(2))).addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));

    }

    @Test
    private void longPress() throws MalformedURLException {

        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setApp("/Users/megatron/Desktop/workspace_shital/Appium/ApiDemos-debug.apk");
        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), capabilities);


        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
        // Long Press
        WebElement peopleEle = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));


        new Actions(driver).clickAndHold(peopleEle).perform();


    }

    @Test
    public void dragNDrop() throws MalformedURLException {
        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setApp("/Users/megatron/Desktop/workspace_shital/Appium/ApiDemos-debug.apk");
        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), capabilities);

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement source = driver.findElement(By.xpath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']"));
        WebElement target = driver.findElement(By.xpath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']"));


        Point centerOfEle1 = getCenterOfEle(source);
        Point centerOfEle2 = getCenterOfEle(target);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),centerOfEle1))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction( new Pause( finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(),centerOfEle2))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singleton(sequence));



    }

    public Point getCenterOfEle(WebElement ele) {

        Point location = ele.getLocation();
        Dimension size = ele.getSize();

        return new Point(location.getX() + (size.getWidth() / 2), location.getY() + (size.getHeight() / 2));

    }

}
