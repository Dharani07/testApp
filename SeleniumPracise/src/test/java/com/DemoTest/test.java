package com.DemoTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.MainTest.common;

public class test extends common {
	@Test
	
	public static void TC_001() throws IOException {
		LoadConfigPropertyFile();
	    
		common.launchBrowser();
		common.validateCurrentUrl();
		
		common.loginToApplication(By.id("txtUsername"), config.getProperty("Username"));
		common.TakeAScreenshot(By.id("txtUsername"),"Username");
		common.loginToApplication(By.id("txtPassword"), config.getProperty("Password"));
		common.TakeAScreenshot(By.id("btnLogin"),"Login");
		common.ClickonButton(By.id("btnLogin"));
		common.MoveToElement(By.linkText("PIM"));
	}
	
	
	
	

}
