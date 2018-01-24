package com.orange.test;
import static com.orange.data.UserData.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orange.app.OrangeDashboardPage;
import com.orange.app.SaveSystemUsersPage;
import com.orange.app.SystemUsersPage;
import com.orange.data.User;

import ru.yandex.qatools.allure.annotations.Attachment;


public class LoginTest extends AbstractTest {

	private OrangeDashboardPage onOrangeDashboardPage;
	private SystemUsersPage onSystemUsersPage;
	private SaveSystemUsersPage onSaveSystemUsersPage;

	
	
		@Test(dataProvider = "testData")
		@Attachment("User login")
		public void testIfUserIsAbleToLogin(User user) {
			onOrangeDashboardPage = orangeHRM.openHomePage().loginAs(user);
			
			Assert.assertEquals(onOrangeDashboardPage.getCurrentUrl(), "http://opensource.demo.orangehrmlive.com/index.php/dashboard",
					"Incorrect URL after login");

			String actualText = onOrangeDashboardPage.getTextWithUserName();
			String expectedText = "Welcome " + user.getName();

			Assert.assertEquals(actualText, expectedText, "Name of " + user + "in the message is not correct");
		}


		@DataProvider(name = "testData")
		public static Object[][] testData() {
			return new Object[][] { { ADMIN_USER }, { CUSTOMER_USER }, {JASMINE}, {JOHN}};
		}
		@Test(dependsOnMethods = "testIfUserIsAbleToLogin")
		public void testAddNewUser() {

			onSystemUsersPage = onOrangeDashboardPage.clickOnAdminTab();
			int a = onSystemUsersPage.getSizebefore();
			onSaveSystemUsersPage = onSystemUsersPage.clickAddButton();
			onSaveSystemUsersPage.selectUserRole(2);
			onSaveSystemUsersPage.fillEmployeeName();
			onSaveSystemUsersPage.fillUserName();
			onSaveSystemUsersPage.selectUserStatus(1);
			onSaveSystemUsersPage.fillUserPassword();
			onSaveSystemUsersPage.confirmUserPassword();
			onSystemUsersPage = onSaveSystemUsersPage.clickSaveButton();
			int b = onSystemUsersPage.getSizeafter();
			int diff = b - a;
			Assert.assertTrue(diff == 1);
		}
		
		@AfterMethod(alwaysRun = true)
		public void tearDown() {
			orangeHRM.close();
		}
		
	}

