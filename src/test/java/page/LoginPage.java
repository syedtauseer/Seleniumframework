package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	@FindBy(id = "username")
	public WebElement unTB;

	@FindBy(name = "pwd")
	public WebElement pwTB;

	@FindBy(xpath = "//div[text()='Login ']")
	public WebElement loginBTN;

	@FindBy(xpath = "//span[contains(.,'invalid')]")
	private WebElement errMsg;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String un) {
		unTB.sendKeys(un);
	}

	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}

	public void clicLoginButton() {
		loginBTN.click();
	}

	public boolean verifyErrMsgDisplayed(WebDriverWait wait) {

		try {
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
