package presenter;

import core.dao.ActiveUser;
import core.dao.UserDAO;
import core.databaseDAO.InitializeConnection;
import core.databaseDAO.UserDAOMysql;
import core.domain.User;
import ui.views.LoginView;

public class LoginPresenter {
	
	private UserDAO dao;
	private LoginView view;
	
	public LoginPresenter(LoginView view){
		this.view = view;
		dao = new UserDAOMysql(InitializeConnection.getConnection());
	}
	
	public void start(){
		view.setLoginPresenter(this);
		view.open();
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
