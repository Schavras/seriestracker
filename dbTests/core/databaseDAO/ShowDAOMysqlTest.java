package core.databaseDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.dao.ActiveUser;
import core.domain.Show; 
import core.domain.User;

public class ShowDAOMysqlTest {

	ShowDAOMysql dao;
	InitializeConnection init;
	boolean result;
	String url = InitializeConnectionTest.url;
	String user = InitializeConnectionTest.user;
	String password = InitializeConnectionTest.password;

	
	@Before
	public void setUp() throws Exception {
		init = new InitializeConnection(url, user, password);
		init.initialize();
		dao = new ShowDAOMysql(InitializeConnection.getConnection());
		ActiveUser.ACTIVE_USER= new User("test",3);
	}	
	
	@After
	public void closeConnection(){
		init.close();
	}

	@Test
	public void getShowsByUserTest() {
		User user = new User("test", 3);
		System.out.println(dao.getShowsByUser(user));
	}
	
	@Test
	public void addShewTest(){
		Show show = new Show("test", "tt0903747");
		dao.addShow(show);
	}
	
	
	
}
