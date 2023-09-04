package testcase;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;
public class TC01 extends WebTestBase {
	LoginPage loginpage;
	HomePage homepage;
	MyAccountPage myAccountPage;
	public TC01()
	{
		super();
	}
	@BeforeMethod
	public void BeforeMethod()
	{
		//Loading the driver file and eatablishing the connection ,loading the url
	initialization();
	loginpage = new LoginPage();
	homepage=new HomePage();
	myAccountPage=new MyAccountPage();
	
}
//	@Test
//	public void check()
//	{
//		System.out.println("hii");
//	}
	
	@Test
	public void verifyLoginWithcrednt()
	{
		SoftAssert softAssert = new SoftAssert();
	     homepage.userSearchClick();
	     loginpage.login(prop.getProperty("mobile"), prop.getProperty("password"));
	System.out.println("verifyLogin");
	
	softAssert.assertEquals(myAccountPage.getTextOFMYAccountPage(), "My Account", "My Account text should be match");
    softAssert.assertAll();
	}
	
	@Test
	 public void verifyGetWindowHandle() throws InterruptedException{
	     SoftAssert softAssert = new SoftAssert();
	     myAccountPage.windowHandle();
	     softAssert.assertAll();
	 }
	
//	
	@Test
	public void verifySearchBar(){
	     SoftAssert softAssert = new SoftAssert();
	     myAccountPage.search();
	     System.out.println(myAccountPage.getTextOfSearch());
	     softAssert.assertEquals(myAccountPage.getTextOfSearch(), "Showing results for \"the power of your subconscious mind\"\n" +
	             "263 results found","Showing results for \"the power of your subconscious mind\"\n" +
	             "263 results found text should be match");
	     myAccountPage.selectDropDown("byVisibleText", "Best Seller");
	     softAssert.assertAll();
	 }
	@Test
	public void verifyMouseHover(){
	     SoftAssert softAssert = new SoftAssert();
	     myAccountPage.mouseHover();
	     softAssert.assertAll();
	 }
//	
	@Test
	 public void verifyScrollDown(){
	     SoftAssert softAssert = new SoftAssert();
	     myAccountPage.scrollDownMethod();
	     softAssert.assertAll();
	 }
//	@Test
//	 public void verifyGetWindowHandle() throws InterruptedException{
//	     SoftAssert softAssert = new SoftAssert();
//	     myAccountPage.windowHandle();
//	     softAssert.assertAll();
//	 }
//	
//	@Test
//	public void verifyCookiesHandle(){
//	     SoftAssert softAssert = new SoftAssert();
//	     myAccountPage.getCookiesHandle();
//	     softAssert.assertAll();
//	 }

	
	
	
	
//	@AfterMethod
//	 public void afterMethod(){
//	     driver.close();
//	 }
}
