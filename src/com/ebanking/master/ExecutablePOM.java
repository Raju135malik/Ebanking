package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ExecutablePOM {
	@Test
	public void Login() throws Exception
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://122.175.8.158/ranford2");
		POMRanfordHomePage RHM = PageFactory.initElements(driver, POMRanfordHomePage.class);
	     //RHM.login();
	    RHM.BankerLogin();
	    POMAdminHomePage AHP = PageFactory.initElements(driver, POMAdminHomePage.class);
	    AHP.branch();
	    POMNewBranch NBP = PageFactory.initElements(driver, POMNewBranch.class);
	    NBP.NewBranch();
	    
	}
	

}
