package TestRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.HomePage;

public class ExploreTesting {
	public enum Day {  Sun, Mon, Tue, Wed, Thu, Fri, Sat  }
	public WebDriver driver;
	
	@Test
	public void DataTypeExample() {
		// Primitive data types
		int number = 42;
		double price = 19.99;
		char grade = 'A';
		boolean isValid = true;

		// Reference data types
		String message = "Hello, Java!";
		int[] numbersArray = { 1, 2, 3, 4, 5 };
		ArrayList<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");

		// Output primitive values
		System.out.println("Number: " + number);
		System.out.println("Price: " + price);
		System.out.println("Grade: " + grade);
		System.out.println("Is valid: " + isValid);

		// Output reference values
		System.out.println("Message: " + message);
		System.out.print("Numbers array: ");
		for (int num : numbersArray) {
			System.out.print(num + " ");
		}
		System.out.println("\nNames list: " + names);
	}

	@Test
	public void UnaryOperatorExample() {
		int a = 5;
		int b = -a;
		int c = +a;

		int d = 10;
		int e = ++d; // prefix increment
		int f = d--; // postfix decrement

		boolean g = true;
		boolean h = !g;

		int i = 8; // 8 in binary: 0000 1000
		int j = ~i; // j is -9, which is 1111 0111 in binary (two's complement)

		System.out.println("Unary Plus: " + c); // 5
		System.out.println("Unary Minus: " + b); // -5
		System.out.println("Prefix Increment: " + e); // 11
		System.out.println("Postfix Decrement: " + f); // d = 11
		System.out.println("Logical Complement: " + h); // false
		System.out.println("Bitwise Complement: " + j); // -9
	}
	
	@Test
	public void TernaryExample1() {
		int a = 2;
		int b = 5;

		// Using ternary operator to find the minimum of a and b
		int min = (a < b) ? a : b;

		// Output the result
		System.out.println(min); // Output: 2
	}
	
	@Test
	public void TernaryExample2() {
		int x = 10;
		int y = 20;

		// Use the ternary operator to find the maximum of x and y
		int max = (x > y) ? x : y;

		// Output the result
		System.out.println("The maximum value is: " + max); // Output: The maximum value is: 20
	}
	
