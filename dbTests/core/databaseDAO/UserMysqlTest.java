package core.databaseDAO;

import org.junit.After;
import  org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.domain.User;

public class UserMysqlTest {

	UserDAOMysql dao;
	InitializeConnection init;
	boolean result;

	String url = InitializeConnectionTest.url;
	String user = InitializeConnectionTest.user;
	String password = InitializeConnectionTest.password;
	
	@Before
	public void setUp() throws Exception {
		
		
		
			
		init = new InitializeConnection(url, user, password);
		init.initialize();
		dao = new UserDAOMysql(InitializeConnection.getConnection());
	}
	
	

	@Test
	public void getUserByUserameTest() {
		dao.getUserByUserame("first_user");
	}
	
	@After
	public void closeConnection(){
		init.close();
	}

	
	@Test
	public void SuccessLoginTest(){
		User actual = dao.login("first_user", "first_pass");
		User expected = new User ("first_user", 1);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void FailedLoginTest(){
		User actual = dao.login("wrong_username", "first_pass");
		Assert.assertNull(actual);
		
		actual = dao.login("first_user", "wrong_pass");
		Assert.assertNull(actual);
	}
	
	
}
