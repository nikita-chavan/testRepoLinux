package com.pack.base;
import java.io.File;
import java.util.concurrent.TimeUnit;

 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
 import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

 import org.testng.annotations.BeforeClass;
 import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

 

 public class testcasesample {

            protected static WebDriver driver;

            protected static String result;

            @BeforeClass

 public static void setup()  {

            	File pathToBinary = new File("D:\\Installers\\Firefox\\firefox.exe");
        		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        		FirefoxProfile firefoxProfile = new FirefoxProfile();       
        		driver = new FirefoxDriver(ffBinary,firefoxProfile);
        		
        		//WebDriver driver = new FirefoxDriver();
        		String baseURL = "http://www.gmail.com";
        		driver.get(baseURL);
        		System.out.println("Title matched and hence proceeding further.");
        			driver.findElement(By.id("Email")).clear();
        			driver.findElement(By.id("Email")).sendKeys("seleniumfwuser");
        			driver.findElement(By.id("next")).click();
        			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        			driver.findElement(By.id("Passwd")).sendKeys("testselenium");
        			driver.findElement(By.id("signIn")).click();
        			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        			System.out.println("Title matched and hence proceeding further.");
        			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

           }

            @Test

 void Testcase1() {

            	System.out.println("Next");
            	String newurl=driver.getCurrentUrl();
            	System.out.println("urlnew"+newurl);
         	
         }

           

            @AfterClass

           public static void teardown()  {

            driver.close();

            driver.quit();

             }

 }