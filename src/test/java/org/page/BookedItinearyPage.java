package org.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testbase.BaseClass;

public class BookedItinearyPage extends BaseClass {
	public BookedItinearyPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='order_id_text']")
	WebElement searchOrderId;
	public WebElement getSearchOrderId() {
		return searchOrderId;
	}

	@FindBy(xpath="//input[@id='search_hotel_id']")
	WebElement goBtn;
	public WebElement clickGoBtn() {
		return goBtn;
	}
	
	@FindBy(xpath="//input[@name='ids[]']")
	WebElement selectBooking;
	public WebElement clickSelectedBooking() {
		return selectBooking;
	}
	
	@FindBy(xpath="//input[@name='cancelall']")
	WebElement selectedCancell;
	public WebElement clickCancelBtn() {
		return selectedCancell;
	}
	
	@FindBy(xpath="//input[@id='logout']")
	WebElement logoutBtn;
	public WebElement clickLogoutBtn() {
		return logoutBtn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
