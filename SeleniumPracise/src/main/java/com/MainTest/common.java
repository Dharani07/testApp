package com.MainTest;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.internal.ConfigMethodArguments;

public class common {
	public static Properties config = null;
	
	@BeforeClass
	public static void launchBrowser() throws IOException {
		LoadConfigPropertyFile();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Madhavi\\eclipse-workspace\\SeleniumPracise\\Libraries\\Drivers\\chromedriver.exe");

		Data.driver = new ChromeDriver();
		Data.driver.manage().window().maximize();
		Data.driver.get(config.getProperty("URL"));

	}

	public static void validateCurrentUrl() {

		String Currenturl = Data.driver.getCurrentUrl();
		String url = "https://opensource-demo.orangehrmlive.com/";
		if (Currenturl.equalsIgnoreCase(url)) {
			System.out.println("Pass");
		} else {
			System.out.println("fail");

		}

	}
	
	public static void loginToApplication(By by,String element) {
		
     WebElement Username = Data.driver.findElement(by);
     if (Username.isEnabled() && Username!=null) {
    	 
    	 Username.sendKeys(element);
		
	}else {
		System.out.println(" Element not found");
	}
     
	}
	
	public static void ClickonButton(By by) {
		 
		WebElement eleToClick = Data.driver.findElement(by);
		
		if (eleToClick.isEnabled() & eleToClick.isDisplayed() & eleToClick != null) {
			eleToClick.click();
			
		}else {
			System.out.println("Element is not clickable");
		}
		
		
		
	}
	
	public static void MoveToElement(By by) {
		WebElement eleToMove = Data.driver.findElement(by);
		Actions action = new Actions(Data.driver);
		action.moveToElement(eleToMove).build().perform();
		
		if(eleToMove!=null) {
			eleToMove.click();
			System.out.println("pass: Element is present and successfully moved on the element");
			
		}else {
			System.out.println("fail: Element is not present");
		}
		
	}
	
	public static void TakeAScreenshot(By by,String ImageName) {
		
		WebElement element  = Data.driver.findElement(by);
		File scrFile = ((TakesScreenshot)Data.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("SeleniumPracise\\"+ImageName+".PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	
	public  static void LoadConfigPropertyFile() throws IOException  {
		
		config = new Properties();
		FileInputStream Fis = new FileInputStream(System.getProperty("user.dir")+"Config\\config.propertiess");
		config.load(Fis);
		
		
		
		
		
	
		
	}


}
