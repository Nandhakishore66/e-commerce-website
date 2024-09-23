package selenium;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class ECommerceWebsite {

	private Object gmail;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\Automation\\driver\\chromedriver.exe");
		
		// Launch the browser
		 WebDriver driver = new ChromeDriver();
		 // Url of the website
		 driver.get(" http://automationpractice.com/index.php");
		 
		 //For doing the mouse over actions use---->Actions Class
		 Actions obj=new Actions(driver);
		 
		 //Move the cursor to the women tab
		 obj.moveToElement(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"))).build().perform();
		 
		 
		 //Then click on the Sub-menu tShirts
		WebElement tShirts= driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		tShirts.click();
		Thread.sleep(3000);
		
		 
		//Move the cursor over the 1st Product
		obj.moveToElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")));
		
		//Click on the more button
		WebElement more=driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]/span"));
		more.click();
		
		//Increase the Quantity to 2
		WebElement increaseQuantity=driver.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span/i"));
		increaseQuantity.click();
		
		//Select the Size L... Find the element
		WebElement sizeOfTshirts= driver.findElement(By.id("group_1"));
		
		//Dropdown=It is mostly in the select, so we need to create class for select
		Select select=new Select(sizeOfTshirts);
		select.selectByValue("3");
		
		//select different color
		WebElement color=driver.findElement(By.id("color_14"));
		color.click();
		
		//Then click add to cart button 
		WebElement addToCart=driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		addToCart.click();
		
		//it is used to delay the process for 3 seconds becoz, the process excecutes too faster
		Thread.sleep(4000);
		
		//Now click on proceed to checkout button
		WebElement checkOut=driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
		checkOut.click();
		
		//Buy order process till payment
		WebElement proceedTo=driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span"));
		proceedTo.click();
		
		//Enter the email to create a account
		WebElement emailCreate=driver.findElement(By.id("email_create"));
		emailCreate.sendKeys("nandha7782@gmail.com");
		
		//Now click on the create an Account button
		WebElement createAccountButton=driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span"));
		createAccountButton.click();
		
		//Becoz of fast process use delay function
		Thread.sleep(4000);
		
		//Enter the title Mr or Mrs
		WebElement title=driver.findElement(By.id("id_gender1"));
		title.click();
		
		//Enter the first name
		WebElement firstName=driver.findElement(By.id("customer_firstname"));
		firstName.sendKeys("Nandhakishore");
		
		//Enter the last name
		WebElement lastName=driver.findElement(By.id("customer_lastname"));
		lastName.sendKeys("ravi");
		
		
		//Enter the Password
		WebElement pass=driver.findElement(By.id("passwd"));
		pass.sendKeys("Nav123");
		
		//dob=days
		WebElement days=driver.findElement(By.id("days"));
		Select dob=new Select(days);
		dob.selectByValue("6");
		
		//dob=months
		WebElement months=driver.findElement(By.id("months"));
		Select mon=new Select(months);
		mon.selectByValue("6");
		
		//dob=years
		WebElement years=driver.findElement(By.id("years"));
	    Select year=new Select(years);
	    year.selectByValue("2001");
		
	    //address line 1
	    WebElement address1=driver.findElement(By.id("address1"));
	    address1.sendKeys("111,MCDC(p.o)");
	    
	    //City
	    WebElement city=driver.findElement(By.id("city"));
	    city.sendKeys("Salem");
	    
	    //state
	    WebElement state=driver.findElement(By.id("id_state"));
	    state.sendKeys("Indiana");
	    
	    // postal code
	    WebElement postalCode=driver.findElement(By.id("postcode"));
	    postalCode.sendKeys("66611");
	    
	    //country
	    WebElement country=driver.findElement(By.id("id_country"));
	    Select us=new Select(country);
	    us.selectByVisibleText("United States");
	    
	    //mobile number 
	    WebElement mobileNumber=driver.findElement(By.id("phone_mobile"));
	    mobileNumber.sendKeys("6369709904");
	    
	    //Address for future reference
	    WebElement alias=driver.findElement(By.id("alias"));
	    alias.sendKeys(" Chennai");
	    
	    //Register button
	    WebElement register=driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span/i"));
	    register.click();
	    
	    //Capture
	    TakesScreenshot screenshot=(TakesScreenshot) driver;
	    File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
	    File destFile=new File("C:\\Users\\ELCOT\\Pictures\\Screenshots\\first.png");
	    Files.copy(srcFile, destFile);
	    
	    //Address proceed to checkout
	   WebElement addressCheckout= driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span"));
	    addressCheckout.click();
	    
	    //Agree the terms of service
	    WebElement termsOfService=driver.findElement(By.id("cgv"));
	    termsOfService.click();
	    
	    //Shipment proceed to checkout
	    WebElement shippingCheckout=driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span"));
	    shippingCheckout.click();
	    
	    //Completed
	    System.out.println("Automation Completed Successfully.");
	    
	    //Close
	    driver.close();
	    
		
		
		
		

	}

}
