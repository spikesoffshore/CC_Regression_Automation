package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.Test;

import utils.DriverUtil;
import utils.Loggers;
import utils.ReportGenerator;
import utils.WebPageUtils;

public class LoginPage extends Base{

	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Login Page");
	
	public void navigateToURL(WebDriver driver){
		siteURL="";
		driver.navigate().to(baseurl+siteURL);
		}
	
	@Test
	public void executeScript() throws IOException{
		
		ReportGenerator.assignAuthor(parentTest,"Mayank");
		this.driver=driverIns();
		navigateToURL(this.driver);
		
		
		Sleep(5000);
		
		Loggers.startCurrentTestCaseExecution(this.driver);
		
		try{
		ReportGenerator.verifyNavigation(this.driver, "Control Center", parentTest,testCaseName,"Yes");
		
		//Testing Invalid credentials
		CC_Login(this.driver,"msrivastava1@spikes.com","Welcome@1");
		
		if (WebPageUtils.getElementText(this.driver,"xpath","//div[@class='signinErrorMessage errorMsg']").contains("Invalid username/password combination.")){
			
			ReportGenerator.logStatusPass(parentTest, testCaseName, "Invalid User credentials test passed");
		}else{
			ReportGenerator.logStatusFail(parentTest, testCaseName, "Invalid User credentials test has failed.", this.driver);
			
		}
		
		//Moving ahead to test valid credentials
		DriverUtil.refreshPage(this.driver);
		
		CC_Login(this.driver,"msrivastava@spikes.com","Welcome@1");
		
		if(DriverUtil.pageSourceContains(this.driver, "Dashboard")){
			
			ReportGenerator.logStatusPass(parentTest, testCaseName, "Valid User credentials test passed");
			
			
		
			
		}else{
			
			ReportGenerator.logStatusFail(parentTest, testCaseName, "Invalid User credentials test has failed.", this.driver);
		}
		
		WebPageUtils.clickOn(this.driver, "id", "userText");
		Sleep(3000);
		WebPageUtils.clickOn(this.driver, "linkText", "Sign Out");
		Sleep(4000);
		if(WebPageUtils.elementIsPresent(this.driver, "id", "signinUsernameText")){
			ReportGenerator.logStatusPass(parentTest, testCaseName, "Logout functionality working fine");
			
		}else{
		
			ReportGenerator.logStatusFail(parentTest, testCaseName, "Logout functionality is not working fine", this.driver);
			
		}
		
		}catch(Exception e){
			Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			System.out.println(e);
			ReportGenerator.logStatusFail(parentTest,testCaseName, "The CC Login TestCase has failed,Please see logs and error screenshots", this.driver);
		}
		finally{
			quitDriver(this.driver);
			path=currentSitePath;
		ReportGenerator.flushReportToDisk(parentTest);
		}
		
		
	}
}
