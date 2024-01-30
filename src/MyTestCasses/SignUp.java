package MyTestCasses;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends parametares {
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest()
	public void MySetub(){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	
	@Test()
	public void MyFirstTest(){
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.linkText("Create an Account")).click();
		
		//find element
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email= driver.findElement(By.id("email_address")) ;
		WebElement Password = driver.findElement(By.id("password"));
		WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement CreateAnAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));
		
		//interact whith the elements
		FirstName.sendKeys(firstnames[randomindex]);
		LastName.sendKeys(lastnames[randomindex]);
		Email.sendKeys(EmailId);
		Password.sendKeys(commonPassword);
		ConfirmPassword.sendKeys(commonPassword);
		CreateAnAccountButton.click();
		
		String Welcomemsg = driver.findElement(By.className("message-success")).getText();
		assertEquals(Welcomemsg, "Thank you for registering with Main Website Store.");

		
	}

}
