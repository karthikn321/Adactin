package org.testclass;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.manager.PageManager;
import org.openqa.selenium.WebElement;
import org.page.HomePage;
import org.page.LoginPage;
import org.page.SelectHotelPage;
import org.testbase.BaseClass;

public class TC03_VerifySelectHotelPage extends BaseClass {
	public static PageManager pageManager;
	public static BaseClass baseClass;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static SelectHotelPage hotelPage;
	public static boolean isLoggedin = false;
	public static boolean isinHomepage = false;

	@BeforeClass
	public static void browserLaunch() throws IOException {
		// application setup- step:1 to 3
		pageManager = new PageManager();
		baseClass = pageManager.getBaseClass();

		baseClass.setup(baseClass.readExcel("setup", 1, 0), baseClass.readExcel("setup", 1, 1));
		// taking screenshot
		baseClass.captureScreen();
	}

	@Before
	public void loginHomeTest() throws IOException {
		try {

			loginPage = pageManager.getLoginPage();

			WebElement userName = loginPage.getUserName();
			baseClass.getSendKeys(userName, baseClass.readExcel("LoginData", 1, 0));

			WebElement password = loginPage.getPassword();
			baseClass.getSendKeys(password, baseClass.readExcel("LoginData", 1, 1));

			// click login button - step:9
			WebElement login = loginPage.getLogin();
			baseClass.performClick(login);
			try {
				loginPage = pageManager.getLoginPage();
				WebElement errorMsgEle = loginPage.getErrorMsgEle();
				if (errorMsgEle.isDisplayed()) {
					String capturedErrorText = baseClass.captureText(errorMsgEle);
					if (capturedErrorText.contains("Invalid Login details")) {
						isLoggedin = false;
					}
				}
			} catch (Exception e) {
				System.out.println("Successfully entered credentials");
				isLoggedin = true;
			}
			// homePage = pageManager.getHomePage();

			if (isLoggedin) {
				homePage = pageManager.getHomePage();
				WebElement homeEle = homePage.getHomeEle();
				if (homeEle.isDisplayed()) {
					System.out.println("Successfully Logged into website");

					// get search hotel text to console - step:11
					WebElement homeTextElement = homePage.getHomeTextElement();
					String captureText = baseClass.captureText(homeTextElement);
					System.out.println("Home Text:" + captureText);

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
					isinHomepage = true;
				} else {
					System.out.println("HomePage Element is not dispalyed...");
					isinHomepage = false;
				}
			} else {
				System.out.println("Login failed...Enter valid details..");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void selectHotelPage() {

		if (isinHomepage) {

			try {
				// Validate whether we have entered the Select Hotel page successfully - step:16
				hotelPage = pageManager.getSelectHotelPage();

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

				} else {
					System.out.println("Select Hotel Page is not displayed...");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Failed to identify select Hotel...");
		}
	}

	@After
	public void result() {
		if (isinHomepage) {
			System.out.println("Test Passed:TC03_VerifySelectHotelPage");
		} else {
			System.out.println("Test Skipped:TC03_VerifySelectHotelPage");
		}
	}

	@AfterClass
	public static void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();

	}

}
