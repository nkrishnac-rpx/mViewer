package com.imaginea.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.imaginea.base.BaseTest;
import com.imaginea.pageObjects.DatabaseTab;
import com.imaginea.pageObjects.LoginPage;

public class SampleTest extends BaseTest {

	WebDriver driver;
	Logger log =Logger.getLogger(SampleTest.class); 
	LoginPage loginPage;
	DatabaseTab dbTab;
	@BeforeClass
	public void beforeClass(){
		driver=getDriver();
	}
	
	@Test
	public void launch(){
	    loginPage= PageFactory.initElements(driver, LoginPage.class);		 
	    loginPage.loginmViewer();
	    dbTab =  PageFactory.initElements(driver, DatabaseTab.class);
	    String testDB=null;
	    for (int i = 0; i < 10; i++) {
	        testDB = "tet"+i;
	        dbTab.createDb(testDB);
	        dbTab.getDBList(driver).contains(testDB);
            }
	    
	}
}
