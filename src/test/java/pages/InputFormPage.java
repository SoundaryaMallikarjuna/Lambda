package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import library.BaseClass;

public class InputFormPage extends BaseClass {
	WebDriver driver;
	By submit=By.xpath("(//button[@type='submit'])[2]");
	By errormsg =By.cssSelector("input:invalid");
	By inpform=By.xpath("//a[text()='Input Form Submit']");
	By name=By.name("name");
	By email=By.id("inputEmail4");
	By pwd=By.name("password");
	By cmp=By.name("company");
	By website=By.name("website");
	By cntry=By.name("country");
	By city=By.name("city");
	By adr1=By.name("address_line1");
	By adr2=By.name("address_line2");
	By state=By.id("inputState");
	By zipcode=By.name("zip");
	By successmsg=By.className("success-msg");
	
	public InputFormPage(WebDriver driver) 
	{
	     this.driver = driver;
	}
	
	public void clickInputForm() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement inputFormSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(inpform));
		inputFormSubmitButton.click();
    }
	
	public void clickSubmit() {
        driver.findElement(submit).click();
       WebElement errorElement = driver.findElement(errormsg);
        String validationMessage = errorElement.getAttribute("validationMessage");
        assert validationMessage.equals("Please fill out this field.") : "Error message not as expected";
	}
	
	public void fillFormDetails() {
		driver.findElement(name).sendKeys("Soundarya M");
        driver.findElement(email).sendKeys("sm@example.com");
        driver.findElement(pwd).sendKeys("1234567890");
        driver.findElement(cmp).sendKeys("LambdaTest");
        driver.findElement(website).sendKeys("https://example.com");
        
        WebElement country = driver.findElement(cntry);
        Select countryDropdown = new Select(country);
        countryDropdown.selectByVisibleText("United States");
        
        driver.findElement(adr1).sendKeys("123 Main St");
        driver.findElement(adr2).sendKeys("Suite 5B");
        driver.findElement(city).sendKeys("New York");
        driver.findElement(state).sendKeys("NY");
        driver.findElement(zipcode).sendKeys("10001");
        
        driver.findElement(submit).click();
        
        WebElement successMessage = driver.findElement(successmsg);
        Assert.assertTrue(successMessage.getText().contains("Thanks for contacting us, we will get back to you shortly."), "Success message not displayed");
        
	}
	
}
