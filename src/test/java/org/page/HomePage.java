package org.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testbase.BaseClass;

public class HomePage extends BaseClass{
	//constructor
		public HomePage() {
			PageFactory.initElements(driver, this);
		}

		
		@FindBy(xpath="//td[text()='Welcome to Adactin Group of Hotels']")
		WebElement homeEle;
		public WebElement getHomeEle() {
			return homeEle;
		}
		
		@FindBy(xpath="//td[text()='Search Hotel ']")
		WebElement hotelTextEle;
		public WebElement getHomeTextElement() {
			return hotelTextEle;
		}

		@FindBy(xpath="//select[@id='location']")
		WebElement sltLocation;
		public WebElement getLocation() {
			return sltLocation;
		}
		
		@FindBy(xpath="//select[@id='hotels']")
		WebElement  sltHotel;
		public WebElement getHotel() {
			return sltHotel;
		}
		
		@FindBy(xpath="//select[@id='room_type']")
		WebElement sltRoomType;
		public WebElement getRoomType() {
			return sltRoomType;
		}
		
		@FindBy(xpath="//select[@id='room_nos']")
		WebElement sltNoofRooms;
		public WebElement getRooms() {
			return sltNoofRooms;
		}
		
		@FindBy(xpath="//input[@id='datepick_in']")
		WebElement checkInDt;
		public WebElement getCheckInDate() {
			return checkInDt;
		}
		
		@FindBy(xpath="//input[@id='datepick_out']")
		WebElement checkOutDt;
		public WebElement getCheckOutDate() {
			return checkOutDt;
		}
		
		@FindBy(xpath="//select[@id='adult_room']")
		WebElement adultrooms;
		public WebElement getAdultRooms() {
			return adultrooms;
		}
		
		@FindBy(xpath="//select[@id='child_room']")
		WebElement childRooms;
		public WebElement getChildRooms() {
			return childRooms;
		}
		
		@FindBy(xpath="//input[@id='Submit']")
		WebElement searchBtn;
		public WebElement clickSearchButton() {
			return searchBtn;
		}
		
		
		
		
		
		
		
		
		
		
}
