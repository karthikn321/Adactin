package org.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testbase.BaseClass;

public class BookingConformPage extends BaseClass{
	public BookingConformPage() {
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	WebElement validateBookingPage;
	public WebElement validateBooking() {
		return validateBookingPage;
	}
	
	@FindBy(xpath="//input[@id='hotel_name']")
	WebElement hotelName;
	public WebElement getHotelName() {
		return hotelName;
	}
	
	@FindBy(xpath="//input[@id='location']")
	WebElement location;
	public WebElement getLocation() {
		return location;
	}
	
	@FindBy(xpath="//input[@id='room_type']")
	WebElement roomType;
	public WebElement getRoomType() {
		return roomType;
	}
	
	@FindBy(xpath="//input[@id='arrival_date']")
	WebElement arrivalDate;
	public WebElement getArrivalDate() {
		return arrivalDate;
	}
	
	@FindBy(xpath="//input[@id='departure_text']")
	WebElement departureDate;
	public WebElement getDepartureDate() {
		return departureDate;
	}
	
	@FindBy(xpath="//input[@id='order_no']")
	WebElement orderNo;
	public WebElement getOrderNum() {
		return orderNo;
	}
	
	
	@FindBy(xpath="//input[@id='my_itinerary']")
	WebElement itinearyBtn;
	public WebElement clickItinearyBtn() {
		return itinearyBtn;
	}
	
	
	
	
	
	
	
}
