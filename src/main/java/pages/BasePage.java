package pages;

import com.appium.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import reports.ExtentReport;
import reports.ExtentReportManager;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class BasePage {

    protected void click(WebElement ele, String eleName) {
        ele.click();
        ExtentReportManager.getTest().pass("Element is clicked - " + eleName);
    }

    protected void click(By by, String eleName) {
        click(DriverManager.getDriver().findElement(by), eleName);
    }

    protected void click(String locatorStrategy, String locator, String eleName) {

        if (locatorStrategy.equalsIgnoreCase("xpath")) {
            click(DriverManager.getDriver().findElement(By.xpath(locator)), eleName);
        } else if (locatorStrategy.equalsIgnoreCase("id")) {
            click(DriverManager.getDriver().findElement(By.id(locator)), eleName);
        }


    }

    protected void chooseItemAndClick(List<WebElement> list, String menu) {
        list.parallelStream().filter(e -> e.getText().contains(menu)).findFirst().ifPresent(WebElement::click);

    }

    protected void dragNDrop(WebElement source, WebElement target) {
        Point centerOfEle1 = getCenterOfEle(source);
        Point centerOfEle2 = getCenterOfEle(target);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence = new Sequence(finger1,1)
                .addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),centerOfEle1))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction( new Pause( finger1,Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(),centerOfEle2))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AndroidDriver)DriverManager.getDriver()).perform(Collections.singleton(sequence));
       ExtentReportManager.getTest().pass("Element is drag and drop to target - ");
    }

    protected Point getCenterOfEle(WebElement ele) {

        Point location = ele.getLocation();
        Dimension size = ele.getSize();

        return new Point(location.getX() + (size.getWidth() / 2), location.getY() + (size.getHeight() / 2));

    }

    protected String getText(WebElement element){
        return element.getText();
    }

    protected void tab(WebElement element){
        Point location = element.getLocation();
        Dimension size = element.getSize();

        int x = location.getX() + (size.getWidth() / 2);

        int y = location.getY() + (size.getHeight() / 2);

        Point point = new Point(x, y);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(2)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

       ((AppiumDriver) DriverManager.getDriver()).perform(Collections.singletonList(sequence));
    }


}
