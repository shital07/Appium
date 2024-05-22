package com.appium.driver;

import org.openqa.selenium.WebDriver;
import utils.ReadConfig;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver() {

    }


    //Class should be closed for modification and open for extention
    //Factory Pattern

    public static void initDriver() throws MalformedURLException {
        String executionType = ReadConfig.getProperty("ExecutionType");
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriver driver = Diverfactory.get(DriverType.valueOf(executionType.toUpperCase()));
            DriverManager.setDriver(driver);
        }

    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unlock();
        }
    }

}
