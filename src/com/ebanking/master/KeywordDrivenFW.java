package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class KeywordDrivenFW {
	public static void main(String[] args) throws Exception {
		// Instance class
		Library LB= new Library();
		String Result = null;
		//String TCID;
		FileInputStream FIS = new FileInputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\testdata\\Keyword_Data.xlsx");
		XSSFWorkbook WB = new XSSFWorkbook(FIS);
		XSSFSheet WS = WB.getSheet("TestCases");
		XSSFSheet WS1 = WB.getSheet("TestSteps");
		int CaseCount = WS.getLastRowNum();
		System.out.println(CaseCount);
		int StepCount = WS1.getLastRowNum();
		System.out.println(StepCount);
		
		for (int i = 1; i <= CaseCount; i++)
		{
			String Execute = WS.getRow(i).getCell(2).getStringCellValue();
			if (Execute.equalsIgnoreCase("Y"))
			{
				String TCID = WS.getRow(i).getCell(0).getStringCellValue();
			  //System.out.println(TCID);
			for (int j= 1;j<= StepCount;j++)
			{
				String TSTCID = WS1.getRow(j).getCell(0).getStringCellValue();
				// System.out.println(TSTCID);
				if (TCID.equalsIgnoreCase(TSTCID))
				{
					String Keyword = WS1.getRow(j).getCell(3).getStringCellValue();
					System.out.println(Keyword);
					switch (Keyword)
					{
					case "Rlaunch":
						Result =LB.OpenApp("http://122.175.8.158/ranford2");
						break;
					case "Rlogin":
						Result = LB.AdminLogin("Admin","Te$ting@");
						break;
					case "Rbranch":
						//Result = LB.BranchCreation("MyBranch35","Myaddress25","13345","INDIA","MAHARASTRA","MUMBAI");
						FileInputStream fis = new FileInputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\testdata\\RoleCreation.xlsx");
						XSSFWorkbook WBD = new XSSFWorkbook(fis);
						XSSFSheet WSD = WBD.getSheet("Branch");
						int Bcount=WSD.getLastRowNum();
						for (int k = 1; k <= Bcount; k++) 
						{
							XSSFRow WR = WSD.getRow(k);
							
							XSSFCell WC = WR.getCell(0);
							XSSFCell WC1 = WR.getCell(1);
							XSSFCell WC2 = WR.getCell(2);
							XSSFCell WC3 = WR.getCell(3);
							XSSFCell WC4 = WR.getCell(4);
							XSSFCell WC5 = WR.getCell(5);
							XSSFCell WC6 = WR.createCell(6);
							
							String BranchN = WC.getStringCellValue();
							String Addrs = WC1.getStringCellValue();
							String zip = WC2.getStringCellValue();
							String country = WC3.getStringCellValue();
							String State = WC4.getStringCellValue();
							String City = WC5.getStringCellValue();
							String Res = LB.BranchCreation(BranchN, Addrs, zip, country, State, City);
							WC6.setCellValue(Res);
						}
						
						FileOutputStream fos = new FileOutputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.xlsx");
						WBD.write(fos);
						WBD.close();
						break;
					case "Rrole":
						Result= LB.RoleCreation("Rolerrsss", "E");
						break;
					case "Remployee":
						Result= LB.EmployeeCreation("EmployeeName11","EmployeePass11","MyAssistant","MyBranch");
						break;
					case "Blogin":
						Result= LB.BankerLogin("MyBranch","EmployeeName","EmployeePass");
						break;
					case "Rlogout":
						Result= LB.logout();
						break;
					case "Rclose":
						Result = LB.close();
						break;
						default:
							System.out.println("Keyword not valid");
						break;
					}
					WS1.getRow(j).createCell(4).setCellValue(Result);
					if (WS1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Pass"))
					{
						WS.getRow(i).createCell(3).setCellValue(Result);
					}
					else
					{
					WS.getRow(i).createCell(3).setCellValue("Fail");
					}
					
				    }
			      }
		          }
			else
			{
				WS.getRow(i).createCell(3).setCellValue("Blocked");
			}
          }
		FileOutputStream FOS = new FileOutputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\testdata\\Keyword_Result.xlsx");
		WB.write(FOS);
		WB.close();
}
	}