package com.ebanking.master;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class POMRanfordHomePage {
	//Elements properties
	@FindBy(id = "txtuId")
	WebElement Uname;
	
	@FindBy(id = "txtPword")
	WebElement UPass;
	
	@FindBy(id = "login")
	WebElement LoginBT;
	
	@FindBy(xpath= "//*[@id=\"drlist\"]")
	WebElement BranchName;
	
	
	//Methods
	public void login()
	{
		Uname.sendKeys("Admin");
		UPass.sendKeys("Te$ting@");
		LoginBT.click();
	}
	
	public void BankerLogin()
	{
		Select brnc = new Select(BranchName);
		brnc.selectByVisibleText("MyBranch");
		Uname.sendKeys("Admin");
		UPass.sendKeys("Te$ting@");
		LoginBT.click();
		
	}
	

}
