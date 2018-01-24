package com.orange.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orange.tools.AbstractPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

import org.openqa.selenium.By;

import ru.yandex.qatools.allure.annotations.Step;

public class SaveSystemUsersPage extends AbstractPage {
	
	@FindBy(id = "systemUser_userType")
	private WebElement userRole;
	
	@FindBy(id = "systemUser_employeeName_empName")
	private WebElement inputEmployeeName;
	
	@FindBy(id = "systemUser_userName")
	private WebElement userName;
	
	@FindBy(id = "systemUser_status")
	private WebElement userStatus;
	
	@FindBy(id = "systemUser_password")
	private WebElement password;
	
	@FindBy(id = "systemUser_confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id = "btnSave")
	private WebElement buttonSave;

	private WebDriver driver;

	public SaveSystemUsersPage(WebDriver driver) {
		super(driver);
		new WebDriverWait(driver, 10).until(urlToBe
				("http://opensource.demo.orangehrmlive.com/index.php/admin/saveSystemUser"));
		PageFactory.initElements(driver, this);
				
	}
	@Step("Select User role")
	public void selectUserRole(int position) {
		Select select = new Select(driver.findElement(By.id("systemUser_userType")));
		select.selectByVisibleText("ESS");
	}
	
	@Step("Fill the 'User name' field")
	public void fillUserName() {
		userName.sendKeys("Teddy");
		}
	@Step("Fill the 'Employee name' field")
	public void fillEmployeeName() {
		userName.sendKeys("Jasmine Morgan");
		}
	 	
	@Step("Select User status")
	public void selectUserStatus(int position) {
		Select select = new Select(driver.findElement(By.id("systemUser_status")));
		select.selectByVisibleText("Enabled");
	}
	
	@Step("Fill the 'Password' field")
	public void fillUserPassword() {
		password.sendKeys("bear");
		}
	@Step("Confirm the 'User password' field")
	public void confirmUserPassword() {
		confirmPassword.sendKeys("bear");
		}
	@Step("Click the 'Save' button")
	public SystemUsersPage clickSaveButton() {
		buttonSave.click();
		return new SystemUsersPage(driver);
	}
	

}
