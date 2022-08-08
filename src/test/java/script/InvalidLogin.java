package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(dataProvider = "getData", priority = 2, groups = { "smoke" })
	public void testInValidLogin(String un,String pw) {
		LoginPage loginpage = new LoginPage(driver);
		test.info("Enter The User Name");
		Reporter.log("Enter The User Name",true);
		loginpage.setUserName(un);
		test.info("Enter The Password");
		Reporter.log("Enter The Password",true);
		loginpage.setPassword(pw);
		test.info("Click On Login Button");
		Reporter.log("Click On Login Button");
		loginpage.clicLoginButton();
		test.info("Verify Error Message Is Displayed");
		Reporter.log("Verify Error Message Is Displayed",true);
		boolean result = loginpage.verifyErrMsgDisplayed(wait);
		Assert.assertTrue(result, "Error Message Is Not Displayed");
		Reporter.log("Error Message Is Not Displayed",true);
		test.pass("ErrorMessage Is Displayed");
		Reporter.log("ErrorMessage Is Displayed",true);

	}
}
