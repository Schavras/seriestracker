package core.databaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import core.dao.UserDAO;
import core.domain.User;

public class UserDAOMysql implements UserDAO {

	Connection connection;
	 Statement st = null;
     ResultSet rs = null;
	
	
	
	/**
	 * @param connection
	 */
	public UserDAOMysql(Connection connection) {
		super();
		this.connection = connection;
	}




	@Override
	public User getUserByUserame(String username) {
		User user = new User();
		try{
		st =  connection.createStatement();
        rs = st.executeQuery("SELECT * FROM user where user_username= '"+username+"';");
        if (rs.next()) {
         //   user.
        }
		}catch (SQLException ex){
			
		}
		
		return user;
	}




	@Override
	public boolean newUser(String username, String password, String email) {
		try{
			st =  connection.createStatement();
	        rs = st.executeQuery(
	        "select * from users where user_username = '"+username+"';" 		
	        );
	        if (!rs.next()) {
	        	String query = 	"INSERT INTO `stdb`.`users` (`user_username`,`user_password`,`user_email`) VALUES (?,AES_ENCRYPT(?,'klmr420'),?);";
	        	PreparedStatement preparedStatement = connection.prepareStatement(query);
	        	preparedStatement.setString(1, username);
	        	preparedStatement.setString(2, password);
	        	preparedStatement.setString(3, email);
	        	preparedStatement.executeUpdate();
	        	
	        	return true;
	        }
		}catch (SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}




	@Override
	public User login(String username, String password) {
		User user = new User();
		try{
		st =  connection.createStatement();
        rs = st.executeQuery(
        "select * from users where user_username = '"+ username +"' and user_password=AES_ENCRYPT('"+password+"','klmr420');"		
        );
        if (rs.next()) {
         	if (rs.getString("user_id")!=null){
         		user.setId(rs.getString("user_id"));
         		user.setUsername(rs.getString("user_username"));
         		return user;
         	}
        }
		}catch (SQLException ex){
			ex.printStackTrace();
		}
		
		return null;
	}

}
