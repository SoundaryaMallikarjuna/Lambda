package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import library.BaseClass;

public class SimpleFormPage extends BaseClass {
	WebDriver driver;
	By form= By.xpath("//a[text()='Simple Form Demo']");
	By msginput =By.id("user-message");
	By msgcheckedbtn = By.id("showInput");
	By msgdisplayed = By.id("message");
	
	public SimpleFormPage(WebDriver driver) 
	{
	     this.driver = driver;
	}
	
	public void clickFormBtn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(form));
        driver.findElement(form).click();
    }

    public void enterMessage(String message) {
        driver.findElement(msginput).sendKeys(message);
    }

    public void clickShowMessage() {
        driver.findElement(msgcheckedbtn).click();
    }

    public String getDisplayedMessage() {
        return driver.findElement((By) msgdisplayed).getText();
    }
}

