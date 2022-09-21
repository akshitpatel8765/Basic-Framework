package data;

import utilities.Xls_Reader;

public class DataFile {
	//Login Test
	public Xls_Reader d = new Xls_Reader("C:\\Testing\\NikulTest.xlsx");
	public String Emailwithspeacialcharacter = d.getCellData("Data1", "UserName", 4);
	public String password = d.getCellData("Data1", "Password", 2);
	public String Emailwithoutspeacialcharacter = d.getCellData("Data1", "UserName", 3);
	public String EmptyEmail = d.getCellData("Data1", "UserName", 10);
	public String Emptypassword = d.getCellData("Data1", "Password", 4);
	public String wrongcredentialErr= d.getCellData("Data1", "Email Error", 5);
	public String EmailwithoutspeacialcharacterERR = d.getCellData("Data1", "Global Error", 2);
	public String EmptyEmailERR = d.getCellData("Data1", "Email Error", 4);
	public String EmptypasswordErr = d.getCellData("Data1", "Password Error", 3);

	
	//Search Test
	
	
	
}
