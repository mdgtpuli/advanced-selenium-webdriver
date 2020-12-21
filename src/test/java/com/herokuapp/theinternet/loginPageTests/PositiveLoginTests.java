package com.herokuapp.theinternet.loginPageTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting logIn test");


		// open main page
		String url = "http://the-internet.herokuapp.com/";
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openWelcomePage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// execute login
		SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// verifications
		SoftAssert soft = new SoftAssert();
		// new url
		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		soft.assertEquals(secureAreaPage.getCurrentUrl(), expectedUrl);

		// log out button is visible
		soft.assertTrue(secureAreaPage.islogoutButtonVisible(),
				"logOutButton is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessfulLoginMessageLocator();

		soft.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage));

		soft.assertAll();

	}
}
