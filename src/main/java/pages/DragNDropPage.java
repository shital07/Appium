package pages;

import com.appium.driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DragNDropPage extends BasePage {


    @AndroidFindBy(xpath = "//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']")
    WebElement sourceEle;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']")
    WebElement targetEle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dropped!']")
    WebElement textEle;

    public DragNDropPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public DragNDropPage performDragNDrop() {
        dragNDrop(sourceEle, targetEle);
        System.out.println("Element is dropped");
        return this;
    }

    public String getTextToVerify(){
       return getText(textEle);
    }
}
