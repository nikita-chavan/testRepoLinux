package com.pack.base;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;


 public class testsetup {

            protected static WebDriver driver;
            protected static String result;

            @BeforeClass
            public static void setup()  {
            	
            	config confFramework = new config("framework.properties");
        		String browser = confFramework.getProp(config.BROWSER_DRIVER);
            	if(browser.equals("Firefox"))
            	{
            	File pathToBinary = new File("/usr/bin/firefox");
        		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        		FirefoxProfile firefoxProfile = new FirefoxProfile();       
        		driver = new FirefoxDriver(ffBinary,firefoxProfile);
            	}
            	
            	else if(browser.equals("IE"))
            	{
            		System.setProperty("webdriver.ie.driver", "D:\\Installers\\IE\\IEDriverServer.exe");
            		DesiredCapabilities capab= DesiredCapabilities.internetExplorer();
            		capab.setCapability("ignoreZoomSetting", true);
            		driver = new InternetExplorerDriver(capab);
            	}
            	
            	else if(browser.equals("Chrome"))
            	{
            		System.setProperty("webdriver.chrome.driver", "D:\\Installers\\Chrome\\chromedriver.exe");
            		driver = new ChromeDriver();
            	}
            	
        		String login_url = confFramework.getProp(config.LOGIN_url);
        		//String baseURL = "http://www.gmail.com";
        		driver.get(login_url);
        		driver.manage().window().maximize();
        		System.out.println("Title matched and hence proceeding further.");
        		driver.findElement(By.id("Email")).clear();
        		String username = confFramework.getProp(config.USER);
        		String password = confFramework.getProp(config.PASSWORD);
        		
        		driver.findElement(By.id("Email")).sendKeys(username);
        		driver.findElement(By.id("next")).click();
        		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        		driver.findElement(By.id("Passwd")).sendKeys(password);
        		driver.findElement(By.id("signIn")).click();
        		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

           }

            @AfterClass
            public static void teardown()  {
            	
            	
            	/*driver.findElement(By.xpath("//a[@href='https://accounts.google.com/SignOutOptions?hl=en&continue=https://mail.google.com/mail&service=mail']")).click();
            	driver.findElement(By.xpath("//a[text()='Sign out']")).click();*/
            	driver.close();
            	driver.quit();
             }

 }