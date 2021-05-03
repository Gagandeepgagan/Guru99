package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClasses.base;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Page;

public class TC extends base {
 
	private final String ACTIVITY = "com.guru99app.MainActivity";
	private final String PACKAGE = "com.guru99app";

	@BeforeTest
	public void startup() throws IOException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities("vectorapp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void AppNameExistOnScreen() {
		Page page1=new Page(driver);
		driver.startActivity(new Activity(PACKAGE, ACTIVITY));
		String appname = page1.appname().getText();
		System.out.println(appname);
		Assert.assertEquals(appname, "Guru99App");

	}

	@Test
	public void showtext() {
		Page page1=new Page(driver);
		page1.textbox().sendKeys("test");
		page1.showtextbtn().click();
		Assert.assertEquals("test", page1.textview().getText());
	}

	@AfterClass
	public void teardown() {
		driver.closeApp();
	}
}
