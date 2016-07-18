package core.services;

import core.dao.ActiveUser;
import core.dao.UserDAO;
import core.databaseDAO.InitializeConnection;
import core.databaseDAO.UserDAOMysql;
import core.domain.User;

public class LoginService {
	
	public UserDAO dao;
	
	public LoginService(){
		dao = new UserDAOMysql(InitializeConnection.getConnection());
	}
	
	protected LoginService(UserDAO dao){
		this.dao = dao;
	}
	
	public boolean login(String username, String password){
		User user = dao.login(username, password);
		if(user == null){
			return false;
		}
		ActiveUser.ACTIVE_USER = user;
		return true;
	}
}
