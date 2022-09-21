package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	
	WebDriver driver;
	/*
	Public WebElement email = driver.findElement(By.name("usernameInput"));
	Public WebElement password = driver.findElement(By.id("password-input"));
	Public WebElement singin_button = driver.findElement(By.id("signIn"));
	Public WebElement wrongCredentialsErr = driver.findElement(By.xpath("//span[contains(text(),'Please enter a username or card number without special' )]")).getText();
	Public WebElement wrongEmailError = driver.findElement(By.xpath("//div[contains(text(),'Please check your card number / username or password and try ' )]")).getText();
	Public WebElement emptyEmail = driver.findElement(By.xpath("//span[contains(text(),'Please enter your username or card num' )]")).getText();
	Public WebElement emptyPassword = driver.findElement(By.xpath("//span[contains(text(),'Please enter your pas' )]")).getText();
	
	*/
	
	
	
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signInButton;
	
	@FindBy(id = "globalError")
    public WebElement globalError;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement emailError;
	
	@FindBy(id = "PasswordTextField__errors-password")
    public WebElement passwordError;

	
public void openBrowser() throws IOException { 
	
	
	FileInputStream f= new FileInputStream("C:\\Testing\\Browser.properties");
	Properties Browser = new Properties();
	Browser.load(f);
	String browser = Browser.getProperty("Browser");
	System.out.println(browser);
	
	switch(browser) {
	
	case "Firefox":
	System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
	 driver = new FirefoxDriver();
	 break;
	case "Chrome" :
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		 driver = new ChromeDriver();
		 break;
	}
	PageFactory.initElements(driver, this);
	
}


public void loginPage() {
	driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=4ayEJqUGsR4&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiNGF5RUpxVUdzUjQiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY1MjAyMjAwMywiaWF0IjoxNjUyMDIwODAzLCJqdGkiOiIxNmNlZTdmNC1mZjI5LTRjZTMtODk3Yy0yNmE4NTJhMDNkN2UiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.U8kxuW5lpM5R5LK3hNpXmBUs1PQRIJQQj2RGTwIswXvbdh5PeuA8MXyVkwa9ujozkgeRloJs3zRKG0NgK2A05NcAqz-om4VlC7gIjyfgr6FP6rWRqy7NxzR6G6yys-g-UVx9wrJAyE7x_tCFsWLyEWMMLBimhRmNhp3HmSFsby1ivtdEpOJSvIHL3g1oqV3vGhjPoXCtSJkZ9UCZDapg40lomR_Sa2WN7N4JNzcYzcxv_7IHTQrrX1X7D8QEOIdLl9fdPRq1xFueMh6s8345S0NMVNnQJttEy6agMlJLOoDdcRNntylwD5wqdSBGbxt_pXDNYMJd7HE8tNKQ9gobNw&preferred_environment=");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
public void closeBrowser() {
	driver.quit();
}
public void login(String a,String b) {
	
	

	email.sendKeys(a);
	password.sendKeys(b);
	signInButton.click();
}



public String readWrongCredentialsError() {

	String Errorrecived =emailError.getText();

	System.out.println(Errorrecived);
	return Errorrecived;
}
public String readWrongEmailError() {

	String Errorrecived = globalError.getText();

	System.out.println(Errorrecived);
	return Errorrecived;
}
public String readEmptyEmailError() {

	String Errorrecived =emailError.getText();

	System.out.println(Errorrecived);
	return Errorrecived;
}
public String readEmptyPasswordError() {

	String Errorrecived = passwordError.getText();

	System.out.println(Errorrecived);
	return Errorrecived;
}
}

