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

public class Test1 {
	public WebDriver driver;

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
		System.out.println(message);
	}

	public void message(String message, boolean screenShot) {
		System.out.println(message);
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
	
}
