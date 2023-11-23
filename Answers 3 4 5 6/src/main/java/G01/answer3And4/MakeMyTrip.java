package G01.answer3And4;



import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Optional;

import org.testng.annotations.Parameters;



import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;



public class MakeMyTrip {

    WebDriver driver;

    

    public static void clickByXPath (WebDriver driver, String xpath) {

    	WebElement element = driver.findElement(By.xpath(xpath));

    	element.click();

   }



    public static void enterInputByXPath(WebDriver driver, String xpath,String input) {

    	WebElement inputElement = driver.findElement(By.xpath(xpath));

    	inputElement.sendKeys (input);

    }



	@BeforeMethod

	@Parameters("browser")

    public void setUp(@Optional("firefox") String browser) {

		 if (browser.equalsIgnoreCase("chrome")) {

	            System.setProperty("webdriver.chrome.driver", "C:\\Users\\frank.DESKTOP-2DFF4LO\\OneDrive\\Desktop\\SDET\\geckodriver.exe");

	            driver = new ChromeDriver();

	        } else if (browser.equalsIgnoreCase("firefox")) {

	            System.setProperty("webdriver.gecko.driver", "C:\\Users\\frank.DESKTOP-2DFF4LO\\OneDrive\\Desktop\\SDET\\geckodriver.exe");

	            driver = new FirefoxDriver();

	        } else {

	            throw new IllegalArgumentException("Invalid browser parameter.");

	        }

		 driver.get("https://www.makemytrip.com/");

		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 WebElement popUp = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));

		 if(popUp.isDisplayed()) {

			 popUp.click();

		 }

    }

	

    @Test

    public void answer3() {

        WebElement logo = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));

       if(logo.isDisplayed()) {

    	   System.out.println("Make My Trip Logo is present.");

       } else {

    	   System.out.println("Make My Trip Logo is not present.");

       }

     };

 

    

    @Test

    public void answer4 () {

    	clickByXPath(driver, "//li[@data-cy='menu_Flights']");

    	clickByXPath(driver, "//li[@data-cy='oneWayTrip']");

    	enterInputByXPath (driver, "//input[@id='fromCity']", "Chennai");

    	enterInputByXPath (driver, "//input[@id='toCity']", "Bengaluru");

    }





	@AfterMethod

    public void tearDown() {

        driver.quit();

    }

    

}