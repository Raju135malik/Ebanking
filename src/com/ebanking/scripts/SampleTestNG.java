package com.ebanking.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestNG {
	@Test
	public void abc()
	{
		Assert.assertEquals("Selenium","Selenium");
	}
	@Test
	public void xyz()
	{
		Assert.assertEquals("Sele","Sele");
	}
	@Test
	public void pqr()
	{
		Assert.assertEquals("Salee", "Salee");
	}

}
