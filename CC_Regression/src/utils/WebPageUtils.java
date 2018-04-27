package utils;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageUtils {

	public static String getElementText(WebDriver driver,String locatorName,String locator_value){
		
		String textValue = null;
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement element = null;
		switch (locatorName){
		
			case "classname":
				
				element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator_value)));
				textValue = element.getText();
				break;
			
			case "linkText":
			
				element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator_value)));
				textValue = element.getText();
				break;
			
			case "id":
			
				element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator_value)));
				textValue = element.getText();
				break;
			
			case "xpath":
		
				element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator_value)));
				textValue = element.getText();
				break;
		
			case "name":
		
				element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator_value)));
				textValue = element.getText();
				break;
}
		return textValue;
	}
	
	public static void clickOn(WebDriver driver,String locatorName,String locatorValue){
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement element = null;
		switch (locatorName){
		
		case "className":
			
			element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			element.click();
			break;
			
		case "linkText":
			
			element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			element.click();
			break;
			
		case "id":
			
			element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			element.click();
			break;
			
		case "xpath":
		
			element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			element.click();
			break;
		
		case "name":
		
			element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			element.click();
			break;
		
		}
			
	}
	public static Boolean elementIsPresent(WebDriver driver,String locatorName,String locatorValue){
		
		
		Boolean value = null;
		
		WebElement element = null;
		
		try{
		switch (locatorName){
		
		case "className":
			
			element= driver.findElement(By.className(locatorValue));
			value = element.isDisplayed();
			break;
			
		case "linkText":
			
			element= driver.findElement(By.linkText(locatorValue));
			value = element.isDisplayed();
			break;
			
		case "id":
			
			element= driver.findElement(By.id(locatorValue));
			value = element.isDisplayed();
			break;
			
		case "xpath":
		
			element= driver.findElement(By.xpath(locatorValue));
			value = element.isDisplayed();
		break;
		
		case "name":
		
			element= driver.findElement(By.name(locatorValue));
			value = element.isDisplayed();
		break;
		
		}
		return value;
		}catch(NoSuchElementException n){
			
			return false;
		}
	}
	public static void writeIn(WebDriver driver, String locatorName, String locatorValue,String text){
		
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement element = null;
				switch (locatorName){
		
					case "classname":
						element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
						element.sendKeys(text);
					break;
			
					case "linkText":
			
						element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
						element.sendKeys(text);
					break;
			
					case "id":
			
						element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
						element.sendKeys(text);
					break;
			
					case "xpath":
		
						element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
						element.sendKeys(text);
					break;
		
					case "name":
		
						element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
						element.sendKeys(text);
					break;
		
		}
		
		
		
	}
	public static void expandTable(WebDriver driver,String cssValue){
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssValue)));
		 if(!(element).isDisplayed()){
			 element.click();
		    }
		
	}
public static String getElementAttribute(WebDriver driver,String locatorName,String locator_value,String attributeName){
		
		String textValue = null;
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement element = null;
		switch (locatorName){
		
			case "classname":
				
				element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator_value)));
				textValue = element.getAttribute(attributeName);
				break;
			
			case "linkText":
			
				element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator_value)));
				textValue = element.getAttribute(attributeName);
				break;
			
			case "id":
			
				element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator_value)));
				textValue = element.getAttribute(attributeName);
				break;
			
			case "xpath":
		
				element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator_value)));
				textValue = element.getAttribute(attributeName);
				break;
		
			case "name":
		
				element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator_value)));
				textValue = element.getAttribute(attributeName);
				break;
}
		return textValue;
	}
public static void clear(WebDriver driver,String locatorName,String locatorValue){
	
	WebDriverWait wait=new WebDriverWait(driver, 10);
	WebElement element = null;
	switch (locatorName){
	
	case "className":
		
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
		element.clear();
		break;
		
	case "linkText":
		
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
		element.clear();
		break;
		
	case "id":
		
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		element.clear();
		break;
		
	case "xpath":
	
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		element.clear();
		break;
	
	case "name":
	
		element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
		element.clear();
		break;
	
	}
		
}
public static void pressKey(int keyEvent){
	
		
	Robot r = null;
	try {
		r = new Robot();
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	r.keyPress(keyEvent);
	r.keyRelease(keyEvent);

}
}

