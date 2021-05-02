package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();
	
	/**
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver initDriver(String browser) {
		System.out.println("browser value:"+browser);
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver().browserVersion("90.0.4430.24");
			threadLocal.set(new ChromeDriver());
		}
		else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			threadLocal.set(new FirefoxDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return threadLocal.get();
	}
	
	
}
