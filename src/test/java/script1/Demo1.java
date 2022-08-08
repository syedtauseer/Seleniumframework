/*
 * package script1;
 * 
 * import org.testng.Assert; import org.testng.Reporter; import
 * org.testng.annotations.Test;
 * 
 * 
 * 
 * public class Demo1 {
 * 
 * @Test public void test1() { String title = driver.getTitle();
 * Reporter.log(title, true); int rc = Utility.getXlRowCoutn(DATA_PATH,
 * "Test1"); for (int i = 1; i <= rc; i++) { String un =
 * Utility.getXLData(DATA_PATH, "Test1", i, 0); Reporter.log(un, true); String
 * pw = Utility.getXLData(DATA_PATH, "Test1", i, 1); Reporter.log(pw, true); }
 * Assert.assertEquals("Abcd", "null"); } }
 */