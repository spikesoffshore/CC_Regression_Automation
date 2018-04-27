package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.DriverUtil;
import utils.Loggers;
import utils.ReportGenerator;
import utils.WebPageUtils;

public class Bookmarks extends Base{

	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Bookmarks Page");
	
	public void navigateToURL(WebDriver driver){
		siteURL="/#/org-bookmarks";
		driver.navigate().to(baseurl+siteURL);
		}
	
	@Test
	public void executeScipt() throws IOException{
		
		ReportGenerator.assignAuthor(parentTest,"Mayank");
		this.driver=driverIns();
		CC_Login(this.driver, "msrivastava@spikes.com", "Welcome@1");
		navigateToURL(this.driver);
		
		Sleep(5000);
		
		LogEntries logs= driver.manage().logs().get("browser"); 
		
		Loggers.startCurrentTestCaseExecution(this.driver);
		
		try{
			ReportGenerator.verifyNavigation(this.driver, "Control Center", parentTest,testCaseName,"Yes");
			
			WebPageUtils.clickOn(this.driver, "linkText", "Add Bookmark");
			
			WebPageUtils.writeIn(this.driver, "id", "txtAddBookmarkTitle", "AutoBookMark");
			
			WebPageUtils.writeIn(this.driver, "id", "txtAddBookmarkUri", "https://www.google.com");
			
			WebPageUtils.clickOn(this.driver, "xpath", "//span[@class='ui-button-text' and contains(text(),'Add')]");
			
			DriverUtil.refreshPage(this.driver);
			
			Sleep(3000);
			
			if((WebPageUtils.elementIsPresent(this.driver, "linkText", "AutoBookMark")) && (WebPageUtils.getElementAttribute(this.driver, "xpath", "//span/a[@target='_blank']", "href").contains("https://www.google.com"))){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Bookmark is getting added correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Bookmark is not getting added properly", this.driver);
			}
			
			WebPageUtils.clickOn(this.driver, "className", "editBookmark");
			
			Sleep(3000);
			
			WebPageUtils.clear(this.driver, "id", "txtEditBookmarkTitle");
			
			WebPageUtils.writeIn(this.driver, "id", "txtEditBookmarkTitle", "AutoBookMark123");
			
			WebPageUtils.pressKey(KeyEvent.VK_TAB);
			WebPageUtils.pressKey(KeyEvent.VK_TAB);
			
			WebPageUtils.pressKey(KeyEvent.VK_ENTER);
			
			DriverUtil.refreshPage(this.driver);
			
			Sleep(3000);
			
			if((WebPageUtils.elementIsPresent(this.driver, "linkText", "AutoBookMark123")) && (WebPageUtils.getElementAttribute(this.driver, "xpath", "//span/a[@target='_blank']", "href").contains("https://www.google.com"))){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Bookmark is getting edited correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Bookmark is not getting edited properly", this.driver);
			}
			
			
			WebPageUtils.clickOn(this.driver, "className", "deleteBookmark");
			
			Sleep(3000);
			
			WebPageUtils.clickOn(this.driver, "xpath", "//span[@class='ui-button-text' and contains(text(),'OK')]");
			
			WebPageUtils.clickOn(this.driver, "linkText", "Refresh");
			
			Sleep(3000);
			
			if(!(WebPageUtils.elementIsPresent(this.driver, "linkText", "AutoBookMark123"))){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Bookmark is getting deleted correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Bookmark is not getting deleted properly", this.driver);
			}
			
			WebPageUtils.clickOn(this.driver, "linkText", "Add Bookmark Group");
			
			WebPageUtils.writeIn(this.driver, "id", "txtAddBookmarkGroupDisplayName", "AutoBookMarkGroup");
			
			WebPageUtils.clickOn(this.driver, "xpath", "//span[@class='ui-button-text' and contains(text(),'Add')]");
			
			DriverUtil.refreshPage(this.driver);
			
			Sleep(3000);
			
			if(WebPageUtils.getElementText(this.driver, "xpath", "//table[@id='tableorgBookmarkTable']//td//span[contains(text(),'Auto')]").equals("AutoBookMarkGroup")){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Bookmark group is getting added correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Bookmark group is not getting added properly", this.driver);
			}
			
			WebPageUtils.clickOn(this.driver, "className", "editBookmarkGroup");
			
			WebPageUtils.clear(this.driver, "id", "txtEditBookmarkGroupDisplayName");
			
			WebPageUtils.writeIn(this.driver, "id", "txtEditBookmarkGroupDisplayName", "AutoBookMarkGroup123");
			
			WebPageUtils.pressKey(KeyEvent.VK_TAB);
			
			WebPageUtils.pressKey(KeyEvent.VK_ENTER);
			
			DriverUtil.refreshPage(this.driver);
			
			if(WebPageUtils.getElementText(this.driver, "xpath", "//table[@id='tableorgBookmarkTable']//td//span[contains(text(),'Auto')]").equals("AutoBookMarkGroup123")){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Bookmark group is getting edited correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Bookmark group is not getting edited properly", this.driver);
			}
			
			WebPageUtils.clickOn(this.driver, "className", "deleteBookmarkGroup");
			
			Sleep(3000);
			
			WebPageUtils.clickOn(this.driver, "xpath", "//span[@class='ui-button-text' and contains(text(),'OK')]");
			
			WebPageUtils.clickOn(this.driver, "linkText", "Refresh");
			
			Sleep(3000);
			
			if(!(WebPageUtils.elementIsPresent(this.driver, "xpath", "//table[@id='tableorgBookmarkTable']//td//span[contains(text(),'123')]"))){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Bookmark group is getting deleted correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Bookmark group is not getting deleted properly", this.driver);
			}
			
			System.out.println(logs);
		}catch(Exception e){
			
			Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The CC Bookmarks TestCase has failed,Please see logs and error screenshots", this.driver);
		}
		finally{
			quitDriver(this.driver);
			path=currentSitePath;
		ReportGenerator.flushReportToDisk(parentTest);
		}
	}
}
