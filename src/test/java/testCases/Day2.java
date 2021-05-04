package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.rmi.CORBA.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class Day2 extends base {
	AndroidDriver<AndroidElement> driver;
	private final String ACTIVITY = "com.vector.guru99.BaseActivity";
	private final String PACKAGE = "com.vector.guru99";
	Page1 page1 ;
	Utilities util;
	  ArrayList<String> allElementsText = new ArrayList<String>();
	
	@BeforeTest
	public void startup() throws IOException, InterruptedException {
	 driver = capabilities("vectorapp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page1 = new Page1(driver);
		util=new Utilities(driver);
	}

	@Test(enabled = true)
	public void test1() {
		driver.startActivity(new Activity(PACKAGE, ACTIVITY));
		/* verification1- Click on SAP from Course Category */
		if (page1.CourseCategory().isSelected()) {
			page1.CourseCategoryList().get(0).click();
		}
		else {
			page1.CourseCategory().click();
			page1.CourseCategoryList().get(0).click();
		}
		
	}
	@Test(enabled = true)
	public void test2() {
		/* verification 2- Child Elements count of SAP */
		int size=page1.CourseCategory_SAPList().size();
		System.out.println("Size of list: "+size);
		for(WebElement sapList: page1.CourseCategory_SAPList())
		{
			String text = sapList.getText();
			System.out.println(text);
		}
		
		page1.CourseCategory_SAPList().get(10).click();
		for(WebElement sapBIList: page1.SAP_BI_List())
		{
			String text = sapBIList.getText();
			//System.out.println(text);
			allElementsText.add(text);
		}
		do {
			util.scrollDown();
		} while (page1.SAP_BI_List().size()==22);
		for(WebElement sapBIList: page1.SAP_BI_List())
		{
			String text = sapBIList.getText();
			//System.out.println(text);
			allElementsText.add(text);
		}
		allElementsText = (ArrayList) allElementsText.stream().distinct().collect(Collectors.toList());
		for(String s : allElementsText)
		{
			System.out.println(s);
		}
	}
	@AfterClass
	public void teardown() {
		driver.closeApp();
	}
}
