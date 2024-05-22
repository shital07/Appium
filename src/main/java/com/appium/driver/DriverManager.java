package com.appium.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public final class DriverManager {

    private DriverManager(){

    }

    private static ThreadLocal<WebDriver> td = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return td.get();
    }

    public static void setDriver(WebDriver driver) throws MalformedURLException {

        td.set(driver);
    }

    public static void unlock() {
        td.remove();
    }


}
