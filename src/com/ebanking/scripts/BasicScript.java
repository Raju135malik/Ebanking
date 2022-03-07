package com.ebanking.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicScript {

	public static void main(String[] args) throws Exception {
		
		// Launch firefox browser
		String Expval = "Ranford Bank";
		
		
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		
		// URL
		
		driver.get("http://122.175.8.158/ranford2");
		String Titl=driver.getTitle();
		System.out.println(Titl);
		String Actval = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		 if(Expval.equalsIgnoreCase(Actval))
		 {
		   System.out.println("Application Launch Successfully");
		  }
		
		 else
		 {
			 System.out.println("Applicantion Failed to Launch");
		 }
		
	    // Admin Login
		Expval = "Welcome to Admin";
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Te$ting@");
	    driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		Thread.sleep(3000);
		Actval = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		 if (Expval.equalsIgnoreCase(Actval))
		 {
			 System.out.println("Login Sucessfully");
			
		 }
		 else 
		 {
			 System.out.println("Login Failed");
		 }
		// Navigate to Create New Branch
		
		driver.findElement(By.xpath("//img[@src='images/Branches_but.jpg']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("BtnNewBR")).click();
		
		// Enter details to New Branch
		 Expval = "Sucessfully";
		
		driver.findElement(By.id("txtbName")).sendKeys("MyBranch");
		driver.findElement(By.id("txtAdd1")).sendKeys("Myaddress1");
		driver.findElement(By.id("Txtadd2")).sendKeys("Myaddress2");
		driver.findElement(By.id("txtadd3")).sendKeys("Myaddress3");
		driver.findElement(By.id("txtArea")).sendKeys("Myarea");
		driver.findElement(By.id("txtZip")).sendKeys("12345");
		Select cntry = new Select (driver.findElement(By.id("lst_counrtyU")));
		cntry.selectByVisibleText("INDIA");
		Thread.sleep(2000);
		Select state = new Select (driver.findElement(By.id("lst_stateI")));
		state.selectByVisibleText("MAHARASTRA");
		Thread.sleep(2000);
		Select City = new Select (driver.findElement(By.id("lst_cityI")));
		City.selectByVisibleText("MUMBAI");
		Thread.sleep(2000);
		driver.findElement(By.id("btn_insert")).click();
		
		//Handle Alert
		
		Actval=driver.switchTo().alert().getText();
		Thread.sleep(3000);
		if (Actval.contains(Expval))
		{
			System.out.println("Branch Created");
		}
		else
		{
			System.out.println("Branch already Exists");
		}
		
		driver.switchTo().alert().accept();
		
		// Back to Home
		
		driver.findElement(By.xpath("//img[@src='images/admin_but_01.jpg']")).click();
		
		 //Role Creation
		
		driver.findElement(By.xpath("//img[@src='images/Roles_but.jpg']")).click();
		driver.findElement(By.id("btnRoles")).click();
		 
		//Enter Role Details
		Expval = "Sucessfully";
		driver.findElement(By.id("txtRname")).sendKeys("MyAssistant");
		driver.findElement(By.id("txtRDesc")).sendKeys("MyAssistDesc");
		Select Role = new Select(driver.findElement(By.id("lstRtypeN")));
		Role.selectByVisibleText("E");
		Thread.sleep(2000);
		driver.findElement(By.id("btninsert")).click();
		
		//Handle Alert
		
				Actval=driver.switchTo().alert().getText();
				Thread.sleep(3000);
				if (Actval.contains(Expval))
				{
					System.out.println("Role Created");
				}
				else
				{
					System.out.println("Role already Exists");
				}
				
				driver.switchTo().alert().accept();
				

		// Back to Home
		
		driver.findElement(By.xpath("//img[@src='images/admin_but_01.jpg']")).click();
		
		// Employee Creation
		
		driver.findElement(By.xpath("//img[@src='images/emp_btn.jpg']")).click();
		driver.findElement(By.xpath("//input[@id='BtnNew']")).click();
		
		//Enter Employee Details
		Expval = "Sucessfully";
		driver.findElement(By.xpath("//input[@id='txtUname']")).sendKeys("EmployeeName");
		driver.findElement(By.xpath("//input[@id='txtLpwd']")).sendKeys("EmployeePass");
		Select SecRole = new Select(driver.findElement(By.id("lst_Roles")));
		SecRole.selectByVisibleText("MyAssistant");
		Thread.sleep(2000);
		Select SecBrnc =new Select(driver.findElement(By.id("lst_Branch")));
		SecBrnc.selectByVisibleText("MyBranch");
		driver.findElement(By.xpath("//input[@name='BtnSubmit']")).click();
		
		//Handle Alert
		
				Actval=driver.switchTo().alert().getText();
				Thread.sleep(3000);
				if (Actval.contains(Expval))
				{
					System.out.println("Employee Created");
				}
				else
				{
					System.out.println("Employee already Exists");
				}
				
				driver.switchTo().alert().accept();
		// Back to Home
				
		driver.findElement(By.xpath("//img[@src='images/admin_but_01.jpg']")).click();
		
		//Logout
		
		driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click();
		driver.close();
		
	}


}
