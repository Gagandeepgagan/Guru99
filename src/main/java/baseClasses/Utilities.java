package baseClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;;

public class Utilities {
	static AndroidDriver<AndroidElement> driver;

	public Utilities(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	public void pressBackButton() {
		driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}
	

	public void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}

	public void textCLick(String text) {
		driver.findElement(By.xpath("//*[@text=\"" + text + "\"]")).click();
	}

	// To sroll to a particular elemnet in Android
	public void scrollIntoView(String Text) {
		String mySelector = "new UiSelector().text(\"" + Text + "\").instance(0)";
		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + mySelector
				+ ");";
		driver.findElementByAndroidUIAutomator(command);

	}

	public  void scrollDown() {
		Dimension dimension = driver.manage().window().getSize();
		int scrollStart = (int) (dimension.getHeight() * 0.8);
		int scrollEnd = (int) (dimension.getHeight() * 0.2);

		TouchAction ta=	new TouchAction((PerformsTouchActions)driver).press(PointOption.point(0, scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollEnd))
				.release().perform();
	}

	
}
