package com.pack.base;

import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IE {

	public static void main(String[] args){
		System.setProperty("webdriver.ie.driver", "D:\\Installers\\IE\\IEDriverServer.exe");
		DesiredCapabilities capab= DesiredCapabilities.internetExplorer();
		capab.setCapability("ignoreZoomSetting", true);
		WebDriver driver = new InternetExplorerDriver(capab);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
	}
}
