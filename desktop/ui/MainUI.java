package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import core.dao.Initialize;
import core.databaseDAO.EpisdeDAOMysql;
import core.databaseDAO.InitializeConnection;
import core.databaseDAO.ShowDAOMysql;
import core.databaseDAO.ShowDAOMysqlTest;
import core.services.ShowManager;
import presenter.LoginPresenter;

import java.awt.CardLayout;

public class MainUI {
	
	String url = "jdbc:mysql://192.168.2.4:3306/stdb";
	//String url = "jdbc:mysql://series-tracker.ddns.net/:3306/stdb";
	String user="myuser";
	String password = "mypass";
	
	
	public static final String APP_TITLE = "Series Tracker";
	static JFrame stFrame;
 	static JPanel scenes = new JPanel();
  	static CardLayout cl = new CardLayout();
  	
  	Initialize init;
  	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					MainUI window = new MainUI();
					MainUI.stFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
 			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		init = new InitializeConnection(url, user, password);
		
		EpisdeDAOMysql Edao = new EpisdeDAOMysql(InitializeConnection.getConnection());
		ShowDAOMysql Sdao = new ShowDAOMysql(InitializeConnection.getConnection());
		ShowManager mng = new ShowManager(Edao, Sdao);
		
		stFrame = new JFrame();
		stFrame.setTitle(APP_TITLE);
		stFrame.setBounds(100, 100, 1280, 750);
		stFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scenes.setLayout(cl);
		
		LoginUI login = new LoginUI();
		LoginPresenter presenter = new LoginPresenter(login);
		presenter.start();
		
		
		MainUI.stFrame.getContentPane().add(MainUI.scenes);
	
	}

}
