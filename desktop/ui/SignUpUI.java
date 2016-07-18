package ui;

import presenter.SignUpPresenter;
import ui.views.SignUpView;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SignUpUI extends DefaultJPanel implements SignUpView {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2220553611492043412L;
	
	private SignUpPresenter presenter;
	
	private JTextField usernameTF;
	private JTextField emailTF;

	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
	
	private JCheckBox tos;
	private JCheckBox captcha;
	
	
	private JLabel lblCaptchaError;
	private JLabel lbltosError;
	private JLabel lblPasswordsError;
	
	private boolean success;
	private JLabel lblsuccessMsg;
	
	public SignUpUI() {
		
		usernameTF = new JTextField();
		usernameTF.setBounds(555, 183, 248, 20);
		add(usernameTF);
		usernameTF.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(442, 189, 67, 14);
		add(lblUsername);
		
		emailTF = new JTextField();
		emailTF.setColumns(10);
		emailTF.setBounds(555, 276, 248, 20);
		add(emailTF);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(442, 217, 46, 14);
		add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(442, 248, 103, 14);
		add(lblConfirmPassword);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(442, 279, 46, 14);
		add(lblEmail);
		
		JLabel lblCreateNewAccount = new JLabel("Create new account");
		lblCreateNewAccount.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCreateNewAccount.setBounds(570, 112, 176, 40);
		add(lblCreateNewAccount);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				confirm();
			}
		});
		
		
		btnConfirm.setBounds(555, 356, 89, 23);
		add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
			}
		});
		btnCancel.setBounds(714, 356, 89, 23);
		add(btnCancel);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(555, 214, 248, 20);
		add(passwordField1);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(555, 245, 248, 20);
		add(passwordField2);
		
		tos = new JCheckBox("I have read and agree to the terms of service.");
		tos.setBounds(555, 303, 258, 23);
		add(tos);
		
		captcha = new JCheckBox("I am not a robot.");
		captcha.setBounds(555, 329, 248, 20);
		add(captcha);
		
		lbltosError = new JLabel("You have to agree with term of service.");
		lbltosError.setForeground(Color.RED);
		lbltosError.setBounds(820, 307, 195, 14);
		lbltosError.setVisible(false);
		add(lbltosError);
		
		lblCaptchaError = new JLabel("Are you a robot?");
		lblCaptchaError.setForeground(Color.RED);
		lblCaptchaError.setBounds(820, 332, 118, 14);
		lblCaptchaError.setVisible(false);
		add(lblCaptchaError);
		
		lblPasswordsError = new JLabel("Passwords dont match.");
		lblPasswordsError.setForeground(Color.RED);
		lblPasswordsError.setBounds(820, 248, 128, 14);
		lblPasswordsError.setVisible(false);
		add(lblPasswordsError);
	}

	@Override
	public void setSignUpPresenter(SignUpPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public String getUsername() {
		//Check for valid username.
		return usernameTF.getText();
	}

	@Override
	public String getEmail() {
		//  Check for valid email.
		return emailTF.getText();
	}

	@Override
	public String getPassword1() {
		return new String(passwordField1.getPassword());
	}

	@Override
	public String getPassword2() {
		return new String(passwordField2.getPassword());
	}

	@Override
	public boolean getCaptcha() {
		return captcha.isSelected();
	}

	@Override
	public boolean getTOS() {
		return tos.isSelected();
	}
	
	@Override
	public boolean checkCaptca() {
		lblCaptchaError.setVisible(!getCaptcha());
		return getCaptcha();
	}

	@Override
	public boolean checkTos() {
		lbltosError.setVisible(!getTOS());
		return getTOS();
	}

	@Override
	public boolean checkPasswords() {
		lblPasswordsError.setVisible(!presenter.checkValidPassword(getPassword1(), getPassword2()));
		return presenter.checkValidPassword(getPassword1(), getPassword2());
	}
	
	@Override
	public void confirm(){
		if(checkPasswords()){
			if(checkTos()){
				if(checkCaptca()){
					success = presenter.signup(getUsername(), getPassword1(), getEmail());
					System.out.println(success);
				}
			}
		}
		
	}
}
