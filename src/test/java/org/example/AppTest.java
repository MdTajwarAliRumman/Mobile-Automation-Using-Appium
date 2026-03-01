package org.example;

import org.testng.annotations.BeforeMethod;

public class AppTest {
    // This sample code supports Appium Java client >=9
// https://github.com/appium/java-client
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

    public class SampleTest {

        private AndroidDriver driver;

        @BeforeEach
        public void setUp() {
            Capabilities options = new BaseOptions()
                    .amend("platformName", "android")
                    .amend("appium:automationName", "UiAutomator2")
                    .amend("appium:deviceName", "local")
                    .amend("appium:udid", "emulator-5554")
                    .amend("appium:appPackage", "com.example.naseerghori22")
                    .amend("appium:appActivity", "com.example.naseerghori22.MainActivity")
                    .amend("appium:ensureWebviewsHavePages", true)
                    .amend("appium:nativeWebScreenshot", true)
                    .amend("appium:newCommandTimeout", 3600)
                    .amend("appium:connectHardwareKeyboard", true);

            driver = new AndroidDriver(this.getUrl(), options);
        }

        @Test
        public void sampleTest() {

        }

        @AfterEach
        public void tearDown() {
            driver.quit();
        }

        private URL getUrl() {
            try {
                return new URL("http://127.0.0.1:4723");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
}
