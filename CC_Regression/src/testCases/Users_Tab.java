package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.Test;

import utils.Loggers;
import utils.ReportGenerator;

public class Users_Tab extends Base {

	private WebDriver driver;
	private String currentSitePath;
	private String testCaseName=getClass().getName().substring(10); 
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Users Page");
	
	public void navigateToURL(WebDriver driver){
		siteURL="/#/org-trusted-sites";
		driver.navigate().to(baseurl+siteURL);
		}
	
	@Test
	public void executeScript() throws IOException{
		
		ReportGenerator.assignAuthor(parentTest,"Mayank");
		
		this.driver=driverIns();
		
		CC_Login(this.driver, "msrivastava@spikes.com", "Welcome@1");
		
		navigateToURL(this.driver);
		
		Sleep(5000);
		
		Loggers.startCurrentTestCaseExecution(this.driver);
		
		try{
			
			ReportGenerator.verifyNavigation(this.driver, "Control Center", parentTest,testCaseName,"Yes");
			
		}catch(Exception e){
			
			
		}finally{
			
			
		}
	}
		
		
		
		
	}
	

