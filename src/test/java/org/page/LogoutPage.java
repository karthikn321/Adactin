package org.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testbase.BaseClass;

public class LogoutPage extends BaseClass{
	
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[text()='Click here to login again']")
	WebElement loginBtn;
	public WebElement clickLoginBtn() {
		return loginBtn;
	}

}
