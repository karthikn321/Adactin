package org.testclass;

import java.io.IOException;

import org.manager.PageManager;
import org.openqa.selenium.WebElement;
import org.page.BookHotelPage;
import org.page.BookedItinearyPage;
import org.page.BookingConformPage;
import org.page.HomePage;
import org.page.LoginPage;
import org.page.LogoutPage;
import org.page.SelectHotelPage;
import org.testbase.BaseClass;

public class TestClass extends BaseClass {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		PageManager pageManager=new PageManager();
		// application setup- step:1 to 3
		//BaseClass baseClass = new BaseClass();
		BaseClass baseClass = pageManager.getBaseClass();
		System.out.println(System.identityHashCode(baseClass));
		
		baseClass.setup(baseClass.readExcel("setup", 1, 0), baseClass.readExcel("setup", 1, 1));
		// taking screenshot
		 baseClass.captureScreen();

		 
		 
		 
		 
		 
		 
		 
		 
		// validating login page successfully launched or not- step: 5 and 6
	//	LoginPage loginPage = new LoginPage();
		
		LoginPage loginPage = pageManager.getLoginPage();
		
		WebElement validateLogin = loginPage.validateLogin();
		if (validateLogin != null) {
			String actualText = baseClass.captureText(validateLogin);
			String expectedText = baseClass.readExcel("LoginData", 1, 2);

			if (actualText.equals(expectedText)) {
				System.out.println("Adactin Login Page Successfully Launched");
				System.out.println("Login Page Text:" + actualText);
			} else {
				System.out.println("Failed To Launch The Login Page...");
			}
		} else {
			System.out.println("Validate Login element is not present...");
		}

		// taking screenshot - step:7
		 baseClass.captureScreen();

		// Enter Login credentials - step:8
		WebElement userName = loginPage.getUserName();
		System.out.println(System.identityHashCode(userName));
		baseClass.getSendKeys(userName, baseClass.readExcel("LoginData", 1, 0));

		WebElement password = loginPage.getPassword();
		System.out.println(System.identityHashCode(password));
		baseClass.getSendKeys(password, baseClass.readExcel("LoginData", 1, 1));

		// click login button - step:9
		WebElement login = loginPage.getLogin();
		baseClass.performClick(login);

		System.out.println("====================================================");

