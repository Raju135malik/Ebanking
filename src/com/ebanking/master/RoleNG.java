package com.ebanking.master;

import org.testng.annotations.Test;

public class RoleNG extends Base{
	
	@Test(priority = 3)
	public void RoleCreation() throws Exception
	{
		LB.RoleCreation("ManagerCEO", "E");
	}
	@Test(priority = 2)
	public void BranchCreation() throws Exception
	{
		LB.BranchCreation("MyBranch","Myaddress1","12345","INDIA","MAHARASTRA","MUMBAI");
		
	}
	@Test(priority = 1)
	public void EmployeeCreation() throws Exception
	{
		LB.EmployeeCreation("EmployeeName","EmployeePass","MyAssistant","MyBranch");
	}

}
