package com.loginpage.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login {

WebDriver driver;

	
	//Constructor that will be automatically called as soon as the object of the class is created
	public Login(WebDriver driver) {
          this.driver = driver;
	}
	
	By uName = By.id("email");
	
	By pswd = By.id("password");
	
	//Locator for login button
	By loginBtn = By.id("submit-button");
	
	
	public void enterUsername(String user) {
		driver.findElement(uName).sendKeys(user);
	}

		public void enterPassword(String pass) {
			driver.findElement(pswd).sendKeys(pass);
		}
		
		public void clickLogin() {
			driver.findElement(loginBtn).click();
		}
	}
