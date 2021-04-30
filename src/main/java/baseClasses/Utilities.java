package baseClasses;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;;

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



	
}
