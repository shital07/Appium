package pages;

import com.appium.driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DynamicXpath;

import java.util.List;

public class HomePage extends BasePage {


    private final String xpath = "//android.widget.TextView[@content-desc='%s']";


    @AndroidFindBy(className = "android.widget.TextView")
    List<WebElement> menuItems;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public ViewLandingPage clickView(String menu) {

        String newPath = DynamicXpath.getXpath(xpath, menu);
        click("xpath", newPath, menu);
        return new ViewLandingPage();


    }

    public void clickMenuItem(String menu) {
        chooseItemAndClick(menuItems, menu);
    }
}
