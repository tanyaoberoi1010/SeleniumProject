package com.loginpage.ActionDriver;

import org.openqa.selenium.By;
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
				{System.out.println("Please try again!!!");
				}
				
				//Sign out
				
				By profile=By.xpath("//button[@data-testid='avatar-dropdown-button']");
				driver.findElement(profile).click();

		      
		 
		      
		        By logout=By.xpath("//a[role=['menuitem']");
				driver.findElement(logout).click();
		        
				String homepage=driver.getTitle();
				if(homepage.equals("Learn to Code - for Free | Codecademy"))
				{
					System.out.println("Logout successful");
				}
				else
				{
					System.out.println("You are still logged innnn!!!");
				}
				
			
	}
}