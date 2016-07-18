package core.databaseDAO;

import org.junit.Assert;
import org.junit.Test;

public class InitializeConnectionTest {
	
	boolean result;
	public static String url = "jdbc:mysql://192.168.2.4:3306/stdb";
	public static String user="myuser";
	public static String password = "mypass";
	
	@Test
	public void successConnectTest() throws Exception{
	
		InitializeConnection test = new InitializeConnection(url,user,password);
		result = test.initialize();
		Assert.assertTrue(result);
	}
	
//	@Test(expected=com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException.class)
//	public void failedConnectTest() throws Exception{
//		
////		url = "jdbc:mysql://www.db4free.net:3306/wrong";
////		user="schavras";
////		password = "klmr420";
//		
//		String url = "jdbc:mysql://192.168.2.5:3306/wrongdb";
//		String user="myuser";
//		String password = "mypass";
//		
//		
//		InitializeConnection test = new InitializeConnection(url,user,password);
//		result = test.initialize();
//		Assert.assertFalse(result);
//	}
	
	@Test
	public void closeConnectionTest(){
InitializeConnection test = new InitializeConnection(url,user,password);
		try {
			result = test.initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		test.close();
		
	}
}


