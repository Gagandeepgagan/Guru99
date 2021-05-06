package testCasesbyguru;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestCase1 {
	
	public static void main(String args[])
	{
		  AndroidDriver<AndroidElement> driver=null;
	DesiredCapabilities cap = new DesiredCapabilities();
	File app = new File(System.getProperty("user.dir")+"\\apk\\com.vector.guru99.apk");
		cap.setJavascriptEnabled(true);
		cap.setCapability("deviceName", "Nexus 5");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
		cap.setCapability("app", app);
		try {
			driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		} catch (MalformedURLException e) {
	 		e.printStackTrace();
		}
		
		//verification1- verify Guru99 header in the home page 
		if(driver.findElement(By.name("Guru99")).isDisplayed())
			System.out.println("guru99 header is displayed");
		else
			System.out.println("guru99 header is not displayed");
		
		//verification 2- is Course Category selected
		if(driver.findElement(By.name("Course Category")).isSelected())
			System.out.println("Course Category is currently selected");
		else
			System.out.println("Course Category is not selected");
		
		//Get all the courses listed in the course category
		
		//get all the courses and store them in a List
		List<AndroidElement> coursesOffered = driver.findElements(By.id("com.vector.guru99:id/lblListHeader"));
		
		//iterating the list to perform action on each webelement
		System.out.println("coourse offered are and their state ");
		for(WebElement course : coursesOffered)
		{
			String cours = course.getText();
			System.out.print(cours); //Print each course name
			if(course.isEnabled())
				System.out.print(" and it is enblaed");
			else
				System.out.print(" and it is not enalbed");
			System.out.println();
		
	}
		driver.quit();
	
	}
}