		// validate successfully logged into website or not - step:10
		//HomePage homePage = new HomePage();
		HomePage homePage = pageManager.getHomePage();
		
		
		try {
			WebElement errorMsgEle = loginPage.getErrorMsgEle();
			if (errorMsgEle.isDisplayed()) {
				String capturedErrorText = baseClass.captureText(errorMsgEle);
				if (capturedErrorText.contains("Invalid Login details")) {
					System.out.println("Failed to logged into website...");
				} else {
					System.out.println("Failed logged in...");
				}
			}
		} catch (Exception e) {
			WebElement homeEle = homePage.getHomeEle();
			if (homeEle.isDisplayed()) {
				System.out.println("Successfully Logged into website");
				System.out.println("=====================================================");

				// get search hotel text to console - step:11
				WebElement homeTextElement = homePage.getHomeTextElement();
				String captureText = baseClass.captureText(homeTextElement);
				System.out.println(captureText);

				// take screenshot - step:12
				 baseClass.captureScreen();

				// Entering credentials to the search hotel - step:13
				WebElement location = homePage.getLocation();
				baseClass.getSelectOptions(location, "visibletext", baseClass.readExcel("HomePage", 1, 0));

				WebElement hotel = homePage.getHotel();
				baseClass.getSelectOptions(hotel, "visibletext", baseClass.readExcel("HomePage", 1, 1));

				WebElement roomType = homePage.getRoomType();
				baseClass.getSelectOptions(roomType, "visibletext", baseClass.readExcel("HomePage", 1, 2));

				WebElement rooms = homePage.getRooms();
				baseClass.getSelectOptions(rooms, "visibletext", baseClass.readExcel("HomePage", 1, 3));

				// enter details in dates - step:14
				WebElement checkInDate = homePage.getCheckInDate();
				checkInDate.clear();
				baseClass.getSendKeys(checkInDate, baseClass.readExcel("Homepage", 1, 4));

				WebElement checkOutDate = homePage.getCheckOutDate();
				checkOutDate.clear();
				baseClass.getSendKeys(checkOutDate, baseClass.readExcel("Homepage", 1, 5));

				WebElement adultRooms = homePage.getAdultRooms();
				baseClass.getSelectOptions(adultRooms, "visibletext", baseClass.readExcel("HomePage", 1, 6));

				WebElement childRooms = homePage.getChildRooms();
				baseClass.getSelectOptions(childRooms, "visibletext", baseClass.readExcel("HomePage", 1, 7));

				// click on search buttom - step:15
				WebElement clickSearchButton = homePage.clickSearchButton();
				baseClass.performClick(clickSearchButton);

				System.out.println("=====================================================");

				// Validate whether we have entered the Select Hotel page successfully - step:16
				//SelectHotelPage hotelPage = new SelectHotelPage();
				SelectHotelPage hotelPage = pageManager.getSelectHotelPage();
				
				try {
					WebElement validateSelectPage = hotelPage.validateSelectPage();

					if (validateSelectPage.isDisplayed()) {
						System.out.println("Successfully Entered into Select Hotel Page");
						// Get the Select Hotel text to the console - step:17
						String selectHotelText = baseClass.captureText(validateSelectPage);
						System.out.println("Hotel Page Text:" + selectHotelText);

						// take screenshot - step:18
						 baseClass.captureScreen();

						// Select the Hotel by clicking on radio button - step:19
						WebElement selectHotel = hotelPage.selectHotel();
						baseClass.performClick(selectHotel);

						// Click on Continue Button - step:20
						WebElement clickContinue = hotelPage.clickContinue();
						baseClass.performClick(clickContinue);

						System.out.println("=============================================");
						// Validate whether we are in Book A Hotel page -step:21
						//BookHotelPage bookHotel = new BookHotelPage();
						BookHotelPage bookHotel = pageManager.getBookHotelPage();
						
						try {
							WebElement validateBookHotel = bookHotel.validateBookHotel();

							if (validateBookHotel.isDisplayed()) {
								System.out.println("Successfully We are in Book a Hotel Page");
								String bookHotelText = baseClass.captureText(validateBookHotel);

								// Get the Book A Hotel text to the console -step:22
								System.out.println("Book Hotel Text:" + bookHotelText);

								// take screenshot - step:23
								 baseClass.captureScreen();

								// pass the values to mandatory fields -step:24
								WebElement firstName = bookHotel.getFirstName();
								baseClass.getSendKeys(firstName, baseClass.readExcel("BookPage", 2, 0));

								WebElement lastName = bookHotel.getLastName();
								baseClass.getSendKeys(lastName, baseClass.readExcel("BookPage", 2, 1));

								WebElement billingAddress = bookHotel.getBillingAddress();
								baseClass.getSendKeys(billingAddress, baseClass.readExcel("BookPage", 2, 2));

								WebElement creditCardNum = bookHotel.getCreditCardNum();
								baseClass.getSendKeys(creditCardNum, baseClass.readExcel("BookPage", 2, 3));

								// step:25

								WebElement creditCardType = bookHotel.getCreditCardType();
								baseClass.getSelectOptions(creditCardType, "visibletext",
										baseClass.readExcel("BookPage", 2, 4));

								WebElement month = bookHotel.getMonth();
								baseClass.getSelectOptions(month, "visibletext", baseClass.readExcel("BookPage", 2, 5));

								WebElement year = bookHotel.getYear();
								String excelDate = baseClass.readExcel("BookPage", 2, 6);
								double double1 = Double.parseDouble(excelDate);
								int date = (int) double1;
								String selDate = Integer.toString(date);

								baseClass.getSelectOptions(year, "visibletext", selDate);

								WebElement cvvNum = bookHotel.getCvvNum();
								baseClass.getSendKeys(cvvNum, baseClass.readExcel("BookPage", 2, 7));

								// click on book now button step:26
								WebElement clickBookNow = bookHotel.clickBookNow();
								baseClass.performClick(clickBookNow);

								System.out.println("=======================================================");
								// validate whether we are in Booking Confirmation Page step:27
								//BookingConformPage BookingConform = new BookingConformPage();
								BookingConformPage bookingConform = pageManager.getBookingConformPage();
								
								
								
								try {
									WebElement validateBooking = bookingConform.validateBooking();

									if (validateBooking.isDisplayed()) {
										System.out.println("Succesfully we are in Booking Page");
										// step:28
										String bookingText = baseClass.captureText(validateBooking);
										System.out.println("Booking Text:" + bookingText);

										// take screenshot - step:29
										 baseClass.captureScreen();

										WebElement orderNum = bookingConform.getOrderNum();
										String orderNumValue = baseClass.getAttributeValue(orderNum);

										// click on my Itineary - step:31
										WebElement clickItinearyBtn = bookingConform.clickItinearyBtn();
										baseClass.performClick(clickItinearyBtn);

										// step:32 select that booking
										//BookedItinearyPage itinearyPage = new BookedItinearyPage();
										BookedItinearyPage itinearyPage = pageManager.getBookedItinearyPage();
										
										
										WebElement searchOrderId = itinearyPage.getSearchOrderId();
										baseClass.getSendKeys(searchOrderId, orderNumValue);

										WebElement clickGoBtn = itinearyPage.clickGoBtn();
										baseClass.performClick(clickGoBtn);

										WebElement clickSelectedBooking = itinearyPage.clickSelectedBooking();
										baseClass.performClick(clickSelectedBooking);

										// click cancel button - step:33
										WebElement clickCancelBtn = itinearyPage.clickCancelBtn();
										baseClass.performClick(clickCancelBtn);
										// handle alert- step:34
										baseClass.handleAlerts("confirmalert");

										// take screen shot - step:35
										 baseClass.captureScreen();

										// click logout button - step:36
										WebElement clickLogoutBtn = itinearyPage.clickLogoutBtn();
										baseClass.performClick(clickLogoutBtn);

										// again click login button - step:37
										//LogoutPage logoutPage = new LogoutPage();
										LogoutPage logoutPage = pageManager.getLogoutPage();
										
										
										WebElement clickLoginBtn = logoutPage.clickLoginBtn();
										baseClass.performClick(clickLoginBtn);

										// take screnshot
										baseClass.captureScreen();

									} else {
										System.out.println("Failed to Enter in booking page...");
									}
								} catch (Exception t) {
									System.out.println("Failed to validate Booking page...");
								}

							} else {
								System.out.println("Failed to enter in Book a Hotel Page...");
							}
						} catch (Exception e3) {
							System.out.println("Failed to validate the Book a hotel page...");
						}

					} else {
						System.out.println("Failed to enter in Select Hotel Page...");
					}
				} catch (Exception e1) {
					System.out.println("Failed to validate the select hotel page...");
				}

			} else {
				System.out.println("Failed to logged into website....");
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
