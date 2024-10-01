package org.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.testclass.TC01_LoginPageValidation;
import org.testclass.TC02_VerifyHomePage;
import org.testclass.TC03_VerifySelectHotelPage;
import org.testclass.TC04_VerifyBookHotelPage;
import org.testclass.TC05_verifyBookingConfirmation;
import org.testclass.TC06_VerifyItinearyPage;

@RunWith(Suite.class)
@SuiteClasses({ TC01_LoginPageValidation.class, 
				TC02_VerifyHomePage.class, 
				TC03_VerifySelectHotelPage.class,
				TC04_VerifyBookHotelPage.class,
				TC05_verifyBookingConfirmation.class,
				TC06_VerifyItinearyPage.class})

public class TestRunnerClass {

}
