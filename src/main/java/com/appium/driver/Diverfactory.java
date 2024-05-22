package com.appium.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public final class Diverfactory {

    private Diverfactory() {

    }

    public static WebDriver get(DriverType type) throws MalformedURLException {
        WebDriver driver = null;
        if (type.equals(DriverType.LOCAL)) {
            driver = new LocalDriverImpl().getDriver();
        } else if (type.equals(DriverType.REMOTE)) {
            driver = new RemoteDriverImpl().getDriver();
        }
        return driver;
    }

}
