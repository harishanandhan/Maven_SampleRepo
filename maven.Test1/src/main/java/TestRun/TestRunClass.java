package TestRun;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import BaseTest.Test1;
import Page.HomePage;

public class TestRunClass {
	WebDriver driver;

	public String firstName = "Hari";
	public String lastName = "A";
	public String address = "Rengasamy street, Arumbavur Post, Perambalur District";
	public String hoverName = "Provide a valid email id for further updates";
	public String emailID = "anandhanhari1999@gmail.com";
	public String phoneNo = "8248959280";
	public List<String> languagesNameList = Arrays.asList(
			"Arabic|Bulgarian|Catalan|Croatian|Czech|Danish|Dutch|English|Estonian|Filipino|Finnish|French|German|Greek|Hebrew|Hindi|Hungarian|Icelandic|Indonesian|Italian|Japanese|Korean|Latvian|Lithuanian|Malay|Norwegian|Persian|Polish|Portuguese|Romanian|Russian|Serbian|Slovak|Slovenian|Spanish|Swedish|Thai|Turkish|Ukrainian|Urdu|Vietnamese"
					.split("\\|"));
	public List<String> languagesToSelect = Arrays
			.asList("Arabic|Japanese|Korean|Latvian|Lithuanian|Malay".split("\\|"));

	@Test
	public void sample() throws Exception {
		Test1 test1 = new Test1(driver);
		driver = test1.launchBrowser();
		HomePage homepage = new HomePage(driver);
		homepage.clickName();
		homepage.enterFirstAndLastName(firstName, lastName);
		homepage.enterAddress(address, true);
		homepage.hoverEmailBox(hoverName);
		homepage.enterEmailAndNumber(emailID, phoneNo);
		/*
		 * homepage.clickRadioButtonMale(); homepage.clickRadioButtonFemale();
		 */
		// homepage.clickCheckBox("Movies");
		homepage.clickRadioButton("male");
		homepage.clickOnMultipleCheckBox();
		homepage.verifyLanguageBoxOpen();
		languagesNameList.equals(homepage.toGetLanguagesList());
		homepage.clickLanguages(languagesToSelect);
		//driver.quit();
	}

}
