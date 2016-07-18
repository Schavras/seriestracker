package ui;

import presenter.LoginPresenter;
import ui.views.LoginView;

public class LoginUIStub extends DefaultStub implements LoginView {

	LoginPresenter presenter ;
	
	@Override
	public void setLoginPresenter(LoginPresenter presenter) {
		this.presenter = presenter;
		
	}

	@Override
	public String getUsername() {
		return "username";
	}

	@Override
	public String getPassword() {
		return "password";
	}

	@Override
	public boolean login() {
		return false;
	}

	@Override
	public void openMainScreen() {
		// TODO Auto-generated method stub
		
	}

}
