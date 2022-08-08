package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLogin extends BaseTest {
	@Test(dataProvider = "getData", priority = 1, groups = { "smoke" })
	public void testValidLogin(String un,String pw,String eTitle) {
		LoginPage login = new LoginPage(driver);
		test.info("Enter Valid User Name");
		Reporter.log("Enter Valid User Name",true);
		login.setUserName(un);
		test.info("Enter Valid Password");
		Reporter.log("Enter Valid Password",true);
		login.setPassword(pw);
		test.info("Click On Login Button");
		Reporter.log("Click On Login Button",true);
		login.clicLoginButton();
		EnterTimeTrackPage ett = new EnterTimeTrackPage(driver);
		Reporter.log("Verify HomePage Is Not Displayed",true);
		test.info("Verify HomePage Is Displayed");
		boolean result = ett.verifyPageTitle(wait, eTitle);
		Assert.assertTrue(result, "HomePage Is Not Displayed");
		Reporter.log("HomePage Is Not Displayed",true);
		test.pass("HomePage Is Displayed");
		Reporter.log("HomePage Is Displayed");
	}
}
