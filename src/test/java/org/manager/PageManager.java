package org.manager;

import org.page.BookHotelPage;
import org.page.BookedItinearyPage;
import org.page.BookingConformPage;
import org.page.HomePage;
import org.page.LoginPage;
import org.page.LogoutPage;
import org.page.SelectHotelPage;
import org.testbase.BaseClass;

public class PageManager extends BaseClass {

	private LoginPage loginPage;
	private HomePage homePage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConformPage bookingConformPage;
	private BookedItinearyPage bookedItinearyPage;
	private LogoutPage logoutPage;
	private BaseClass baseClass;
	
	public BaseClass getBaseClass() {
		return (baseClass == null) ? baseClass = new BaseClass() : baseClass;
	}
	
	
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage() : homePage;
	}

	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage == null) ? selectHotelPage = new SelectHotelPage() : selectHotelPage;
	}

	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage == null) ? bookHotelPage = new BookHotelPage() : bookHotelPage;
	}

	public BookingConformPage getBookingConformPage() {
		return (bookingConformPage == null) ? bookingConformPage = new BookingConformPage() : bookingConformPage;
	}

	public BookedItinearyPage getBookedItinearyPage() {
		return (bookedItinearyPage == null) ? bookedItinearyPage = new BookedItinearyPage() : bookedItinearyPage;
	}

	public LogoutPage getLogoutPage() {
		return (logoutPage == null) ? logoutPage = new LogoutPage() : logoutPage;
	}

}
