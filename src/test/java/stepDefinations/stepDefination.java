package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
public class stepDefination {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable 
	{
    	
        System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
        driver= new ChromeDriver();
        wait=new WebDriverWait(driver,5);
    }

	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String user, String pass) throws Throwable
    {
    	
    	By email=By.xpath("//input[@name='email']");
    	By password=By.xpath("//input[@name='password']");
    	By login=By.cssSelector("button[type='submit']");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(user);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
    	//Thread.sleep(3000);
    	wait.until(ExpectedConditions.elementToBeClickable(login)).click();
    }

    
	@Then("^Verify that user is succesfully logged in$")
	public void verify_that_user_is_succesfully_logged_in() throws Throwable 
	{
		By text=By.xpath("//h1[@class='t-bold']");
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(text));
    	Assert.assertEquals(element.getText(), 
    			"Welcome to Bikroy.com - the largest marketplace in Bangladesh!");
    	
    }

    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable 
    {
    	
    	System.out.println(strArg1);
    	driver.get(strArg1);
    }

    @And("^Click on Login in home page to land on Secure sign in Page$")
    public void click_on_login_in_home_page_to_land_on_secure_sign_in_page() throws Throwable 
    {
    	
    	By signin=By.linkText("Log in");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(signin)).click();
    }

    @And("^close browsers$")
    public void close_browsers() throws Throwable 
    {
    	
    	driver.close();
    }

}