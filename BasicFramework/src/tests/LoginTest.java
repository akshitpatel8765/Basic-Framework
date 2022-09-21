package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	LoginPage lp = new LoginPage(); 
	DataFile df = new DataFile();
	
@BeforeMethod
  public void beforeMethod() throws IOException {
	 //open Firefox
	 //open scotiabank login Page
	lp.openBrowser();
	lp.loginPage();
	
	}
  
	  
  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
	  //close the browser
  }
  @Test(priority = 1)
  public void loginWithWrongCredentials() {
	  
	  lp.login(df.Emailwithspeacialcharacter,df.password);
	 // Enter wrong email,wrong pass,click on login button
	  //verify error message
	  
		Assert.assertEquals(lp.readWrongCredentialsError(),df.wrongcredentialErr );
		System.out.println("Test pass");
		
		
		/*System.out.println(Emailwithspeacialcharacter);
		System.out.println(password);
		System.out.println(Emailwithoutspeacialcharacter);
		System.out.println(EmptyEmail+"Empty Email");
		System.out.println(Emptypassword+"Empty password");*/
  }
  
  @Test(priority = 2)
public void loginWithWrongEmailPassword() throws InterruptedException {
	//Enter wrong email without speacial character,wrong pass,click on login button
	//verify error message
	  
	 lp.login(df.Emailwithoutspeacialcharacter, df.password);
		
		Assert.assertEquals(lp.readWrongEmailError(), df.EmailwithoutspeacialcharacterERR);
		System.out.println("Test pass");
  }
  
  @Test(priority = 3)
  public void loginWithEmptyEmail() throws InterruptedException {
	  //Enter email only with password box empty
  	  
  	 lp.login(df.EmptyEmail, df.password);
  		Assert.assertEquals(lp.readEmptyEmailError(), df.EmptyEmailERR);
  		System.out.println("Test pass");
    }
  @Test(priority = 4)
  public void loginWithEmptyPassword() throws InterruptedException {
	  //Enter email only with password box empty
  	  
  	  lp.login(df.Emailwithoutspeacialcharacter, df.Emptypassword);
  		Assert.assertEquals(lp.readEmptyPasswordError(), df.EmptypasswordErr);
  		System.out.println("Test pass");
    }
}
