package com.loginpage.ActionDriver;

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
			
	}
}