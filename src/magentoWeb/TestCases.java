package magentoWeb;

import java.nio.channels.Selector;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.command.InspectExecResponse.Container;

public class TestCases {
	WebDriver driver = new ChromeDriver();
	String url = "https://automationteststore.com/";
	String SignUp = "https://automationteststore.com/index.php?rt=account/login";
	String LogInPage = "https://automationteststore.com/index.php?rt=account/logout";
	Random rand = new Random();

	String[] UserNames = { "Ahmad", "Abd", "mohammed" };
	String[] LastNames = { "seemadi", "smadeei", "smadiee" };

	String[] UserTelephone = { "0796632165", "0776232848", "0797166460" };
	String[] UserFax = { "+1(555)123-4567", "+44(20)12345678", "+966(11)12345678" };

	String UserPassword = "Smadi@123";

	String[] Companys = { "XYZ", "ABC", "GlobalSolutionsLtd" };
	String[] Addresse1 = { "123MainStreet", "789TechLane", "111TechAvenue" };
	String[] Addresse2 = { "Suite456", "BuildingC", "Floor3" };
	String[] CompnyCitys = { "InnovationCity", "Metropolis", "ProgressCity" };

	String[] CompnyZIPCode = { "10001", "77777", "54321" };

	int randomIndex = rand.nextInt(3);
	int randomEmailID = rand.nextInt(1111);
	String UserFirstName = UserNames[randomIndex];
	String UserLastName = LastNames[randomIndex];
	String email_Address = UserFirstName + UserLastName + randomEmailID + "@gmail.com";

	String Telephones = UserTelephone[randomIndex];

	String Faxs = UserFax[randomIndex];

	String Addresses1 = Addresse1[randomIndex];
	String Addresses2 = Addresse2[randomIndex];
	String Citys = CompnyCitys[randomIndex];

	String ZIPCodes = CompnyZIPCode[randomIndex];

	String Compny = CompnyCitys[randomIndex];

	@BeforeTest
	public void SetUp() throws InterruptedException {

		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get(SignUp);

	}

	@Test(priority = 1)
	public void MyTest() throws InterruptedException {
		WebElement ContinueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
		ContinueButton.click();

		WebElement UserName = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement Lastname = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement Email = driver.findElement(By.id("AccountFrm_email"));
		WebElement Telephone = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement Fax = driver.findElement(By.id("AccountFrm_fax"));
		WebElement Company = driver.findElement(By.id("AccountFrm_company"));
		WebElement Address1 = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement Address2 = driver.findElement(By.id("AccountFrm_address_2"));
		WebElement City = driver.findElement(By.id("AccountFrm_city"));
		Thread.sleep(3000);
		WebElement mySelectReagon = driver.findElement(By.name("zone_id"));
		Select selector = new Select(mySelectReagon);

		WebElement ZIPCode = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement MySelectorCountry = driver.findElement(By.id("AccountFrm_country_id"));
		Select selectors = new Select(MySelectorCountry);
		WebElement Loginname = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement Password = driver.findElement(By.id("AccountFrm_password"));
		Thread.sleep(2000);
		WebElement PasswordConfirm = driver.findElement(By.id("AccountFrm_confirm"));

		UserName.sendKeys(UserFirstName);
		Thread.sleep(2000);
		Lastname.sendKeys(UserLastName);
		Thread.sleep(2000);
		Email.sendKeys(email_Address);
		Thread.sleep(2000);
		Telephone.sendKeys(Telephones);
		Thread.sleep(2000);
		Fax.sendKeys(Faxs);
		Thread.sleep(2000);
		Company.sendKeys(Compny);
		Thread.sleep(2000);
		Address1.sendKeys(Addresses1);
		Thread.sleep(2000);
		Address2.sendKeys(Addresses2);
		Thread.sleep(2000);
		City.sendKeys(Citys);
		Thread.sleep(2000);
		selectors.selectByValue("221");

		Thread.sleep(2000);
		ZIPCode.sendKeys(ZIPCodes);
		Thread.sleep(2000);
		selector.selectByValue("3510");
		Thread.sleep(2000);
		Loginname.sendKeys(UserFirstName + UserLastName);
		Thread.sleep(2000);
		Password.sendKeys(UserPassword);
		Thread.sleep(2000);
		PasswordConfirm.sendKeys(UserPassword);
		Thread.sleep(2000);
		WebElement Subscribe = driver.findElement(By.xpath("//label[@for='AccountFrm_newsletter1']"));
		Subscribe.click();
		Thread.sleep(2000);
		WebElement AccountFrmagree = driver.findElement(By.id("AccountFrm_agree"));
		AccountFrmagree.click();
		Thread.sleep(2000);

		WebElement ContinueButtn = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
		ContinueButtn.click();
	}

	@Test(priority = 2)
	public void LoginTest() throws InterruptedException {

		Thread.sleep(3000);
		
		driver.get(LogInPage);

		WebElement log = driver.findElement(By.xpath("//a[normalize-space()='Login or register']"));
		log.click();
		WebElement LogNameButton = driver.findElement(By.id("loginFrm_loginname"));
		LogNameButton.sendKeys(UserFirstName + UserLastName);
		
		
		Thread.sleep(3000);
		WebElement PasswordLogIn = driver.findElement(By.cssSelector("#loginFrm_password"));
		PasswordLogIn.sendKeys(UserPassword);

		Thread.sleep(3000);

		WebElement CreatLoginButton = driver.findElement(By.cssSelector("button[title='Login']"));
		CreatLoginButton.click();
	
	
	String Actualmessgofwebsit = driver.findElement(By.cssSelector("div[class='menu_text']")).getText();
	Assert.assertEquals(Actualmessgofwebsit,"Welcome back"+UserNames, "this is to test the langauge");

	}
	@AfterTest
	public void MyAfterTest() {
	}

}
