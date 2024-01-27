package com.loginpage.pageobjects;

import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	
	//System.out.println("Ok");
	WebElement username=driver.findElement(By.id("email"));
    WebElement password=driver.findElement(By.name("pass"));
    WebElement loginbtn=driver.findElement(By.name("login"));
    //System.out.println("Ok");
	username.sendKeys("tanyaoberoi1010@gmail.com");
	password.sendKeys("samjhawan");
	//System.out.println("Ok");
	loginbtn.click();
	
	
	String current_url=driver.getCurrentUrl();
	
	if(current_url.toString()== "https://www.facebook.com/home.php")
	{
		System.out.println("Login is succesful");
	
	}
	
	else
	{
		System.out.println("Invalid Login");
	}
	
}
}

