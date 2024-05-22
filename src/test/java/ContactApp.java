import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.chromium.options.ChromiumOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

public class ContactApp {


    @Test
    public void testContactApp() throws MalformedURLException, InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options().setAppPackage("com.android.contacts")
                .setAppActivity("com.android.contacts.activities.PeopleActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        WebElement addContact = driver.findElement(By.id("com.android.contacts:id/floating_action_button_container"));
        addContact.click();
        Thread.sleep(5000);
        WebElement cancelButton = driver.findElement(By.id("com.android.contacts:id/left_button"));
        cancelButton.click();
        driver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Shital");
        driver.findElement(By.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Malviya");
        driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("+14405539697");
        driver.findElement(By.xpath("//android.widget.Spinner[@content-desc='Phone'][1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Mobile']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@text='SAVE']")).click();







    }
}
