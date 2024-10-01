package org.testclass;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.manager.PageManager;
import org.openqa.selenium.WebElement;
import org.page.HomePage;
import org.page.LoginPage;
import org.testbase.BaseClass;

public class TC01_LoginPageValidation extends BaseClass {
	public static PageManager pageManager;
	public static BaseClass baseClass;
	public static LoginPage loginPage;

	@BeforeClass
	public static void browserLaunch() throws IOException {
		// application setup- step:1 to 3
		pageManager = new PageManager();
		baseClass= pageManager.getBaseClass();
		baseClass.setup(baseClass.readExcel("setup", 1, 0), baseClass.readExcel("setup", 1, 1));
		// taking screenshot
		baseClass.captureScreen();
	}

	@Before
	public void loginValidation() throws IOException {

		try {
			loginPage = pageManager.getLoginPage();
			// validating login page successfully launched or not- step: 5 and 6

			WebElement validateLogin = loginPage.validateLogin();
			if (validateLogin.isDisplayed()) {
				String actualText = baseClass.captureText(validateLogin);
				String expectedText = baseClass.readExcel("LoginData", 1, 2);

				if (actualText.equals(expectedText)) {
					//System.out.println("Adactin Login Page Successfully Launched");
					baseClass.excelReport("Logindata", 2, 3, "PASS");
					System.out.println("Login Page Text:" + actualText);
				} else {
					//System.out.println("Failed To Launch The Login Page...");
					baseClass.excelReport("Logindata", 2, 4, "Fail");
				}
			} else {
				System.out.println("Validate Login element is not present...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void enteringLoginCredentials() throws IOException {
		try {
			loginPage = pageManager.getLoginPage();
			// taking screenshot - step:7
			baseClass.captureScreen();

			// Enter Login credentials - step:8
			WebElement userName = loginPage.getUserName();
			baseClass.getSendKeys(userName, baseClass.readExcel("LoginData", 1, 0));

			WebElement password = loginPage.getPassword();
			baseClass.getSendKeys(password, baseClass.readExcel("LoginData", 1, 1));

			// click login button - step:9
			WebElement login = loginPage.getLogin();
			baseClass.performClick(login);

			try {
				WebElement errorMsgEle = loginPage.getErrorMsgEle();
				if (errorMsgEle.isDisplayed()) {
					String capturedErrorText = baseClass.captureText(errorMsgEle);
					if (capturedErrorText.contains("Invalid Login details")) {
						System.out.println("Failed:TC01_LoginPageValidation");
					} else {
						System.out.println("Failed loginValidation in...");
					}
				}
			} catch (Exception e) {
				System.out.println("Test Passed:TC01_LoginPageValidation");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
