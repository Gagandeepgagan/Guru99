package pageObjects;


import java.util.List;

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
	
	@AndroidFindBy(id = "android:id/action_bar_title")
	public WebElement appname;
	
	public WebElement appname() {
		return appname;
	}
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Course Category']")
	public WebElement CourseCategory;
	
	public WebElement CourseCategory() {
		return CourseCategory;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/lblListHeader")
	public List<WebElement> CourseCategoryList;
	
	public List<WebElement> CourseCategoryList() {
		return CourseCategoryList;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/lblListItem")
	public List<WebElement> CourseCategory_SAPList;
	
	public List<WebElement> CourseCategory_SAPList() {
		return CourseCategory_SAPList;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/heading_text")
	public List<WebElement> SAP_BI_List;
	
	public List<WebElement> SAP_BI_List() {
		return SAP_BI_List;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/action_quiz")
	public WebElement quiz;
	
	public WebElement quiz() {
		return quiz;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/timer")
	public WebElement quiz_timer;
	
	public WebElement quiz_timer() {
		return quiz_timer;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/question")
	public WebElement question;
	
	public WebElement question() {
		return question;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/option1")
	public WebElement answer1;
	
	public WebElement answer1() {
		return answer1;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/option2")
	public WebElement answer2;
	
	public WebElement answer2() {
		return answer2;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/next")
	public WebElement nextBtn;
	
	public WebElement nextBtn() {
		return nextBtn;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/finish")
	public WebElement finishBtn;
	
	public WebElement finishBtn() {
		return finishBtn;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/heading")
	public WebElement result;
	
	public WebElement result() {
		return result;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/score")
	public WebElement score;
	
	public WebElement score() {
		return score;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/action_interview")
	public WebElement interview;
	
	public WebElement interview() {
		return interview;
	}
	
	@AndroidFindBy(id = "com.vector.guru99:id/show_answer")
	public WebElement showAnswer;
	
	public WebElement showAnswer() {
		return showAnswer;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/lblinterviewItem")
	public List<WebElement> javaOptionsList;
	
	public List<WebElement> javaOptionsList() {
		return javaOptionsList;
	}
	@AndroidFindBy(id = "com.vector.guru99:id/interview_question")
	public WebElement interviewQues;
	
	public WebElement interviewQues() {
		return interviewQues;
	}@AndroidFindBy(id = "com.vector.guru99:id/interview_answer")
	public WebElement interviewAns;
	
	public WebElement interviewAns() {
		return interviewAns;
	}

}
