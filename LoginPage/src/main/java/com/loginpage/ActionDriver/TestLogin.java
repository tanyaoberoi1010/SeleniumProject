package com.loginpage.ActionDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.loginpage.baseclass.HomePage;
import com.loginpage.pageobjects.Dashboard;
import com.loginpage.pageobjects.Login;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

public class TestLogin {

public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "---Exact path to chromedriver.exe---");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.demoqa.com/books");
		
		//Creating object of home page
		HomePage home = new HomePage(driver);
		
		//Creating object of Login page
		Login login = new Login(driver);
		
		//Creating object of Dashboard
		Dashboard dashboard = new Dashboard(driver);
		
		//Click on Login button
		home.clickLogin();
		
		//Enter username & password
		login.enterUsername("---Your Username---");
		login.enterPassword("---Your Password---");
		
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