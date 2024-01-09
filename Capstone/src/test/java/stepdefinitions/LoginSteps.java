package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginSteps {

private WebDriver driver;


@Given("^Launch the application$") 
	public void openTheApplication() {
	System.setProperty("webdriver.chrome.driver", "C:/Users/frank.DESKTOP-2DFF4LO/eclipse-workspace/Capstone/chromedriver");
	driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
}

@When("^Enter username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enterUsernameAndPassword(String username, String password) {
	driver.findElement(By.id("user-name")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.id("login-button")).click();
}

@Then("^Title validation \"([^\"]*)\"$")
	public void titleValidation(String expectedTitle) {
	Assert.assertEquals(driver.getTitle(), expectedTitle);
}

@Then("^Close the application$") 
public void closeTheApplication() {
	driver.quit();
}

@Then("^Error message validation$")
	public void errorMessageValidation() {
	driver.findElement(By.xpath("//h3[text()=\"Epic sadface: Sorry, this user has been locked out.\"]")).isDisplayed();
}

}
