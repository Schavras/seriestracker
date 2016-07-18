package presenter;

import core.dao.UserDAO;
import core.databaseDAO.InitializeConnection;
import core.databaseDAO.UserDAOMysql;
import ui.views.SignUpView;

public class SignUpPresenter {
	
	private SignUpView view;
	private UserDAO dao;
	
	
	public SignUpPresenter(SignUpView view){
		this.view = view;
		dao = new UserDAOMysql(InitializeConnection.getConnection());
	}
	
	public boolean checkValidPassword(String password1, String password2){
		if(password1.equals("") || password2.equals("")) return false;
		return password1.equals(password2);
	}
	
	
	
	public boolean signup(String username, String password, String email){
		
			return dao.newUser(username, password, email);
		
	}
	
	public void start(){
		view.setSignUpPresenter(this);
		view.open();
	}
}
