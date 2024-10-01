package org.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testbase.BaseClass;

public class LoginPage extends BaseClass{
	
	//constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//td[@class='login_title']")
	WebElement loginValidation;
	public WebElement validateLogin() {
		return loginValidation;
	}
	
	@FindBy(xpath="//input[@id='username']")
	WebElement txtUserName;
	public WebElement getUserName() {
		return txtUserName;
	}
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	public WebElement getPassword() {
		return txtPassword;
	}
	
	@FindBy(xpath="//input[@id='login']")
	WebElement btnLogin;
	public WebElement getLogin() {
		return btnLogin;
	}
	
	@FindBy(xpath="//div[@class='auth_error']")
	WebElement errorMsgEle;
	public WebElement getErrorMsgEle() {
		return errorMsgEle;
	}
	
}
























