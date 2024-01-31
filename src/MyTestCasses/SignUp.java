package MyTestCasses;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class SignUp extends parametares {
	WebDriver driver = new ChromeDriver();

	@BeforeTest()
	public void MySetub() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1 )
	public void MyFirstTest() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.linkText("Create an Account")).click();

		// find element
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement CreateAnAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));

		// interact whith the elements
		FirstName.sendKeys(firstnames[randomindex]);
		LastName.sendKeys(lastnames[randomindex]);
		Email.sendKeys(EmailId);
		Password.sendKeys(commonPassword);
		ConfirmPassword.sendKeys(commonPassword);
		CreateAnAccountButton.click();

		String Welcomemsg = driver.findElement(By.className("message-success")).getText();
		assertEquals(Welcomemsg, "Thank you for registering with Main Website Store.");

	}
	
	@Test(priority = 2   )
	public void logoutprocessTest() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		assertEquals (driver.getCurrentUrl().contains("logout"), true);
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority = 3 )
	public void loginprocessTest() throws InterruptedException  {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(EmailId);
		driver.findElement(By.id("pass")).sendKeys(commonPassword);
		driver.findElement(By.id("send2")).click();
		Thread.sleep(4000);
		System.out.println(driver.findElement(By.cssSelector(".greet.welcome")).getText() );
		String welcomeMsg = driver.findElement(By.cssSelector(".greet.welcome")).getText() ;
		assertEquals(welcomeMsg.contains("Welcome,"), true);
				
	}
	
	@Test(priority = 4)
	public void addItemRandomly ( ) throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
	WebElement ItemContanar = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
	int theNumberOfTagName = ItemContanar.findElements(By.tagName("li")).size();
	System.out.println(theNumberOfTagName+ "the number of li");
	int randomItem = rand.nextInt(4);
	ItemContanar.findElements(By.tagName("li")).get(randomItem).click();
	WebElement sizeContanar = driver.findElement(By.cssSelector(".swatch-attribute.size"));
	int theSizes = sizeContanar.findElements(By.className("swatch-option")).size() ;
	sizeContanar.findElements(By.className("swatch-option")).get(rand.nextInt(theSizes)).click();
	Thread.sleep(2000);
	
	WebElement colorsContaner = driver.findElement(By.cssSelector(".swatch-attribute.color"));
	int theSColores = colorsContaner.findElements(By.className("swatch-option")).size() ;
	colorsContaner.findElements(By.className("swatch-option")).get(rand.nextInt(theSColores)).click();
	driver.findElement(By.id("product-addtocart-button")).click();
	Thread.sleep(5000);
	String acctualMsg = driver.findElement(By.cssSelector(".page.messages")).getText();
	
	assertEquals(acctualMsg.contains("You added"), true);
	
	
	
		
	}
	

}
