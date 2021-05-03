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

public class Day4 extends base {

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
		/* verification1- Quiz exist and is clickable */
		if (page1.quiz().isDisplayed()&&page1.quiz().isEnabled()) {
			System.out.println("Quiz exist and is clickable");
			page1.quiz().click();
		}
		util.scrollToText("Quality Center");
		util.textCLick("Quality Center");
		
		/* verification 2- Quix is opened and questions content is displayed */
		if (page1.quiz_timer().isDisplayed()) {
			System.out.println("Quiz is opened");
		}else {
			System.out.println("Quiz is not opened");	}
		
		/* verification 3- Questions content is displayed */
		
		/* Select correct answer and click next */
		System.out.println(" First Question :  "+ page1.question().getText());
		System.out.println("Time Remaining:  "+ page1.quiz_timer().getText());
		page1.answer2().click();
		page1.nextBtn().click();
		/* Select wrong answer and click finish */
		System.out.println("Second Question :  "+ page1.question().getText());
		System.out.println("Time Remaining:  "+page1.quiz_timer().getText());
		page1.answer1().click();
		page1.finishBtn().click();
		
		/* Verification 4- verify the scores displayed on Results Page */
		if(page1.result().isDisplayed())
		{
			System.out.println(" Test Results: "+page1.score().getText());
		}else {
			System.out.println("result not displayed.");
		}
		
	}
	@AfterClass
	public void teardown() {
		driver.closeApp();
	}
}
