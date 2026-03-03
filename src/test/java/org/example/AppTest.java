package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppTest {

        private AndroidDriver driver;

        @BeforeMethod
        public void setUp() throws MalformedURLException {
            // This is apk fetching from the file
            File f = new File("src/test/resources");
            File apk_proppinApp = new File(f, "app-release.apk");

            Capabilities options = new BaseOptions()
                    .amend("platformName", "android")
                    .amend("appium:automationName", "UiAutomator2")
                    .amend("appium:deviceName", "local")
                    .amend("appium:udid", "emulator-5554")
                    // this code below should be written when we uninstall an app and then dynamically install it
                    //.amend("app",apk_proppinApp.getAbsoluteFile())
                    .amend("appium:appPackage", "com.example.naseerghori22")
                    .amend("appium:appActivity", "com.example.naseerghori22.MainActivity")
                    .amend("appium:ensureWebviewsHavePages", true)
                    .amend("appium:nativeWebScreenshot", true)
                    .amend("appium:newCommandTimeout", 3600)
                    .amend("appium:connectHardwareKeyboard", true);
            URL remoteURL = new URL("http://127.0.0.1:4723");

            driver = new AndroidDriver(remoteURL, options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        public void sampleTest() throws InterruptedException {
            // using recorder code gen
            WebElement el1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(3)"));
            el1.click();
            WebElement el2 = driver.findElement(AppiumBy.accessibilityId("Sign Up"));
            el2.click();
            WebElement el3 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
            el3.sendKeys("Tajwar");
            WebElement el4 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Tajwar\")"));
            el4.click();
            WebElement el5 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
            el5.click();
            el5.sendKeys("Tajwar");
            WebElement el6 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
            el6.click();
            el6.sendKeys("volameh289@dolofan.com");
            WebElement el7 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
            el7.click();
            el7.sendKeys("01933954158");
            WebElement el8 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)"));
            el8.click();
            el8.sendKeys("volameh289@dolofan.com");
            WebElement el9 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"••••••••••••••••••••••\")"));
            el9.click();
            WebElement el10 = driver.findElement(AppiumBy.className("android.widget.ImageView"));
            el10.click();
            WebElement el11 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)"));
            el11.click();
            el11.sendKeys("12345678");
            WebElement el12 = driver.findElement(AppiumBy.className("android.widget.CheckBox"));
            el12.click();
            WebElement el13 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Sign Up\").instance(1)"));
            el13.click();
            Thread.sleep(5000);

            //for dropdown option selection this will be the line
            //WebElement nepalOption =driver.findElement(AppiumBy.androidUIAutomator("new UIScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Bangla\"))"))
            //nepalOption.click();
        }


        @AfterMethod
        public void tearDown() {
            // when app needs to get uninstalled use the below code:
            //driver.removeApp("com.example.naseerghori22");
            driver.quit();
        }

    }

