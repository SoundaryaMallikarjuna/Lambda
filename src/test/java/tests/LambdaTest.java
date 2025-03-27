package tests;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import library.BaseClass;
import pages.DragDropSlidersPage;
import pages.InputFormPage;
import pages.SimpleFormPage;

public class LambdaTest extends BaseClass {
	//SimpleFormPage form;
	
	 @Test
	    public void testSimpleForm() throws IOException {
	        driver.get("https://www.lambdatest.com/selenium-playground");
	        takeScreenshot("Step1_Open_LambdaTest");
	        SimpleFormPage formPage = new SimpleFormPage(driver);
	        formPage.clickFormBtn();
	        takeScreenshot("Step2_Click_SimpleFormDemo");
	        String currentUrl = driver.getCurrentUrl();
	        Assert.assertTrue(currentUrl.contains("simple-form-demo"), "URL does not contain 'simple-form-demo'");
	        takeScreenshot("Step3_URL_Validation");
	        String message = "Welcome to LambdaTest";
	        formPage.enterMessage(message);
	        takeScreenshot("Step4_Message is entered");
	        formPage.clickShowMessage();	        
	        Assert.assertEquals(formPage.getDisplayedMessage(), message, "Message does not match!");
	        takeScreenshot("Step5_Button is clicked and message is displayed");
	    }
	 
	 public void takeScreenshot(String stepName) throws IOException {
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destination = new File("screenshots/" + stepName + ".png");
	        FileUtils.copyFile(screenshot, destination);
	        System.out.println("Screenshot saved as: " + destination.getAbsolutePath());
	    }
	 	 
	 
	 @Test
	    public void testSlider() throws Exception {
	        driver.get("https://www.lambdatest.com/selenium-playground");
	       	DragDropSlidersPage sliderPage = new DragDropSlidersPage(driver);
	        sliderPage.clickddsliders();
	        takeScreenshot("Step7_Click_DragDropSliders");
	        sliderPage.moveSliderTo(95);
	        Assert.assertEquals(sliderPage.getSliderRangeValue(), "95");
	        takeScreenshot("Step8_DragDropSliders is moved and  value is matched");
	 } 
	 
	 @Test
	    public void testInputForm() throws Exception {
	        driver.get("https://www.lambdatest.com/selenium-playground");
	        InputFormPage inpfrmPage = new InputFormPage(driver);
	        inpfrmPage.clickInputForm();
	        takeScreenshot("Step9_Click_InputFormPage");
	        inpfrmPage.clickSubmit();
	        takeScreenshot("Step10_Error message is displayed");
	        inpfrmPage.fillFormDetails();
	        takeScreenshot("Step11_All the form details are filled and sucess message is displayed");  
	
	 } 
	 
	 
}
	


