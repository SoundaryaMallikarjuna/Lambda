package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import library.BaseClass;

public class DragDropSlidersPage extends BaseClass {
	WebDriver driver;
	By ddsliders=By.linkText("Drag & Drop Sliders");
	By rangeValue = By.id("rangeSuccess");
	By slider=By.xpath("//input[@value='15']");
	
	public DragDropSlidersPage(WebDriver driver) 
	{
	     this.driver = driver;
	}
	
	public void clickddsliders() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(ddsliders));
        driver.findElement(ddsliders).click();
    }
	
	public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // JavaScript code to highlight the element
        js.executeScript("arguments[0].style.border='3px solid red';", element);
    }

	public void moveSliderTo(int targetValue) {
        WebElement sliderElement = driver.findElement(slider);
        WebElement sliderRangeValue = driver.findElement(rangeValue);
        System.out.println(sliderRangeValue.getText());
        Actions actions = new Actions(driver);      
        int moveByOffset = 215; 
        actions.dragAndDropBy(sliderElement, moveByOffset, 0).perform();
        Assert.assertEquals(sliderRangeValue.getText(), "95", "Slider value is not 95!");
            
    }

    public String getSliderRangeValue() {
        return driver.findElement(rangeValue).getText();
    }
}

