package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmployeeExcel {

	public static void main(String[] args) throws Exception {
		//Instance Class
		Library LB= new Library();
		LB.OpenApp("http://122.175.8.158/ranford2");
		LB.AdminLogin("Admin","Te$ting@");
		FileInputStream FIS= new FileInputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\testdata\\RoleCreation.xlsx");
		XSSFWorkbook WB= new XSSFWorkbook(FIS);
		XSSFSheet WS= WB.getSheet("Employee");
		int Rcount = WS.getLastRowNum();
		System.out.println(Rcount);
		//multiple iteration
		for (int i = 1; i <=Rcount; i++) {
			//Row
			XSSFRow WR = WS.getRow(i);
			//Cells
			XSSFCell WC = WR.getCell(0);
			XSSFCell WC1 = WR.getCell(1);
			XSSFCell WC2 = WR.getCell(2);
			XSSFCell WC3 = WR.getCell(3);
			//Result cell
			XSSFCell WC4 = WR.createCell(4);
			
			String EmployeeN = WC.getStringCellValue();
			String EMPPass = WC1.getStringCellValue();
			String Role = WC2.getStringCellValue();
			String Branch = WC3.getStringCellValue();
			
			String Rep = LB.EmployeeCreation(EmployeeN, EMPPass, Role, Branch);
			WC4.setCellValue(Rep);	
		}
			FileOutputStream FOS = new FileOutputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.xlsx");
			WB.write(FOS);
			WB.close();
	}

}
