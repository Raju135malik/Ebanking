package com.ebanking.master;

public class Exelib extends Library {

	public static void main(String[] args) throws Exception {
	Library LB = new Library();
	LB.OpenApp("http://122.175.8.158/ranford2");
	LB.AdminLogin("Admin","Te$ting@");
	LB.BranchCreation("MyBranch","Myaddress1","12345","INDIA","MAHARASTRA","MUMBAI");
	LB.RoleCreation("MyAssistant","E");
	LB.EmployeeCreation("EmployeeName","EmployeePass","MyAssistant","MyBranch");
	LB.logout();
	LB.BankerLogin("MyBranch","EmployeeName","EmployeePass");
	LB.logout();
	LB.close();

	}
}
