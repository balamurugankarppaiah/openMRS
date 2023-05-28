package StepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefintionClass {

	static WebDriver driver;

	 
	 
	 @Given("user open the browser")
	 public void user_open_the_browser() {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
	 }

	 @And("User launch the application {string}")
	 public void user_launch_the_application(String url) {
	     driver.get(url);
	     driver.manage().window().maximize();
	     
	     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 }

	 @When("User enter the {string} and {string}")
	 public void user_enter_the_and(String username, String password) {
		 driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);  
	 }
		 
		 @When("User click the Outpatient Clinic")
		 public void user_click_the_outpatient_clinic() {
			 driver.findElement(By.xpath("//li[@id='Outpatient Clinic']")).click();
		 }

		 @When("User Click the loginButton")
		 public void user_click_the_login_button() {
			 driver.findElement(By.xpath("//input[@id='loginButton']")).click();
		 }
		 @When("User Navigate to Patient_Register")
		 public void user_navigate_to_patient_register() {
		     driver.findElement(By.xpath("//a[contains(@id,'referenceapplication-registrationapp-registerPatient')]")).click();
		 }

		 @Then("User Enter the Patient_details")
		 public void user_enter_the_patient_details() throws InterruptedException, AWTException {
			 driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("Bala");
			 driver.findElement(By.xpath("//input[@name='familyName']")).sendKeys("Malar");
			 driver.findElement(By.xpath("//button[@id='next-button']")).click();
			 WebElement gender = driver.findElement(By.name("gender"));
			 Select uniquegender = new Select(gender);
			 uniquegender.selectByValue("F");
			 driver.findElement(By.xpath("//button[@id='next-button']")).click();
			 driver.findElement(By.xpath("//input[@name='birthdateDay']")).sendKeys("25");
		//	 Thread.sleep(3000);
			 driver.findElement(By.xpath("//*[@name='birthdateMonth']")).click();
			// Thread.sleep(3000);
			 List<WebElement> monthdropdown = driver.findElements(By.xpath("//*[@name='birthdateMonth']/option"));
			 for (WebElement webElement : monthdropdown) {
				if(webElement.getText().equals("March")) {
					webElement.click();
				}
			} 
			 driver.findElement(By.xpath("//*[@name='birthdateYear']")).sendKeys("1997"); 
			 driver.findElement(By.xpath("//*[@id='next-button']")).click();
			 driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("56/4, AnnaNagar");
			 driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("ShanthiColony");
			 driver.findElement(By.xpath("//*[@id='cityVillage']")).sendKeys("Chennai");
			 driver.findElement(By.xpath("//*[@id='stateProvince']")).sendKeys("TamilNadu");
			 driver.findElement(By.xpath("//*[@id='country']")).sendKeys("India");
			 driver.findElement(By.xpath("//*[@id='postalCode']")).sendKeys("600001");
			 driver.findElement(By.xpath("//*[@id='next-button']")).click();
			 driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9989867654");
			 driver.findElement(By.xpath("//*[@id='next-button']")).click();
			 driver.findElement(By.xpath("//*[@id='next-button']")).click();
			 driver.findElement(By.id("submit")).click();
			 driver.findElement(By.xpath("//li[@class=\"float-left\"][1]")).click();
			 driver.findElement(By.id("start-visit-with-visittype-confirm")).click();
			 
			 driver.findElement(By.id("attachments.attachments.visitActions.default")).click();
			 driver.findElement(By.id("visit-documents-dropzone")).click();
			 String file="C:\\Users\\User\\Documents\\Test.pdf_organized";
			 StringSelection selection=new StringSelection(file);
			 
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			
			
			driver.findElement(By.xpath("//textarea[@placeholder=\"Enter a caption\"]")).sendKeys("Test");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='Upload file']")).click();
			driver.findElement(By.xpath("//button[text()='Upload file']")).click();
            driver.findElement(By.xpath("(//*[contains(text(),'Bala Malar')])[1]")).click();            
            driver.findElement(By.xpath("//div[@class='col-12 col-lg-3 p-0']//descendant::div[contains(text(),'End Visit')]")).click();
    	    driver.findElement(By.xpath("//input[@id='visitId']//parent::div[@class='dialog-content']//descendant::button[text()='Yes']")).click();
    		driver.findElement(By.xpath("//div[@id='edit-patient-identifier-dialog']//following-sibling::div[@class='dashboard clear row']//descendant::div[contains(text(),'Start Visit')]")).click();
    		driver.findElement(By.xpath("//button[@id='start-visit-with-visittype-confirm']")).click();
    		driver.findElement(By.xpath("//a[contains(@id,'realTime.vitals')]")).click();
         	driver.findElement(By.id("w8")).sendKeys("111");
    		driver.findElement(By.xpath("//button[@id='next-button']")).click();
    		driver.findElement(By.id("w10")).sendKeys("55");
    		driver.findElement(By.xpath("//button[@id='next-button']")).click();
    		driver.findElement(By.xpath("//a[@id='save-form']")).click();
    		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
    		driver.findElement(By.xpath("(//div[@id='visit-details']//descendant::a[@class='button task activelist'])[1]")).click();
    		driver.findElement(By.xpath("//div[@id='simplemodal-container']//descendant::button[@class='confirm right']")).click();
    		Thread.sleep(5000);
    		driver.findElement(By.xpath("//*[@id='breadcrumbs']/li[2]/a")).click();
    		driver.findElement(By.xpath("//a[contains(@id,'mergeVisits')]")).click();
    		WebElement data1 = driver.findElement(By.xpath("//td[contains(text(),'Vitals')]//preceding-sibling::td/input[@type='checkbox']"));
    		data1.click();
    		WebElement data2 = driver.findElement(By.xpath("//td[contains(text(),'Attachment')]//preceding-sibling::td/input[@type='checkbox']"));
    		data2.click();
    		driver.findElement(By.id("mergeVisitsBtn")).click();
    		driver.findElement(By.xpath("//input[@class=\"cancel\"]")).click();
    		List<WebElement> entries = driver.findElements(By.xpath("//h3[text()='Recent Visits']//parent::div[@class='info-header']//following-sibling::div//child::ul/li"));
    		driver.findElement(By.xpath("//div[contains(text(),'Add Past Visit')]")).click();
    		boolean dayBoolean = false;
    		List<WebElement> days = driver.findElements(By.xpath("(//div[@class='datetimepicker-days'])[1]//descendant::td[@class='day disabled']"));
    		int daysSize = days.size();
    		int count = 0;
    		for (WebElement day : days) {
    			if (day.getAttribute("class").equals("day disabled")) {
    				count++;
    			}
    			if (daysSize == count) {
    				dayBoolean = true;
    			}
    		}
    		driver.findElement(By.xpath("//div[@id='retrospective-visit-creation-dialog']//descendant::button[@class='cancel']")).click();
    		driver.findElement(By.xpath("//div[contains(text(),'Delete Patient')]")).click();
    		driver.findElement(By.xpath("//input[@id='delete-reason']")).sendKeys("Testing the application");
    		driver.findElement(By.xpath("//input[@id='delete-reason']//parent::div//child::button[@class='confirm right']")).click();
    		driver.findElement(By.xpath("//input[@id='patient-search']")).sendKeys("BALA");
            Thread.sleep(5000);
    		driver.close();		 
		 }
	 
}
