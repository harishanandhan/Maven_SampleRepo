package BaseTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class Test1 {
	public WebDriver driver;
	public static SoftAssert softAssert = new SoftAssert();

	public Test1(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebDriver launchBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		return driver;
	}

	public void click(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void clickJS(WebDriver driver, WebElement element) {
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("arguments[0].click();", element);
	}

	public void event(String message) {
		Reporter.log(message);
	}

	public void message(String message, boolean screenShot) {
		Reporter.log(message);
	}

	public static boolean verifyWebElementTextEquals(WebDriver driver, WebElement element, String expectedText) {
		String actualText = element.getText();
		return actualText.equals(expectedText);
	}

	public static String getTextOfWebElement(WebElement element, WebDriver driver) {
		String element1 = element.getText();
		return element1;
	}

	public List<String> getAllTextFromWebElementList(List<WebElement> elements) {
		List<String> textList = new ArrayList<>();
		for (WebElement element : elements) {
			// Retrieve the text from each element and add it to the list
			textList.add(element.getText());
		}
		return textList;
	}

	public static boolean waitForElement(WebDriver driver, WebElement element, int seconds) {
		long endTime = System.currentTimeMillis() + (seconds * 1000);
		while (System.currentTimeMillis() < endTime) {
			try {
				if (element.isDisplayed()) {
					return true;
				}
			} catch (Exception e) {
				// Element is not displayed yet
			}
		}
		return false; // Timeout reached
	}
	
	public static void softAssertThat(boolean status, String passMsg, String failMsg) {
		if (!status) {
			Test1.failsoft(failMsg);
			softAssert.fail(failMsg);
		} else {
			Test1.message(passMsg);
		}
	}
	
	// Method to assert all collected assertions at the end
	public static void assertAll() { 
		 softAssert.assertAll(); 
	 	}
		 
	// Example Log class for logging
	public static void message(String msg) {
		Reporter.log("Passed: " + msg);
	}

	public static void failsoft(String msg) {
		Reporter.log("Fail: " + msg);
	}
}
	    