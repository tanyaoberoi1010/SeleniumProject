package com.loginpage.ActionDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.loginpage.baseclass.HomePage;
import com.loginpage.pageobjects.Dashboard;
import com.loginpage.pageobjects.Login;
import com.loginpage.utility.ConfigFileReader;

public class TestLogin {


	   static ConfigFileReader configFileReader ;
		public static void main(String[] args) throws InterruptedException {
		 
	
		WebDriver driver = new ChromeDriver();
		try {
			driver.get(configFileReader.getApplicationUrl());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Creating object of home page
		HomePage home = new HomePage(driver);
		
		//Creating object of Login page
		Login login = new Login(driver);
	
		Dashboard dashboard = new Dashboard(driver);
		
		//Click on Login button
		home.clickLogin();
		
	
		login.enterUsername("Tanya@gmamil.com");
		login.enterPassword("Mango123#");
		
		//Click on login button
		login.clickLogin();

		Thread.sleep(3000);


		//Capture the page heading and print on console
		System.out.println("The page heading is --- " +dashboard.getHeading());

		//Click on Logout button
		dashboard.clickLogout();

       //Close browser instance
		driver.quit();


}
}