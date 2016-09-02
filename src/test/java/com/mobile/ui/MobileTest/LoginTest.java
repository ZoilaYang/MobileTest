package com.mobile.ui.MobileTest;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class LoginTest {
	private AndroidDriver  driver;
	private File classpathRoot = new File(System.getProperty("user.dir"));
	private File appDir = new File(classpathRoot, "./apps");
	private File app = new File(appDir, "baidu.apk");   
	
	@BeforeMethod
	public void setUp() throws Exception {
 
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
        capabilities.setCapability("deviceName", "UCYSMZQOGUGARCVC");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.baidu.searchbox");
        capabilities.setCapability("appWaitActivity", ".MainActivity");

        try {

        	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
        	
            e.printStackTrace();
            
        }
	}
	
	 @Test
	 public void Test(){
	   System.out.println(driver.isAppInstalled("com.baidu.searchbox"));
       WebElement login_entrance = driver.findElementById("home_login_entrance");
       login_entrance.click();
       WebElement baidu_login_button = driver.findElementById("baidu_login_button");
       baidu_login_button.click();
       List<WebElement> account_text_input = driver.findElementsByClassName("android.widget.EditText");
       account_text_input.get(0).sendKeys("This is a test");
//       WebElement login_button = driver.findElementById("login_button");
//       login_button.click();
       
	 }
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

}
