package com.orange.app;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.orange.app.SaveSystemUsersPage;
import com.orange.tools.AbstractPage;

import ru.yandex.qatools.allure.annotations.Step;

public class SystemUsersPage extends AbstractPage {

	@FindBy(id = "btnAdd")
	private WebElement addButton;
	
	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr")
	private List<WebElement> trs;

	private WebDriver driver;

	public SystemUsersPage(WebDriver driver) {
		super(driver);
		new WebDriverWait(driver, 10).until(urlToBe("http://opensource.demo.orangehrmlive.com/index.php/admin/viewSystemUsers"));
		PageFactory.initElements(driver, this);
	}

	@Step("Click on 'Add' button")
	public SaveSystemUsersPage clickAddButton() {
		addButton.click();
		return new SaveSystemUsersPage(driver);
	}
	@Step
	public int getSizebefore() {
		int len1 = trs.size();
		return len1;		
	}
	@Step
	public int getSizeafter() {
		int len2 = trs.size();
		return len2;
	}

}
