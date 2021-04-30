package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import baseClasses.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Page1 extends base{
	
	public Page1(AndroidDriver<AndroidElement> driver)
	{
		  this.driver = driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView")
	public WebElement appname;
	
	public WebElement appname() {
		System.out.println("appname");
		return appname;
	}
	@AndroidFindBy(id = "com.guru99app:id/edtText")
	public WebElement textbox;
	
	public WebElement textbox() {
		System.out.println("textbox");
		return textbox;
	}
	@AndroidFindBy(id = "com.guru99app:id/btnShow")
	public WebElement showtextbtn;
	
	public WebElement showtextbtn() {
		System.out.println("showtextbtn");
		return showtextbtn;
	}
	@AndroidFindBy(id = "com.guru99app:id/txtView")
	public WebElement textview;
	
	public WebElement textview() {
		System.out.println("textview");
		return textview;
	}
	
}
