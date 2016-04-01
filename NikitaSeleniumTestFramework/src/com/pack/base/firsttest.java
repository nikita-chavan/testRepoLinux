package com.pack.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.testng.annotations.*;
 
 public class firsttest extends testsetup {
	 
	 @Test(priority = 1)
	 public void test1(){
		 System.out.println("Next");
     	 String newurl=driver.getCurrentUrl();
     	 System.out.println("urlnew: "+newurl);
     	 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	 }
	 
	 @Test(priority = 2)
	 public void test2(){
		 driver.findElement(By.xpath(".//*[@id='gbqfq']")).clear();
		 driver.findElement(By.xpath(".//*[@id='gbqfq']")).sendKeys("best");
		 driver.findElement(By.id("gbqfb")).click();
		 System.out.println("Gmail search option is working.");
		 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	 }
	 
	 
 }