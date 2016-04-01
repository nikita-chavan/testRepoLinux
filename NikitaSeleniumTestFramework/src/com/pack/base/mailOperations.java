package com.pack.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;

 
 public class mailOperations extends testsetup {
	 
	 @Test(priority = 1)
	 public void getUrlDetails(){
		 
     	 String actualURL=driver.getCurrentUrl();
     	 System.out.println("Actual URl is : "+actualURL);
     	 String expectedURL="https://mail.google.com/mail/u/0/";
     	 System.out.println("Expected URl is : "+expectedURL);
     	 boolean compareURL=actualURL.equals(expectedURL);
     	 Assert.assertEquals(true,compareURL);
     	 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	 }
	 
	 @Test(priority = 2)
	 public void checkSearch(){
		 
		 config objFrmework = new config("object.properties");
		 driver.findElement(By.xpath(objFrmework.getProp("searchbox_xpath"))).clear();
		 driver.findElement(By.xpath(objFrmework.getProp("searchbox_xpath"))).sendKeys("best");
		 driver.findElement(By.xpath(objFrmework.getProp("searchbox_xpath"))).click();
		 System.out.println("Gmail search option is working.");
		 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	 }
	 
	 @Test(priority = 3)
	 public void composeMail() throws InterruptedException{
		 config objFrmework = new config("object.properties");
		 
		 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		 driver.findElement(By.xpath(objFrmework.getProp("compose_button_xpath"))).click();
		 driver.findElement(By.xpath(objFrmework.getProp("sendmail_To_testarea_xpath"))).clear();
		 driver.findElement(By.xpath(objFrmework.getProp("sendmail_To_testarea_xpath"))).sendKeys("seleniumfwuser@gmail.com");
		 driver.findElement(By.xpath(objFrmework.getProp("sendmail_To_testarea_xpath"))).sendKeys(Keys.TAB);
		 driver.findElement(By.xpath(objFrmework.getProp("sendmail_subject_testarea_xpath"))).clear();
		 driver.findElement(By.xpath(objFrmework.getProp("sendmail_subject_testarea_xpath"))).sendKeys("Test Mail");
		 driver.findElement(By.xpath(objFrmework.getProp("sendmail_subject_testarea_xpath"))).sendKeys(Keys.TAB);
		 driver.findElement(By.xpath(objFrmework.getProp("mail_body_xpath"))).sendKeys("Hi,\nThis is test mail.");
		 driver.findElement(By.xpath(objFrmework.getProp("send_mail_button"))).click();
		
		 Thread.sleep(7000);
		 System.out.println("Compose mail successful.");
		 
		 
		 
		 
	 }
 }