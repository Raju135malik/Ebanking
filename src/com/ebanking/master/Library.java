package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library {
	
	public static WebDriver driver;
	public static String Expval,Actval;
	public static FileInputStream Fis;
	public static Properties pr;
		public String OpenApp(String url) throws IOException
		{
			// Launch browser
			System.setProperty("webdriver.gecko.driver","C:\\Users\\vamsh\\Desktop\\geckodriver.exe");
			Fis = new FileInputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\properties\\Rep.properties");
			pr = new Properties();
			pr.load(Fis);
		     Expval = "Ranford Bank";
			driver= new FirefoxDriver();
			driver.manage().window().maximize();
			
			// URL
			
			driver.get(url);
			String Titl=driver.getTitle();
			System.out.println(Titl);
			String Actval = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
			 if(Expval.equalsIgnoreCase(Actval))
			 {
			   System.out.println("Application Launch Successfully");
			   return "Pass";
			  }
			
			 else
			 {
				 System.out.println("Applicantion Failed to Launch");
				 return "Fail";
			 }
			
		}
		

		public String AdminLogin(String un, String pwd) throws Exception
		{
			Expval = "Welcome to Admin";
			driver.findElement(By.id(pr.getProperty("Uname"))).sendKeys(un);
			driver.findElement(By.id(pr.getProperty("Pswd"))).sendKeys(pwd);
		    driver.findElement(By.xpath(pr.getProperty("login"))).click();
			Thread.sleep(3000);
			Actval = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
			 if (Expval.equalsIgnoreCase(Actval))
			 {
				 System.out.println("Login Sucessfully");
				return "Pass";
			 }
			 else 
			 {
				 System.out.println("Login Failed");
				 return "Fail";
			 }
			 
			// driver.findElement(By.xpath("//img[@src='images/Branches_but.jpg']")).click();
				//Thread.sleep(1000);
		}
		
		public String BranchCreation(String BrncName, String addr1,String zip,String cntr,String stat,String city) throws Exception
		{
			driver.findElement(By.xpath(pr.getProperty("Branch"))).click();
			driver.findElement(By.id(pr.getProperty("NewBranch"))).click();
			Thread.sleep(1000);
			// Enter details to New Branch
			 Expval = "Sucessfully";
			
			driver.findElement(By.id(pr.getProperty("BranchName"))).sendKeys(BrncName);
			driver.findElement(By.id(pr.getProperty("Address1"))).sendKeys(addr1);
			//driver.findElement(By.id(pr.getProperty("Address2"))).sendKeys(addr2);
			//driver.findElement(By.id(pr.getProperty("Address3"))).sendKeys(addr3);
			//driver.findElement(By.id(pr.getProperty("Area"))).sendKeys(area);
			driver.findElement(By.id(pr.getProperty("zipcode"))).sendKeys(zip);
			Select cntry = new Select (driver.findElement(By.id(pr.getProperty("Country"))));
			cntry.selectByVisibleText(cntr);
			Thread.sleep(2000);
			Select state = new Select (driver.findElement(By.id(pr.getProperty("State"))));
			state.selectByVisibleText(stat);
			Thread.sleep(2000);
			Select City = new Select (driver.findElement(By.id(pr.getProperty("City"))));
			City.selectByVisibleText(city);
			Thread.sleep(2000);
			driver.findElement(By.id(pr.getProperty("SubmitB"))).click();
			
			//Handle Alert
			
			Actval=driver.switchTo().alert().getText();
			Thread.sleep(2000);
			
			driver.switchTo().alert().accept();
			
			// Back to Home
			
			driver.findElement(By.xpath(pr.getProperty("Home1"))).click();
			
			if (Actval.contains(Expval))
			{
				System.out.println("Branch Created");
				return "Pass";
			}
			else
			{
				System.out.println("Branch already Exists");
				return "Fail";
			}
	
			
		}
		
		public String RoleCreation(String myrole,String Rtype) throws Exception
		{
			driver.findElement(By.xpath(pr.getProperty("Role"))).click();
			driver.findElement(By.id(pr.getProperty("NewRole"))).click();
			 
			//Enter Role Details
			Expval = "Sucessfully";
			driver.findElement(By.id(pr.getProperty("RoleName"))).sendKeys(myrole);
			//driver.findElement(By.id(pr.getProperty("RoleDesc"))).sendKeys(mydesc);
			Select Role = new Select(driver.findElement(By.id(pr.getProperty("RoleType"))));
			Role.selectByVisibleText(Rtype);
			Thread.sleep(2000);
			driver.findElement(By.id(pr.getProperty("SubmitR"))).click();
			
			//Handle Alert
			
					Actval=driver.switchTo().alert().getText();
					Thread.sleep(2000);

					driver.switchTo().alert().accept();
					

			// Back to Home
			
					driver.findElement(By.xpath(pr.getProperty("Home2"))).click();
					if (Actval.contains(Expval))
					{
						System.out.println("Role Created");
						return "Pass";
					}
					else
					{
						System.out.println("Role already Exists");
						return "Fail";
					}
					
			
			
		}
		public String EmployeeCreation(String empname,String emppass,String assi,String mybrnch) throws Exception
		{
			driver.findElement(By.xpath(pr.getProperty("Employee"))).click();
			driver.findElement(By.xpath(pr.getProperty("NewEmployee"))).click();
			
			//Enter Employee Details
			Expval = "Sucessfully";
			driver.findElement(By.xpath(pr.getProperty("EmployeeName"))).sendKeys(empname);
			driver.findElement(By.xpath(pr.getProperty("EmployeePass"))).sendKeys(emppass);
			Select SecRole = new Select(driver.findElement(By.id(pr.getProperty("RoleSelect"))));
			SecRole.selectByVisibleText(assi);
			Thread.sleep(2000);
			Select SecBrnc =new Select(driver.findElement(By.id(pr.getProperty("BranchSelect"))));
			SecBrnc.selectByVisibleText(mybrnch);
			driver.findElement(By.xpath(pr.getProperty("SubmitE"))).click();
			
			//Handle Alert
			
					Actval=driver.switchTo().alert().getText();
					Thread.sleep(2000);
					driver.switchTo().alert().accept();
					// Back to Home
							
					driver.findElement(By.xpath(pr.getProperty("Home3"))).click();
					if (Actval.contains(Expval))
					{
						System.out.println("Employee Created");
						return "Pass";
					}
					else
					{
						System.out.println("Employee already Exists");
						return "Fail";
					}		
		}
		
		public String logout() throws InterruptedException
		{
			// Back to Home
			
			//driver.findElement(By.xpath("//img[@src='images/admin_but_01.jpg']")).click();
			driver.findElement(By.xpath(pr.getProperty("logout"))).click();
			Thread.sleep(2000);
			return "Pass";
		}
		
		public String BankerLogin(String BName,String Id,String Pass)
		{    
			Expval="Customers";
			Select brnc = new Select(driver.findElement(By.id(pr.getProperty("BranchNameB"))));
			brnc.selectByVisibleText(BName);
			driver.findElement(By.xpath(pr.getProperty("Username"))).sendKeys(Id);
			driver.findElement(By.xpath(pr.getProperty("Password"))).sendKeys(Pass);
			driver.findElement(By.id(pr.getProperty("loginBanker"))).click();
			Actval = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr/td[4]/p[1]/strong")).getText();
			if (Expval.equalsIgnoreCase(Actval))
			{
			 System.out.println("Banker login Successfull");
			 return "Pass";
			}
			else
			{
				System.out.println("Banker login failed");
				return "Fail";
			}
		
		}

		public String close()
		{
			driver.close();
			return "Pass";
		}

			
}



