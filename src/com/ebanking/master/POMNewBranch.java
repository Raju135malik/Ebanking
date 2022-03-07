package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POMNewBranch {
	
	@FindBy(xpath= "/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement Home;
	@FindBy(id = "BtnNewBR")
	WebElement NewBranch;
	
	public void NewBranch()
	{
		NewBranch.click();
	}
	public void Home()
	{
		Home.click();
	}

}
