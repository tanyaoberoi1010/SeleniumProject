package com.loginpage.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.loginpage.utility.ConfigFileReader;


public class Login {

WebDriver driver;

static ConfigFileReader configFileReader = new ConfigFileReader();
	//Constructor that will be automatically called as soon as the object of the class is created
	public Login(WebDriver driver) {
          this.driver = driver;
	}
	
	By uName = By.name("username");
	
	By pswd = By.name("password");
	
	By loginBtn=By.xpath("//button[@type='submit']");
	
	
	public void enterUsername(String username) {
		
		 driver.findElement(uName).sendKeys(configFileReader.getUsername());
	}

		public void enterPassword(String password) {
			driver.findElement(pswd).sendKeys(configFileReader.getPassword());
		}
		
		public void clickLogin() {
			driver.findElement(loginBtn).click();
		}
	}
