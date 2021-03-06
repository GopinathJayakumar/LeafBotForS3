package com.leafBot.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leafBot.pages.FindLeadPage;
import com.leafBot.pages.LoginPage;
import com.leafBot.testng.api.base.ProjectSpecificMethods;



public class TC006_DuplicateLead extends ProjectSpecificMethods{

	@BeforeTest
	public void setData() {
		testCaseName="TC006_DuplicateLead";
		testCaseDescription="Duplicate a Lead - LeafTaps";
		author="Gopinath Jayakumar";
		category="Regression";
		dataSheetName="TC006";
	}

	@Test(dataProvider="fetchData")
	public void duplicateLead(String userName, String password ,String emailAddress) throws InterruptedException{

		String fName=
			new LoginPage()
				.enterUserName(userName)
				.enterPassword(password)
				.clickLogin()		
				.clickCRMSFA()		
				.clickLeadLink()		
				.clickFindLead()
				.clickEmailTab()
				.enterEmailAddress(emailAddress)
				.clickFindleadsButton()
				.getFirstResultingFirstName();
			new FindLeadPage()
				.clickFirstResultingLead()
				.clickDuplicateLeadLink()
				.clickCreateLeadDublicate()
				.verifyFirstName(fName);

	}

}
