package testCases;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.aop.framework.autoproxy.target.QuickTargetSourceCreator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClasses.Utilities;
import baseClasses.base;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Page1;

public class Day5 extends base {

	private final String ACTIVITY = "com.vector.guru99.BaseActivity";
	private final String PACKAGE = "com.vector.guru99";
	Page1 page1 ;
	Utilities util;
	
	@BeforeTest
	public void startup() throws IOException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities("vectorapp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page1 = new Page1(driver);
		util=new Utilities(driver);
	}

	@Test(enabled = true)
	public void test1() {
		driver.startActivity(new Activity(PACKAGE, ACTIVITY));
		/* click on  CourseList*/
		page1.CourseList().click();
		
		
		/* Select PHP */
		util.scrollToText("PHP");
		util.textCLick("PHP");
		/* Click on Lesson1 */
		page1.SAP_BI_List().get(0).click();
		
		/* verification 1- verify title of lesson1*/
		if (page1.LessonTitle().isDisplayed()) {
			System.out.println(" Title of Lesson 1 :  "+ page1.LessonTitle().getText());
			Assert.assertEquals(page1.LessonTitle().getText(), "What is PHP? Write your first PHP Program");
		}else {
			System.out.println("Title is not displayed");
		}
		/* Click on next button */
		
		page1.nextBtn();
		/* Verification 2-verify title of lesson2 */
		page1.nextBtn().click();
		if (page1.LessonTitle().isDisplayed()) {
			System.out.println(" Title of Lesson 2 :  "+ page1.LessonTitle().getText());
		}else {
			System.out.println("Title is not displayed");
		}
		
	}
	@AfterClass
	public void teardown() {
		driver.closeApp();
	}
}
