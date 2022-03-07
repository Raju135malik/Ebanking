package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BranchExcel {

	public static void main(String[] args) throws Exception {
		// Instance Class
		Library LB= new Library();
		LB.OpenApp("http://122.175.8.158/ranford2");
		LB.AdminLogin("Admin","Te$ting@");
		FileInputStream FIS = new FileInputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\testdata\\RoleCreation.xlsx");
		XSSFWorkbook WB= new XSSFWorkbook(FIS);
		XSSFSheet WS = WB.getSheet("Branch");
		int Rcount = WS.getLastRowNum();
		System.out.println(Rcount);
		//multiple iteration
		
		for (int i = 1; i <= Rcount; i++) {
			
			//Rows
			XSSFRow WR = WS.getRow(i);
			//Cells
			
			XSSFCell WC = WR.getCell(0);
			XSSFCell WC1= WR.getCell(1);
			XSSFCell WC2= WR.getCell(2);
			XSSFCell WC3= WR.getCell(3);
			XSSFCell WC4= WR.getCell(4);
			XSSFCell WC5 = WR.getCell(5);
			XSSFCell WC6 = WR.createCell(6);  //for result
			
			// to pass the data 
			
			String BranchN = WC.getStringCellValue();
			String Addr1 = WC1.getStringCellValue();
			String Zip = WC2.getStringCellValue();
			String Country = WC3.getStringCellValue();
			String State = WC4.getStringCellValue();
			String City = WC5.getStringCellValue();
			
			String Res = LB.BranchCreation(BranchN, Addr1, Zip, Country, State, City);
			WC6.setCellValue(Res);
			}
		
		 FileOutputStream FOS = new FileOutputStream("C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.xlsx");
		 WB.write(FOS);
		 WB.close();
		}
		
		
	}

