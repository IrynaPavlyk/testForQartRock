package com.orange.app;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orange.tools.AbstractPage;

import ru.yandex.qatools.allure.annotations.Step;

public class OrangeDashboardPage extends AbstractPage{
	
	private WebDriver driver;
	
	@FindBy(id = "welcome")
	private WebElement text;
	
	@FindBy(id = "menu_admin_viewAdminModule")
	private WebElement tab_admin;
	
	
	public OrangeDashboardPage (WebDriver driver) {
		super(driver);
		new WebDriverWait(driver, 10).until(urlToBe("http://opensource.demo.orangehrmlive.com/index.php/dashboard"));
		PageFactory.initElements(driver, this);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
		
	@Step("Check if User name in message is correct")
	public String getTextWithUserName() {
		return text.getText();
	}
	
	@Step("Go to System Users Management page")
	public SystemUsersPage clickOnAdminTab() {
		tab_admin.click();
		return new SystemUsersPage(driver);
	}
	
}
