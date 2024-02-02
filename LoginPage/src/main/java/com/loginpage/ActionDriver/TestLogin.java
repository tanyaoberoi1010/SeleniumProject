package com.loginpage.ActionDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
				driver.findElement(profile).click();//click on the profile logo on the homepage
				
				By logout=By.xpath("//a[@href='/sign_out']");
				driver.findElement(logout).click();
				
				String homepage=driver.getTitle();
				
				if(driver.getTitle().equals("Learn to Code - for Free | Codecademy"))
				{
					System.out.println("Logout successful");
				}
				else
				{
					System.out.println("You are still logged innnn!!!");
				}
				
			
	}
}