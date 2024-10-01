package org.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testbase.BaseClass;

public class BookHotelPage extends BaseClass{

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	WebElement bookHotel;
	public WebElement validateBookHotel() {
		return bookHotel;
	}
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement txtFirstName;
	public WebElement getFirstName() {
		return txtFirstName;
	}
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement txtLastName;
	public WebElement getLastName() {
		return txtLastName;
	}
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement billAddress;
	public WebElement getBillingAddress() {
		return billAddress;
	}
	
	@FindBy(xpath="//input[@id='cc_num']")
	WebElement creditCardNum;
	public WebElement getCreditCardNum() {
		return creditCardNum;
	}
	
	@FindBy(xpath="//select[@id='cc_type']")
	WebElement creditCardType;
	public WebElement getCreditCardType() {
		return creditCardType;
	}
	
	@FindBy(xpath="//select[@id='cc_exp_month']")
	WebElement selMonth;
	public WebElement getMonth() {
		return selMonth;
	}
	
	@FindBy(xpath="//select[@name='cc_exp_year']")
	WebElement selYear;
	public WebElement getYear() {
		return selYear;
	}
	
	
	
	@FindBy(xpath="//input[@id='cc_cvv']")
	WebElement ccvNum;
	public WebElement getCvvNum() {
		return ccvNum;
	}
	
	@FindBy(xpath="//input[@id='book_now']")
	WebElement bookNowBtn;
	public WebElement clickBookNow() {
		return bookNowBtn;
	}
	
	
	
	
	

}
