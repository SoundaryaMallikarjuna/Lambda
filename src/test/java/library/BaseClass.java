package library;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public static WebDriver driver;

	@BeforeMethod

	public void initializeBrowser() throws IOException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("dev");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "soundarya.mallikarjuna1996");
		ltOptions.put("accessKey", "LT_3WYFx5rWlZhd8nceL465gmCuoYjBGy55tkeozH4i3qC5YNC");
		ltOptions.put("project", "Untitled");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		browserOptions.setCapability("LT:Options", ltOptions);
		URL remoteUrl = new URL("https://hub.lambdatest.com/wd/hub");
	    driver = new RemoteWebDriver(remoteUrl, browserOptions);
	}
	@AfterMethod
	 
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit(); 
	        }

	}
}
