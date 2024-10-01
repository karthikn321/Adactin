package org.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testbase.BaseClass;

public class SelectHotelPage extends BaseClass{
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//td[text()='Select Hotel ']")
	WebElement selectHotelPage;
	public WebElement validateSelectPage() {
		return selectHotelPage;
	}
	
	
	@FindBy(xpath="//input[@id='radiobutton_0']")
	WebElement clickRadioBtn;
	public WebElement selectHotel() {
		return clickRadioBtn;
	}
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	public WebElement clickContinue() {
		return continueBtn;
	}
	
	
	
}
