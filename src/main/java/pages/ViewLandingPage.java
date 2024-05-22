package pages;

import com.appium.driver.DriverManager;
import org.openqa.selenium.By;
import utils.DynamicXpath;

public class ViewLandingPage {


    private  final String menuXpath="//android.widget.TextView[contains(@text,'%s')]";


    public  void clickMenuIntem(String menu) throws InterruptedException {
        Thread.sleep(5);
        String newXpath = DynamicXpath.getXpath(menuXpath,menu);
        DriverManager.getDriver().findElement(By.xpath(newXpath)).click();


    }
}
