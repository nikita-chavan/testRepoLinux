package com.pack.base;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class chrome{
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "D:\\Installers\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
		
		
	}
}