package Page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import BaseTest.Test1;


public class HomePage {
	
	public WebDriver driver;
	Test1 test1;
	
	@FindBy(xpath = "//input[@id='dragAndDrop']")
	WebElement dragAndDrop;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement clickFirstPlace;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement clickSecPlace;
	
	@FindBy(css = "div [ng-model='Adress']")
	WebElement clickAddress;
	
	@FindBy(css = "*.col-sm-4.col-xs-4.tooltptext > span")
	WebElement hoverEmail;
	
	@FindBy(css = "input[type='Email']")
	WebElement givenEmail;
	
	@FindBy(css = "input[type='tel']")
	WebElement givenNumber;
	
	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")
	WebElement radioButtonMale;
	
	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input")
	WebElement radioButtonFemale;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> checkBoxes;
	
	@FindBy(css = "label.checks")
	List<WebElement> labelBoxName;
	
	@FindBy(xpath = "//*[@id=\"basicBootstrapForm\"]/div[5]/div/label/text()")
	List<WebElement> radioButton;
	
	@FindBy(css = "div.ui-autocomplete-multiselect")
	WebElement languageBox;
	
	@FindBy(css = "#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul")
	WebElement languageBoxOpenState;
	
	@FindBy(css = "#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul > li")
	List<WebElement> languagesNames;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		test1 = new Test1(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(finder, this);
	}
	
	public boolean clickName() { 	
		boolean Status = false;
		test1.clickJS(driver, clickFirstPlace);
			if (Test1.waitForElement(driver, clickFirstPlace, 10)) {
				Status = true;
				test1.event("Click on First Name");
			} else test1.event("Unable to Click on First Name");
			return Status;
		  }
	 
	public void enterFirstAndLastName(String name1, String name2) {
		test1.event("Enter First Name And Last Name");
		if (clickFirstPlace.isDisplayed()){
			clickFirstPlace.sendKeys(name1);
			clickFirstPlace.sendKeys(Keys.ENTER);
			clickSecPlace.sendKeys(name2);
			test1.message("Sucessfully Added First and Last Name", true);
		} else test1.event("Unable To Add First And Last Name");
	}
	
	public void enterLastName(String name) {
		if (clickSecPlace.isDisplayed()){
			clickSecPlace.sendKeys(name);
		}
	}
	
	public void enterAddress(String name, boolean screenShot) {
		test1.event("Enter Address in Address Box");
		if (clickAddress.isDisplayed()){
			clickAddress.click();
			clickAddress.sendKeys(name);
			test1.message("Sucessfully Added Address in Address Box", screenShot);
		} else test1.event("Unable To Add Address");
	}
	
	public void hoverEmailBox(String name) {
		WebElement elementToHover = driver.findElement(By.cssSelector("input[type='Email']"));
		Actions action = new Actions(driver);
	    action.moveToElement(elementToHover).build().perform();
	    //boolean actualName = Test1.verifyWebElementTextEquals(driver, hoverEmail, name);
	    String actualNames = Test1.getTextOfWebElement(hoverEmail, driver);
	    if (actualNames.equals(name)) {
	    	System.out.println("Text matches the expected value.");
        } else System.out.println("Text does not match the expected value.");
	    	}
	
	public void enterEmailAndNumber(String email, String number) {
		test1.event("Enter an Email");
		if (givenEmail.isDisplayed()) {
			givenEmail.click();
			givenEmail.sendKeys(email);
			givenEmail.sendKeys(Keys.ENTER);
			givenNumber.sendKeys(number);
			test1.message("Sucessfully Added Email and Number", true);
		} else test1.message("Unable to Add Email and Number", true);
			}
	
	public void clickRadioButtonMale() {
		test1.event("Click on Radio Button in Male");
		radioButtonMale.click();	
		}
	
	public void clickRadioButtonFemale() {
		test1.event("Click on Radio Button in Female");
		radioButtonFemale.click();	
		}
	
	public void clickRadioButton(String gender) {
	    switch(gender.toLowerCase()) {
	        case "male":
	            test1.event("Click on Radio Button in Male");
	            test1.clickJS(driver, radioButtonMale);
	            break;
	        case "female":
	            test1.event("Click on Radio Button in Female");
	            test1.clickJS(driver, radioButtonFemale);
	            break;
	        default:
	            // Handle invalid input or throw an exception
	            throw new IllegalArgumentException("Invalid gender: " + gender);
	    }
	}
	
	public void clickCheckBox(String expectName) throws Exception{
		test1.event("Click on Check Box in Hobbis.");
			/*
			 * WebElement checkBody = givenBoxName.stream() .filter((element) ->
			 * Test1.getTextOfWebElement(element, driver).equals(expectName))
			 * .findFirst().orElse(null); checkBoxBody =
			 * checkBody.findElement(By.xpath("..")).findElement(By.cssSelector(
			 * "label.checks"));
			 */
			int index = 0;
			for (WebElement checkbox : checkBoxes) {
			    if (index <  labelBoxName.size()) {
			        String expectedName = labelBoxName.get(index++).getText();
			        if (expectedName.equals(expectName))
			        {
			        checkbox.click();
			        boolean isChecked = checkbox.isSelected();
			        // Perform further assertions or logging as needed
			        test1.message("Checkbox Clicked: " + expectedName + ", Checked: "+ isChecked, true);
			        } 
			    } else test1.event("Unable to click on Check box.");
			}					
		}
	
	public void clickOnMultipleCheckBox() {
		test1.event("Click on Check Box in Hobbis.");
		int index = 0;
		for (WebElement checkbox : checkBoxes) {
			if (index < labelBoxName.size()) {
				String expectedName = labelBoxName.get(index++).getText();
				checkbox.click();
				boolean isChecked = checkbox.isSelected();
				// Perform further assertions or logging as needed
				test1.message("Checkbox Clicked: " + expectedName + ", Checked: "+ isChecked, true);
				//System.out.println("Checkbox clicked: " + expectedName + ", Checked: " + isChecked);
			} else break; // Break loop if all checkboxes from the given list are processed
		}
			}
	
	public void clickLanguageBox() {
		test1.event("Click on LanguageBox");
		test1.click(languageBox);
		}
	
	public boolean verifyLanguageBoxOpen() {
		test1.event("Verify Language box Open or Close");
		boolean Status = false;
		test1.clickJS(driver, languageBox);
		//languageBox.click();
		if (Test1.waitForElement(driver, languageBoxOpenState, 10)) {
			Status = true;
			test1.message("Language box is opened", true);
		} else test1.message("Unable to Open Language box", true);
		return Status;
	} 
	
	public List<String> toGetLanguagesList()  {
		test1.event("To verify Languages list");
		List<String> actualList = test1.getAllTextFromWebElementList(driver.findElements(By.cssSelector("#basicBootstrapForm > div:nth-child(7) > div > multi-select > div:nth-child(2) > ul > li")));
		return actualList;
	}
	
	public void clickLanguages(List<String> languagesToClick) {
		int index = 0;
		try {
			int i = 0;
			for (WebElement languagesName : languagesNames) {
				String expectedName = languagesNames.get(index++).getText();
				Actions actions = new Actions(driver);
				// Scroll to the dropdown element
				actions.moveToElement(languagesName).perform();
				if (expectedName.equals(languagesToClick.get(i))) {
					test1.clickJS(driver, languagesName);
					i += 1;
					System.out.println("Clicked language '" + languagesToClick + "' in this language box.");
				} else System.out.println("Language '" + languagesToClick + "' not found in this language box.");	
			}
		} catch (Exception e) {
			System.out.println("Language '" + languagesToClick + "' not found in this language box.");
		}
	}
	}