
package Cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoleCreation 
{

	WebDriver driver;

@Given("^User already on Ranford Home Page$")
public void user_already_on_Ranford_Home_Page() throws Throwable 
{
	 driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("http://122.175.8.158/ranford2");
	    
}

@When("^User enters valid UserName and Password$")
public void user_enters_valid_UserName_and_Password() throws Throwable
{
	driver.findElement(By.id("txtuId")).sendKeys("Admin");
	driver.findElement(By.id("txtPword")).sendKeys("Te$ting@");
	driver.findElement(By.id("login")).click();

}

@Then("^User Admin Login validation$")
public void user_Admin_Login_validation() throws Throwable
{
String Expval="Welcome to Admin";	
	
	String Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
	
	//Comparision
	
			if (Expval.equalsIgnoreCase(Actval)) 
			{
			System.out.println("Admin Login Succ");	
			}
			else
			{
				System.out.println("Admin Login Failed");
			}
			
	

}

@When("^User clicks on role button$")
public void user_clicks_on_role_button() throws Throwable 
{

	driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
}

@When("^Users Click on New Role and Enter all \"([^\"]*)\" and \"([^\"]*)\"$")
public void users_Click_on_New_Role_and_Enter_all_and(String Rn, String Rt) throws Throwable 
{
	driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
	driver.findElement(By.id("txtRname")).sendKeys(Rn);

Select Rtype=new Select(driver.findElement(By.id("lstRtypeN")));
Rtype.selectByVisibleText(Rt);
	driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
	Thread.sleep(4000);
   driver.switchTo().alert().accept();
}

@Then("^Close Application$")
public void close_Application() throws Throwable 
{
 driver.close();  
}


}
