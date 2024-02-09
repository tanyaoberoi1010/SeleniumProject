package com.loginpage.ActionDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.loginpage.baseclass.HomePage;
import com.loginpage.pageobjects.Login;
import com.loginpage.utility.ConfigFileReader;

public class TestLogin {


	static ConfigFileReader configFileReader = new ConfigFileReader();
	public static void main(String[] args) throws InterruptedException {
		 
		System.setProperty("webdriver.gecko.driver",
				"/Users/tanyaoberoi/Downloads/chromedriver-mac-x64");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(configFileReader.getApplicationUrl());
		
				Login login = new Login(driver);
			
				login.enterUsername(configFileReader.getUsername());
				login.enterPassword(configFileReader.getPassword());
				login.clickLogin();//Click on login button
				Thread.sleep(3000);
				
				//Valid Login
				String title=driver.getTitle();
					
				if(title.equals("My Home | Codecademy")) {
					System.out.println("Login successful");
					
				}
				else
				{
				
					By validpassword=By.cssSelector("span[data-testid='error-text'][aria-live='polite']");
				    WebElement validation=driver.findElement(validpassword);
				    
			    String errorText=validation.getText();
			
						if(errorText.contains("Invalid email or password"))
						
						{
							  System.out.println("Password or email is incorrect");
							  
				        } 
				}
				
				//Sign out
			
				try {
				// Find the menu container by its ID
				WebElement menuContainer = driver.findElement(By.id("menu-containerProfile"));
				System.out.println(menuContainer);
				
				WebElement optionToSelect = menuContainer.findElement(By.cssSelector("li:nth-child(5)"));
				// Find the list items within the menu container
				// You may need to adjust the selector if there are multiple menus on the page
				// In this case, we're assuming that the list items are direct children of the menu container
				// and using a CSS selector to find them
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
				wait.until(ExpectedConditions.invisibilityOf(optionToSelect));
				
			
				//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				optionToSelect.click();
				} 
				
				
				catch (ElementNotInteractableException e) 
				{
                System.out.println("Element not interactable: " + e.getMessage());
				// Click on the link within the list item to select the option
				}
				}		
}
