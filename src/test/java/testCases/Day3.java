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

public class Day3 extends base {

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
		/* verification1- Interview exist and is clickable */
		if (page1.interview().isDisplayed()&&page1.interview().isEnabled()) {
			System.out.println("Interview exist and is clickable");
			page1.interview().click();
		}
		
		
		/* Select Java-Struts */
		util.scrollToText("JAVA");
		util.textCLick("JAVA");
		page1.javaOptionsList().get(0).click();
		
		/* verification 2- Answer is displayed */
		System.out.println(" Question :  "+ page1.interviewQues().getText());
		page1.showAnswer().click();
		if (page1.interviewAns().isDisplayed()) {
			System.out.println(" Answer :  "+ page1.interviewAns().getText());
		}else {
			System.out.println("Answer is not displayed");
		}
			
		/* Verification 3- Next question is displayed */
		page1.nextBtn().click();
		if (page1.interviewQues().isDisplayed()) {
			System.out.println(" Question :  "+ page1.interviewQues().getText());
		}else {
			System.out.println("Question is not displayed");
		}
		
	}
	@AfterClass
	public void teardown() {
		driver.closeApp();
	}
}
