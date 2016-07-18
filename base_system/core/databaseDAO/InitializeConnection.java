package core.databaseDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import core.dao.Initialize;

public class InitializeConnection implements Initialize{
	private static Connection connect = null;
	  	  
	  private String url;
	  private String  user;
	  private String password;
	  
	  
	  
	/**
	 * @param url
	 * @param user
	 * @param password
	 */
	public InitializeConnection(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
		try {
			initialize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean initialize() throws Exception {
		
		 try {
			 connect = DriverManager.getConnection(url, user, password);		      
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw e;
		 } 
		 return true;
	}

	public void close() {
		 try {
			 if (connect != null) {
		        connect.close();
		      }
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
	}
	
	public static Connection getConnection(){
		return connect;
	}
		
}


