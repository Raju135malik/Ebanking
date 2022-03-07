package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchNG extends Base{
	@Test(dataProvider = "Bdata")
	public void BranchCreation(String Bname,String Addr,String Zip,String Cunty,String State,String city) throws Exception
	{
		LB.BranchCreation(Bname, Addr, Zip, Cunty, State, city);
	}

	@DataProvider
	public Object[][] Bdata()
	{
		Object[][] Obj = new Object[2][6];
		Obj[0][0] = "MyBranch21";
		Obj[0][1] = "Addr1";
		Obj[0][2] = "12365";
		Obj[0][3] = "INDIA";
		Obj[0][4] = "GOA";
		Obj[0][5] = "GOA";
	
		Obj[1][0] = "MyBranch22";
		Obj[1][1] = "Addr2";
		Obj[1][2] = "12465";
		Obj[1][3] = "INDIA";
		Obj[1][4] = "GOA";
		Obj[1][5] = "GOA";
		return Obj;
		
	}
}
