package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeeNG extends Base{
	@Test(dataProvider = "Edata")
	public void EmployeeCreation(String Ename,String Epass,String ERole,String EBranch) throws Exception
	{
		LB.EmployeeCreation(Ename, Epass, ERole, EBranch);
	}
		@DataProvider
		public Object[][] Edata()
		{
			Object[][] Obj = new Object[2][4];
			Obj[0][0] = "EName";
			Obj[0][1] = "EName";
			Obj[0][2] = "ManagerCEO";
			Obj[0][3] = "MyBranch";
			
			Obj[1][0] = "MName";
			Obj[1][1] = "MName";
			Obj[1][2] = "ManagerCEO";
			Obj[1][3] = "MyBranch";
			return Obj;
			
		}
}
