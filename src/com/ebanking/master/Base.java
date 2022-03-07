package com.ebanking.master;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Base {
  Library LB = new Library();
  
  @BeforeSuite
  public void beforeMethod() throws Exception {
	  //Launch application
	  LB.OpenApp("http://122.175.8.158/ranford2");
  }

  @AfterSuite
  public void afterMethod() {
	  LB.close();
  }

  @BeforeTest
  public void beforeTest() throws Exception {
	  LB.AdminLogin("Admin","Te$ting@");
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  LB.logout();
  }

}
