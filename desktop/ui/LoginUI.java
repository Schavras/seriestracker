package ui;

import presenter.LoginPresenter;
import presenter.MainScreenPresenter;
import presenter.SignUpPresenter;
import ui.views.LoginView;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;

import buttons.BlueButton;

public class LoginUI extends DefaultJPanel implements LoginView{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3556916293733789578L;
	
	JLabel lblError;
	private JTextField usernameTF;
	private LoginPresenter presenter;
	private JPasswordField passwordTF;
	private boolean success;
	
	public LoginUI() {
		
		JLabel picLabel;
		try {
			picLabel = new JLabel(new ImageIcon((BufferedImage)ImageIO.read(new File("Resources/Title.jpg"))));
			add(picLabel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		usernameTF = new JTextField();
		usernameTF.setBounds(621, 331, 86, 20);
		add(usernameTF);
		usernameTF.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(621, 306, 86, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(621, 362, 86, 14);
		add(lblPassword);
		
		BlueButton btnLogin = new BlueButton("Login");
		//btnLogin.setForeground(UIManager.getColor("Button.focus"));
		btnLogin.setBackground(new Color(59 ,89, 182));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				success = login();
				openMainScreen();
			}
		});
		btnLogin.setBounds(557, 438, 89, 23);
		add(btnLogin);
		
		BlueButton btnSignUp = new BlueButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				openSignUp();
			}
		});
		btnSignUp.setBounds(683, 438, 89, 23);
		add(btnSignUp);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcome.setBounds(608, 234, 99, 39);
		add(lblWelcome);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(621, 387, 86, 20);
		add(passwordTF);
		
		lblError = new JLabel("Invalid username and/or password");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblError.setBounds(523, 472, 264, 45);
		lblError.setVisible(false);
		add(lblError);
		
//		CustomShowList list = new CustomShowList();
//		list.setBounds(0, 26, 547, 350);
//		add(list);
	}
	
	

	protected void openSignUp() {
		SignUpUI su = new SignUpUI();
		SignUpPresenter presenter = new SignUpPresenter(su);
		presenter.start();
		
	}



	@Override
	public String getUsername() {
		return usernameTF.getText();
	}

	@Override
	public String getPassword() {
		return new String(passwordTF.getPassword());
	}



	@Override
	public void setLoginPresenter(LoginPresenter presenter) {
		this.presenter= presenter;
		
	}



	@Override
	public boolean login() {
		return presenter.login(getUsername(), getPassword());
	}



	@Override
	public void openMainScreen() {
		if(success){
			MainScreenUI s = new MainScreenUI();
			MainScreenPresenter presenter = new MainScreenPresenter(s);
			presenter.start();
		}else{
			lblError.setVisible(true);
		}
	}
	
	
}
