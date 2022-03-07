package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RoleNotePad {

	public static void main(String[] args) throws Exception {
		Library LB= new Library();
		LB.OpenApp("http://122.175.8.158/ranford2");
		LB.AdminLogin("Admin","Te$ting@");
		String SD;
		//to get the path of the file
		
		String Fpath = "C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\testdata\\NotePadScript.txt";
		
		//to get the path of the result file
		
		String Rpath = "C:\\Users\\vamsh\\Seleniumprojectjar\\Ebanking\\src\\com\\ebanking\\results\\Res_Role.txt";
		
		FileReader FR = new FileReader(Fpath);
		BufferedReader BR = new BufferedReader(FR);
		String Sread = BR.readLine();
		System.out.println("Sread");
		
		// Write the header line into the results file
		FileWriter FW = new FileWriter(Rpath);
		BufferedWriter BW = new BufferedWriter(FW);
		BW.write(Sread);
		
		
		
		// While loop
		while ((SD=BR.readLine())!=null)
		{
			System.out.println(SD);
			
			//Split
			
			String SR[] = SD.split("%%%");
			
			String Rname = SR[0];
			String Rtype = SR[1];
		
			String Res = LB.RoleCreation(Rname,Rtype);
			System.out.println(Res);
			
			//results
			BW.write(SD+"$$$"+Res);
			BW.newLine();
			
		
		}
			BW.close();
			BR.close();
	}

}
