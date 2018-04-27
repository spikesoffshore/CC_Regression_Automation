package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.DriverUtil;
import utils.Loggers;
import utils.ReportGenerator;
import utils.WebPageUtils;

public class Trusted_Sites extends Base {

	
	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Trusted Sites Page");
	
	public void navigateToURL(WebDriver driver){
		siteURL="/#/org-trusted-sites";
		driver.navigate().to(baseurl+siteURL);
		}
	
	@Test
	public void executeScipt() throws IOException{
		
		ReportGenerator.assignAuthor(parentTest,"Mayank");
		this.driver=driverIns();
		CC_Login(this.driver, "msrivastava@spikes.com", "Welcome@1");
		navigateToURL(this.driver);
		
		Sleep(5000);
		
		Loggers.startCurrentTestCaseExecution(this.driver);
		
		try{
			ReportGenerator.verifyNavigation(this.driver, "Control Center", parentTest,testCaseName,"Yes");
			
			WebPageUtils.clickOn(this.driver, "linkText", "Add Trusted Site");
			
			WebPageUtils.writeIn(this.driver, "id", "txtAddTrustUri", "https://www.google.com");
			
			WebPageUtils.clickOn(this.driver, "xpath", "//span[@class='ui-button-text' and contains(text(),'Add')]");
			
			DriverUtil.refreshPage(this.driver);
			
			WebPageUtils.clickOn(this.driver, "linkText", "Expand All");
			
			Sleep(3000);
			
			if((WebPageUtils.getElementText(this.driver, "xpath", "//table[@id='tableorgBypassTable']//td//span[contains(text(),'google')]").contains("https://www.google.com"))){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Trusted Site is getting added correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Trusted Site is not getting added properly", this.driver);
			}
			
			WebPageUtils.clickOn(this.driver, "xpath", "//a[@class='userBypassEditing editTrust']");
			
			Sleep(3000);
			
			WebPageUtils.clear(this.driver, "id", "txtEditTrustUri");
			
			WebPageUtils.writeIn(this.driver, "id", "txtEditTrustUri", "https://www.google.co.in");
			
			WebPageUtils.pressKey(KeyEvent.VK_TAB);
			
			WebPageUtils.pressKey(KeyEvent.VK_ENTER);
			
			DriverUtil.refreshPage(this.driver);
			
			Sleep(3000);
			
			WebPageUtils.clickOn(this.driver, "linkText", "Expand All");
			
			Sleep(3000);
			
			if((WebPageUtils.getElementText(this.driver, "xpath", "//table[@id='tableorgBypassTable']//td//span[contains(text(),'google')]").contains("https://www.google.co.in"))){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Trusted Site is getting edited correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Trusted site is not getting edited properly", this.driver);
			}
			
			
			WebPageUtils.clickOn(this.driver, "xpath", "//a[@class='userBypassEditing deleteTrust']");
			
			Sleep(3000);
			
			WebPageUtils.clickOn(this.driver, "xpath", "//span[@class='ui-button-text' and contains(text(),'OK')]");
			
			Sleep(3000);
			
			if(!(WebPageUtils.elementIsPresent(this.driver, "xpath", "//table[@id='tableorgBypassTable']//td//span[contains(text(),'google')]"))){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Trusted site is getting deleted correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Trusted site is not getting deleted properly", this.driver);
			}
			
			WebPageUtils.clickOn(this.driver, "linkText", "Add Trust Group");
			
			WebPageUtils.writeIn(this.driver, "id", "txtAddTrustGroupDisplayName", "AutoTrustGroup");
			
			WebPageUtils.clickOn(this.driver, "xpath", "//span[@class='ui-button-text' and contains(text(),'Add')]");
			
			DriverUtil.refreshPage(this.driver);
			
			Sleep(3000);
			
			if(WebPageUtils.getElementText(this.driver, "xpath", "//table[@id='tableorgBypassTable']//td//span[contains(text(),'Auto')]").equals("AutoTrustGroup")){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Trust group is getting added correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Trust group is not getting added properly", this.driver);
			}
			
			WebPageUtils.clickOn(this.driver, "xpath", "//a[@class='editTrustGroup']");
			
			WebPageUtils.clear(this.driver, "id", "txtEditTrustGroupDisplayName");
			
			WebPageUtils.writeIn(this.driver, "id", "txtEditTrustGroupDisplayName", "AutoTrustGroup123");
			
			WebPageUtils.pressKey(KeyEvent.VK_TAB);
			
			WebPageUtils.pressKey(KeyEvent.VK_ENTER);
			
			DriverUtil.refreshPage(this.driver);
			
			if(WebPageUtils.getElementText(this.driver, "xpath", "//table[@id='tableorgBypassTable']//td//span[contains(text(),'Auto')]").equals("AutoTrustGroup123")){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Trust group is getting edited correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Trust group is not getting edited properly", this.driver);
			}
			
			WebPageUtils.clickOn(this.driver, "xpath", "//a[@class='deleteTrustGroup']");
			
			Sleep(3000);
			
			WebPageUtils.clickOn(this.driver, "xpath", "//span[@class='ui-button-text' and contains(text(),'OK')]");
			
			WebPageUtils.clickOn(this.driver, "linkText", "Refresh");
			
			Sleep(3000);
			
			if(!(WebPageUtils.elementIsPresent(this.driver, "xpath", "//table[@id='tableorgBypassTable']//td//span[contains(text(),'123')]"))){
				
				ReportGenerator.logStatusPass(parentTest, testCaseName, "Trust group is getting deleted correctly");
				
			}else{
				
				ReportGenerator.logStatusFail(parentTest, testCaseName, "Trust group is not getting deleted properly", this.driver);
			}
			
			
		}catch(Exception e){
			
			Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The CC Trusted Sites TestCase has failed,Please see logs and error screenshots", this.driver);
		}
		finally{
			quitDriver(this.driver);
			path=currentSitePath;
		ReportGenerator.flushReportToDisk(parentTest);
		}
	}
}
