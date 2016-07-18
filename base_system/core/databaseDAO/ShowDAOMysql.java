package core.databaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import core.dao.ActiveUser;
import core.dao.ShowDAO;
import core.domain.Show;
import core.domain.User;
import core.services.ShowManager;

public class ShowDAOMysql implements ShowDAO {

	Connection connection;
	 Statement st = null;
    ResultSet rs = null;
	
	
	
	/**
	 * @param connection
	 */
	public ShowDAOMysql(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public ArrayList<Show> getShowsByUser(User user) {
		ArrayList<Show> shows = new ArrayList<Show>();
		try{
			st =  connection.createStatement();
			String query = " SELECT user_show.show_id, shows.show_name FROM user_show left join shows on user_show.show_id =  shows.show_id WHERE user_show.user_id= '"+
					user.getId()+"';";
	        rs = st.executeQuery(query);
	        while (rs.next()) {
	        	shows.add(new Show(rs.getString(2), rs.getString(1)));
	        }
			}catch (SQLException ex){
				ex.printStackTrace();
			}
		return shows;	
	}

	@Override
	public Show getByID(String id) {
		// TODO write method
		return null;
	}

	@Override
	public boolean addShow(Show show) {
		try{
			
	        if (!exist(show)) {
	        	createShow(show);
	        }
	        
	        st =  connection.createStatement();
	        rs = st.executeQuery("select * from user_show where show_id = '"+show.getID()+"' and user_id = '"+ActiveUser.ACTIVE_USER.getId()+"' ;"  );
	        if (!rs.next()) {
	        	String query = 	"INSERT INTO `stdb`.`user_show`  VALUES (?,?);";
	        	PreparedStatement preparedStatement = connection.prepareStatement(query);
	        	preparedStatement.setInt(1, ActiveUser.ACTIVE_USER.getId());
	        	preparedStatement.setString(2, show.getID());
	        	
	        	preparedStatement.executeUpdate();
	        	return true;
	        }
	        
	        
		}catch (SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean exist(Show show) {
		try {
			st =  connection.createStatement();
			 rs = st.executeQuery(
				        "select * from shows where show_id = '"+show.getID()+"';" 		
				        );
				        return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
       
	}

	@Override
	public void createShow(Show show) {
		
    	try {
    		String query = 	"INSERT INTO `stdb`.`shows` (`show_id`,`show_name`) VALUES (?,?);";
        	PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, show.getID());
			preparedStatement.setString(2, show.getName());
	    	preparedStatement.executeUpdate();
	    	
	    	
	    	
		} catch (SQLException e) {

			e.printStackTrace();
		}
    
	}

}
