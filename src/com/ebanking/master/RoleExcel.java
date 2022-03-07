package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RoleExcel {

	public static void main(String[] args) throws Exception {
		// Instance class
		Library LB= new Library();
		LB.OpenApp("http://122.175.8.158/ranford2");
		LB.AdminLogin("Admin","Te$ting@");
		FileInputStream Fis=new FileInputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\testdata\\RoleCreation.xlsx");
		
	   //Workbook
		XSSFWorkbook WB= new XSSFWorkbook(Fis);
		
		//Work Sheet
		XSSFSheet WS = WB.getSheet("Role");
		int Rcount= WS.getLastRowNum();
		System.out.println(Rcount);
		
		//Multiple Iteration
		for (int i = 1; i <=Rcount; i++) {
			//Rows
			XSSFRow WR=WS.getRow(i);
			
			//Cells
			XSSFCell WC = WR.getCell(0);  //RoleName
			//XSSFCell WC1 = WR.getCell(1);  //RoleDesc
			XSSFCell WC2 = WR.getCell(2);  //RoleType
			
			//To Pass the Data in Results
			
			XSSFCell WC3 = WR.createCell(3);  
			String Rname = WC.getStringCellValue();
			//String RDesc = WC1.getStringCellValue();
			String Rtype = WC2.getStringCellValue();
			
			String Res= LB.RoleCreation(Rname, Rtype);
			WC3.setCellValue(Res);
			
		}
		//Results
		
		FileOutputStream Fos = new FileOutputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.xlsx");
		WB.write(Fos);
		WB.close();

	}

}
