package testCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClasses.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Page1;

public class Day1 extends base {


	Page1 page1 ;

	@BeforeTest
	public void startup() throws IOException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities("vectorapp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		page1 = new Page1(driver);
	}

	@Test(enabled = true)
	public void test1() {
		/* verification1- verify Guru99 header in the home page */

		String appName = page1.appname().getText();
		System.out.println(appName);
		Assert.assertEquals(appName, "Guru99");
	}
	@Test(enabled = true)
	public void test2() {
		/* verification 2- Course Category is displayed/selected/clickable */
		if (page1.CourseCategory().isDisplayed()&&page1.CourseCategory().isSelected()&&page1.CourseCategory().isEnabled())
			System.out.println("Course Category is Displayed/Selected/Clickable");
		else
			System.out.println("Course Category is not Displayed/Selected/Clickable");
	}
	@Test(enabled = true)
	public void test3() {
		 /*verification 3- Display content of course category in a List*/
		int size=page1.CourseCategoryList().size();
		System.out.println("Size of list: "+size);
		for (WebElement list : page1.CourseCategoryList()) {
			String course = list.getText();
			System.out.print(course); 
			
			 /*verification 4-  Course Category List is displayed/not selected/clickable*/
			if (list.isEnabled() &&  list.isDisplayed() && !list.isSelected())
				System.out.print(" and it is Displayed/ not Selected/ Clickable");
			else
				System.out.print(" and it is not Displayed/ not Selected/ Clickable");
			System.out.println();

		}
	}

	@AfterClass
	public void teardown() {
		driver.closeApp();
	}
}
