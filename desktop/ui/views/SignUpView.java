package ui.views;

import presenter.SignUpPresenter;

public interface SignUpView extends View {
	
	void setSignUpPresenter(SignUpPresenter presenter);
	
	String getUsername();
	
	String getPassword1();
	
	String getPassword2();
	
	String getEmail();
	
	boolean getCaptcha();
	
	boolean getTOS();
	
	void confirm();
	
	boolean checkCaptca();
	
	boolean checkTos();
	
	boolean checkPasswords();
}
