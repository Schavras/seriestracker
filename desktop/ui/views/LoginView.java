package ui.views;

import presenter.LoginPresenter;

public interface LoginView extends View{

	void setLoginPresenter(LoginPresenter presenter);
	
	String getUsername();
	
	String getPassword();
	
	boolean login();
	
	void openMainScreen();
}