	@Test
	public void continueExample() {
		System.out.println("Print the odd number 1 to 10:\n");
		for (int i = 1; i <= 10; i++) { // Using for loop
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i); // print odd number 1 to 10
		}
	}
	
	@Test
	public void continueExample1() {
		int i = 1;
		while (i <= 10) {
			if (i % 3 == 0) {
				i++;
				continue;
			}
			System.out.println(i);
			i++;
		}
	}
	
	@Test
	public void nestedIf() {
		String address = "Delhi, India";
		if (address.endsWith("India")) {
			if (address.contains("Meerut")) {
				System.out.println("Your city is Meerut");
			} else if (address.contains("Noida")) {
				System.out.println("Your city is Noida");
			} else {
				System.out.println("You are living in " + address.split(",")[0]);
			}
		} else {
			System.out.println("You are not living in India");
		}
	}    
	
	@Test
	public void switchMethod() {
		int num =5;
		switch(num) {
		case 0:
			System.out.println("The num is 0");
			break;
		case 4:
			System.out.println("The num is 4");
			break;
		default:
			System.out.println("The number is " + num);
		}
	}
	
	@Test //for loop
	public void forLoop() { 
		int sum = 0;
		for (int j = 1; j <= 10; j++) {
			sum = sum + j;
		}
		System.out.println("The sum of first 10 natural number is " + sum);
	}
	
	@Test //for each loop
	public void forEachLoop() {
		String[] names = { "Python", "C#", "Ruby", "C++", "Java" };
		System.out.println("Printing the content of array names:\n");
		for (String name : names) {
			System.out.println(name);
		}
	}
	
	@Test //while Loop for print odd or even number using if condition
	public void whileLoop() {
		int i = 1;
		int count = 0;
		System.out.println("Printing the number of first 10 even numbers:\n");
		// count the odd or even number
		while (count < 5) {         // increment count to print 5 or more than 5 odd or even number
			if (i % 2 == 0) {       // print odd number means given like !=
				System.out.println(i);
				count++;
			}
			i++;
		}
	}
	
	@Test //while Loop for print odd and even number not using if condition
	public void whileLoopOne() {
		int i = 1;
		int count = 0;
		System.out.println("Printing the number of first 10 odd numbers:\n");
		while (count < 5) {
			System.out.println(i);
			i += 2;
			count++;
		}
	}
	
	@Test
	public void forLoopEvenOrOdd() {
		int count = 0;
		for(int i = 1; count < 5; i++) {
			if(i % 2 != 0) {
				System.out.println(i);
				count++;
			}
		}
	}
	
	@Test //do while loop
	public void doWhileLoop() {
		int i = 0;
		System.out.println("Printing the number of first 10 event numbers:\n");
		do {
			System.out.println(i);
			i = i + 2;
		} while (i <= 10);
	}
	
	@Test
	public void continueStament() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 2; i++) {
			for (int j = i; j <= 5; j++) {
				if (j == 4) {
					continue;
				}
				System.out.println(j);
			}
		}
	}
	
	@Test//Switch case with enum
	public void SwitchEnumCase() {
		Day[] DayNew = Day.values();
		for (Day New : DayNew) {
			switch (New) {
			case Sun:
				System.out.println("Sunday");
				break;
			case Mon:
				System.out.println("Monday");
				break;
			case Tue:
				System.out.println("Tuesday");
				break;
			case Wed:
				System.out.println("Wednesday");
				break;
			case Thu:
				System.out.println("Thursday");
				break;
			case Fri:
				System.out.println("Friday");
				break;
			case Sat:
				System.out.println("Saturday");
				break;
			}
		}
	}
	
	@Test //Pyramid
	public void pyramid() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	@Test //Pyramid
	public void pyramidOne() {
		int term = 6;
		for (int i = 1; i <= term; i++) {
			for (int j = term; j >= i; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	@Test
	public void labelled() {
		// Using Label for outer and for loop
		aa: for (int i = 1; i <= 3; i++) {
			bb: for (int j = 1; j <= 3; j++) {
				if (i == 2 && j == 2) {
					break aa;
				}
				System.out.println(i + " " + j);
			}
		}
	}  
	
	@Test
	public void labelldedOne() {
		aa: for (int i = 1; i <= 3; i++) {
			bb: for (int j = 1; j <= 3; j++) {
				if (i == 2 && j == 2) {
					break bb;
				}
				System.out.println(i + " " + j);
			}
		}
	}  
	
	@Test
	public void BreakWhileExample() {
		// while loop
		int i = 1;
		while (i <= 10) {
			if (i == 5) {
				// using break statement
				i++;
				break;// it will break the loop
			}
			System.out.println(i);
			i++;
		}
	}  
	
	@Test //Window Handle and Tab Count
	public void handleAndCount() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//open new tab
		js.executeScript("window.open('about:blank', '_blank');");
		//js.executeScript("window.open('https://www.google.com', '_blank');");
		
		//switch to new tab and open google tab
		Set<String> windowHandles = driver.getWindowHandles();
		String newTabHandle = windowHandles.toArray()[1].toString();
		driver.switchTo().window(newTabHandle);
		driver.get("https://www.google.com");
		
		driver.switchTo().window(windowHandles.toArray()[0].toString());
		
		int numOfTab = driver.getWindowHandles().size();
		System.out.println("The num of Tab: "+ numOfTab);
		
		driver.quit();
	}
	
	@Test //Drag And Drop Sample
	public void dragAndDrop() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://jqueryui.com/droppable/");  // ---> Drag and drop Sample URL 

			// Switch to frame
			driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

			WebElement source = driver.findElement(By.id("draggable"));
			WebElement target = driver.findElement(By.id("droppable"));

			Actions action = new Actions(driver);
			action.dragAndDrop(source, target).perform();

			String text = target.getText();
			if (text.equals("Dropped!")) {
				System.out.println("Drag and Drop Successfull");
			} else System.out.println("Drag and Drop Failed");

		} finally {
			driver.quit();
		}
	}
	
	@Test
	public void alertExample() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert"); // --> Example - 1

			// switch to frame
			driver.switchTo().frame("iframeResult");

			WebElement tryItButton1 = driver.findElement(By.xpath("//button[text()='Try it']"));
			tryItButton1.click();

			// Accept an alert
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert Text: " + alertText);
			alert.accept();
			System.out.println("Alert Accepted");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  // --> Example - 2 Staring from new Tab creation
			js.executeScript("window.open('about:blank', '_blank');");
			
			Set<String> windowhandles = driver.getWindowHandles();
			String newTabHandle = windowhandles.toArray()[1].toString();
			driver.switchTo().window(newTabHandle);
			
			// Open the confirmation alert example page
			driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm"); // --> Example - 2
			driver.switchTo().frame("iframeResult");

			WebElement tryItButton2 = driver.findElement(By.xpath("//button[text()='Try it']"));
			tryItButton2.click();

			// Dismiss a confirmation alert
			Alert alert2 = driver.switchTo().alert();
			alert2.dismiss();
			System.out.println("Confirmation Alert Dismissed");
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;  // --> Example - 3 Staring from new Tab creation
			js1.executeScript("window.open('about:blank', '_blank');");
			
			Set<String> windowhandle1 = driver.getWindowHandles();
			String newTabHandle1 = windowhandle1.toArray()[2].toString();
			driver.switchTo().window(newTabHandle1);

			driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt"); // --> Example - 3
			driver.switchTo().frame("iframeResult");

			WebElement tryItButton3 = driver.findElement(By.xpath("//button[text()='Try it']"));
			tryItButton3.click();

			// Send text to a prompt alert
			Alert alert3 = driver.switchTo().alert();
			alert3.sendKeys("Son Goku");
			alert3.accept();
			System.out.println("Text sent to prompt alert and accepted.");

		} finally {
			driver.quit();
		}
	}
	
	@Test
	public void pageInfoExample() {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("https://www.google.com");

			String title = driver.getTitle();
			System.out.println("Page Title: " + title);

			String currentURL = driver.getCurrentUrl();
			System.out.println("Current URL: " + currentURL);

			String pageSource = driver.getPageSource();
			System.out.println("Page Source: " + pageSource.substring(0, 200) + "..."); // --> Print the first 200 Characters
																						 
		} finally {
			driver.quit();
		}
	}
	
	@Test
	public void elemenInfo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://the-internet.herokuapp.com");
			
			WebElement element = driver.findElement(By.linkText("A/B Testing"));
			
			boolean isVisible = element.isDisplayed();
			System.out.println("Is element visible? " + isVisible);
			
			boolean isEnable = element.isEnabled();
			System.out.println("Is element enabled? " + isEnable);
			
			String tagName = element.getTagName();
			System.out.println("Tag Name is: " + tagName);
			
			String attributevalue = element.getAttribute("href");
			System.out.println("The Attribute value is: " + attributevalue);
			
			element.click();
			
			Thread.sleep(2000);
			String title = driver.getTitle();
			System.out.println("The Page Title is: " + title);
			
			driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
			
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.open('about:blank', '_blank');");
//			
//			Set<String> windowHandle = driver.getWindowHandles();
//			String newTabHandle = windowHandle.toArray()[1].toString();
//			driver.switchTo().window(newTabHandle);
//			driver.get("http://the-internet.herokuapp.com/checkboxes");
			
			WebElement checkBoxElement = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
			
			boolean isSelected = checkBoxElement.isSelected();
			System.out.println("Is Checkbox selected? " + isSelected);
			
			if(!isSelected) {
				checkBoxElement.click();
				System.out.println("CheckBox Selected");
			}
			
			boolean isSelected1 = checkBoxElement.isSelected();
			System.out.println("Is Check box is Selected now? " + isSelected1);
			
		} finally {
			driver.quit();
		}
	}
	
	@Test //-------------> Menu Handling
	public void dropDown() {
		driver = new ChromeDriver();
		try {
			driver.get("http://the-internet.herokuapp.com/dropdown");
			
			// Locate the drop down element
			WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
			
			// create a select object from drop down element
			Select select = new Select(dropdownElement);
			select.selectByIndex(1);
			System.out.println("Selected option by index: " + select.getFirstSelectedOption().getText());
			
			select.selectByValue("2");
			System.out.println("Selected option by value: " + select.getFirstSelectedOption().getText());
			
			select.selectByVisibleText("Option 1");
			System.out.println("Selected option by visible text: " + select.getFirstSelectedOption().getText());
			
		} finally {
			driver.quit();
		}
	}
	
	@Test  //-----------> Key Board Actions
	public void keyActions() {
		driver = new ChromeDriver();
		try {
			driver.get("https://www.google.com");
			
			WebElement searchBox = driver.findElement(By.name("q"));
			
			Actions action = new Actions(driver);
			searchBox.click();
			
			action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
			System.out.println("Performed Ctrl+A");
			
			action.keyDown(Keys.SHIFT).sendKeys("Son Goku").keyUp(Keys.SHIFT).perform();
			System.out.println("Typed Son Goku");
			
			action.sendKeys(Keys.ENTER).perform();
			System.out.println("Pressed Enter");
		} finally {
			driver.quit();
		}
	}
	
	@Test //--------> Mouse Action
	public void mouseAction() {
		driver = new ChromeDriver();
		try {
			driver.get("http://the-internet.herokuapp.com/context_menu");

			WebElement box = driver.findElement(By.id("hot-spot"));

			Actions action = new Actions(driver);
			action.contextClick(box).perform();
			System.out.println("Performed right-click");
			
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			action.clickAndHold(box).perform();
			System.out.println("Clicked and held the element");

			action.release(box).perform();
			System.out.println("Released the mouse button");

			action.clickAndHold(box).pause(2000).release().perform();
			System.out.println("Clicked, held for 2 seconds, and released");
		} finally {
			driver.quit();
		}
	}
	
	@Test //-----------> Screenshot
	public void screenShot() throws IOException {
		driver = new ChromeDriver();
		try {
			//driver.get("https://www.wikipedia.org");
			
			// Take a Screen Shot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			//Define The Destination Path
			File destinationPath = new File ("D:/Preparation/screenshot.png");
			
			// Copy the screenshot to the destination path
            FileUtils.copyFile(screenshot, destinationPath);
            
            System.out.println("Screenshot Saved at: " + destinationPath.getAbsolutePath());
		} finally {
			driver.quit();
		}
	}
	
	@Test //----------> Scroll Down By Pixel
	public void scrollByPixels() {
		driver = new ChromeDriver();
		try {
			driver.get("https://www.wikipedia.org");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript("window.scrollBy(0, 1000)");
			System.out.println("Scrolled down by 1000 pixels");
		} finally {
			driver.quit();
		}
	}
	
	@Test //-----------> Scroll To a Specific Element
	public void ScrollToElement() throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // Run in maximized window
		driver = new ChromeDriver(options);
		try {
			driver.get("https://www.wikipedia.org");
			Thread.sleep(2000);

			WebElement element = driver.findElement(By.xpath("//*[@aria-label='Other projects']/div[7]/a/div[2]/span[2]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView(true);", element);
			HomePage homepage = new HomePage(driver);
			homepage.screenShot(true);
			System.out.println("Scrolled to the element");
		} finally {
			driver.quit();
		}
	}
	
	@Test //-----------> Scroll to Bottom
	public void ScrollToBottom() throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // ------- Run in headless mode
		options.addArguments("--disable-images");
		options.setExperimentalOption("useAutomationExtension", false); // Disable automation extension
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); // Exclude automation switches
		driver = new ChromeDriver(options);
		try {
			driver.get("https://www.wikipedia.org");

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			HomePage homepage = new HomePage(driver);
			homepage.screenShot(true);
			System.out.println("Scrolled to the Bottom of the Page");
		} finally {
			driver.quit();
		}
	}
	
	@Test //-------------> Cookie Management
	public void cookie() {
		driver = new ChromeDriver();
		try {
			driver.get("https://www.wikipedia.org");
			
			// Get All Cookie
			Set<Cookie> Cookies = driver.manage().getCookies();
			System.out.println("Gell All Cookies");
			for (Cookie cookie : Cookies) {
				System.out.println(cookie);
			}
			
			// Get Cookie Name
			Cookie specificCookie = driver.manage().getCookieNamed("GeoIP");
			if (specificCookie!=null) {
			System.out.println("Specific cookie: " + specificCookie);
			} else System.out.println("Specific cookie not found");
			
			// Add new Cookie with Value
			//Cookie newCookieAdd = new Cookie("test_cookie", "test_value"); 
			driver.manage().addCookie(new Cookie("test_cookie", "test_value"));
			System.out.println("New Cookie added");
			
			// Get the Added cookie and Print
			Cookie addedCookie = driver.manage().getCookieNamed("test_cookie");
			System.out.println("Added Cookie: " + addedCookie);
			
			// Delete the specific cookie name
			driver.manage().deleteCookieNamed("test_cookie");
			System.out.println("Cookie 'test_cookie' deleted");
			
			// Verify Cookie is deleted
			Cookie deleteCookie = driver.manage().getCookieNamed("test_cookie");
			if(deleteCookie==null) {
				System.out.println("Cookie 'test_cookie' is deleted successfully");
			}
			
			// Delete All Cookie
			driver.manage().deleteAllCookies();
			System.out.println("All Cookie Deleted");
		} finally {
			driver.quit();
		}
	}
	
	@Test //  -----------> Uploading file
	public void uploadFile() throws IOException {
		driver = new ChromeDriver();
		try {
			driver.get("http://the-internet.herokuapp.com/upload");
			File uploadFile = new File ("D:/Preparation/Selenium.pdf");
			
			WebElement upload = driver.findElement(By.xpath("//input[@name='file']"));
			upload.sendKeys(uploadFile.getAbsolutePath());
			
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
			Assert.assertEquals("Selenium.pdf", uploadedFile.getText());
			HomePage homepage = new HomePage(driver);
			homepage.screenShot(true);
		} finally {
			driver.quit();
		}
	}
	
	@Test // -------------> Create the Excel Sheet
	public void createExcel() throws IOException {
		try (// Blank Workbook
				XSSFWorkbook workbook = new XSSFWorkbook()) {
			// Create a blank Excel sheet
			XSSFSheet sheet = workbook.createSheet("Student Details");

			// Creating an empty TreeMap of string and Object][] type
			Map<String, Object[]> data = new TreeMap<String, Object[]>();

			// Writing data to Object[]
			// using put() method
			data.put("1", new Object[] { "ID", "Name", "LastName" });
			data.put("2", new Object[] { "1", "Son", "Goku" });
			data.put("3", new Object[] { "2", "Goku", "San" });
			data.put("4", new Object[] { "3", "Vegeta", "San" });
			data.put("5", new Object[] { "4", "Pan", "Chan" });

			// Iterating over data and writing it to sheet
			Set<String> keySet = data.keySet();

			int rownum = 0;

			for (String key : keySet) {
				// Creating a new row in the sheet
				Row row = sheet.createRow(rownum++);

				Object[] objArr = data.get(key);

				int cellnum = 0;

				for (Object obj : objArr) {
					// This line creates a cell in the next column of that row
					Cell cell = row.createCell(cellnum++);

					if (obj instanceof String)
						cell.setCellValue((String) obj);
					else if (obj instanceof Integer)
						cell.setCellValue((Integer) obj);
				}
			}
			try {
				FileOutputStream out = new FileOutputStream(new File("D:/Preparation/sampletest.xlsx"));
				workbook.write(out);
				// Closing file output connections
				out.close();

				// Console message for successful execution of program
				System.out.println("sampletest.xlsx written successfully on disk.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test // ------------> Read the Excel the sheet
	public void readExcel() throws IOException{
		try {
			//File uploadFile = new File ("D:/Preparation/samplesheet.xlsx");
			// Reading file from local directory
			FileInputStream file = new FileInputStream(new File("D:/Preparation/samplesheet.xlsx"));
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			
			// Till there is an element condition holds true
			while (rowIterator.hasNext()) {
				
				Row row = rowIterator.next();
				
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while (cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					
					// Checking the cell type and format accordingly
					switch (cell.getCellType()) { 
					  
                    // Case 1 
                    case NUMERIC: 
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break; 
  
                    // Case 2 
                    case STRING: 
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                        
                    default:
                    	System.out.println("Unknown Type\t");
                    	break;
					}
				}
				System.out.println();
			}
			workbook.close();
            file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		ExcelReader excelReader = new ExcelReader();
//		excelReader.readExcel();
//	}

}
