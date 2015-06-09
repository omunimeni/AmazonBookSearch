package cucumber.feature;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	WebDriver driver = null;
	
	@Given("^I go to URL$")
	public void IgotoURL() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\george.negreanu\\Desktop\\eclipse-jee-indigo-SR2-win32-x86_64\\eclipse\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.get("http://www.amazon.com");
		Thread.sleep(2000);
	}


    @When("^I search for a book$")
    public void Isearchforabook() throws Throwable {
	 // Select Books category    
	 Select oSelection = new Select(driver.findElement(By.id("searchDropdownBox")));
     oSelection.selectByVisibleText("Books");
     
     // search for a book
     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Game Of Thrones");
     driver.findElement(By.className("nav-input")).click();
     driver.findElement(By.linkText("A Game of Thrones (A Song of Ice and Fire, Book 1)")).click();
     Thread.sleep(2000);
    }
    
    @When("^I add the book to cart$")
    public void i_add_the_book_to_cart() throws Throwable {
        // 
       driver.findElement(By.id("add-to-cart-button")).click();
       Thread.sleep(2000);
    }

    @Then("^The book is in cart$")
    public void the_book_is_in_cart() throws Throwable {
        // 
   System.out.println(
		   driver.findElement(By.partialLinkText("A Game of Thrones (A Song of")).getAttribute("title"));
    }

}
