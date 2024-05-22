package com.appium.driver;

import contants.FrameworkContants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriverImpl implements IDriver{
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        UiAutomator2Options capabilities = new UiAutomator2Options();
        capabilities.setApp(FrameworkContants.getInstance().getApkFilePath());
        return new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }
}
