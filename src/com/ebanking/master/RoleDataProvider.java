package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleDataProvider extends Base{
	    @Test(dataProvider = "Roledata")
		public void RoleCreation(String Rolename,String Roletype) throws Exception
		{
			LB.RoleCreation(Rolename, Roletype);
		}
	    
	    @DataProvider
	    
	    public Object[][] Roledata()
	    {
	    	Object[][] Obj = new Object[2][2];
	    	Obj[0][0] = "ManagerST";
	    	Obj[0][1] = "E";
	    	
	    	Obj[1][0] = "ManagerSTR";
	    	Obj[1][1] = "E";
	    	return Obj;
	    }
	}


