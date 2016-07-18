package core.databaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import core.dao.ActiveUser;
import core.dao.EpisodeDAO;
import core.domain.Episode;
import core.domain.Show;
import core.domain.User;
import core.types.EpisodeStatus;

public class EpisdeDAOMysql implements EpisodeDAO {

	Connection connection;
	 Statement st = null;
   ResultSet rs = null;
	
	
	
	/**
	 * @param connection
	 */
	public EpisdeDAOMysql(Connection connection) {
		super();
		this.connection = connection;
	}
	
	@Override
	public void loadSeasonEpisodes() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Episode> getEpisodesOfSeason(int showId, int seasonNumber, String user_id) {
		
		return null;
	}

	@Override
	public boolean isStored(int showId, int seasonNumber, int episodeNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Episode updateEpisode(int showId, int seasonNumber, int episodeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEpisode(Episode episode,int seasonNumber, String show_id) {
		try {
    		String query = 	"INSERT INTO `stdb`.`episode`(`episode_id`,`episode_number`,`episode_name`,`season_number`,`show_id`)VALUES"
    				+ "(?,?,?,?,?);";
        	PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, episode.getID());
			preparedStatement.setInt(2, episode.getNumber());
			preparedStatement.setString(3, episode.getInfo().getTitle());
			preparedStatement.setInt(4, seasonNumber);
			preparedStatement.setString(5, show_id);
	    	preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void setStatusToWatched(Episode episode) {
		try {
    		String query = 	"INSERT INTO `stdb`.`user_episode`(`episode_id`,`user_id`)VALUES"
    				+ "(?,?);";
        	PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, episode.getID());
			preparedStatement.setInt(2,  ActiveUser.ACTIVE_USER.getId());
			 preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		episode.setStatus(EpisodeStatus.WATCHED);
		
	}

	@Override
	public EpisodeStatus getStatus(int user_id, String episode_id) {
		try{
			st =  connection.createStatement();
			String query = " SELECT * FROM user_episode where user_id = "+ user_id +" and episode_id = '"+episode_id+"';";
	        rs = st.executeQuery(query);
	        if (rs.next()) {
	        	return EpisodeStatus.WATCHED;
	        }else{
	        	return EpisodeStatus.RELEASED;
	        }
			}catch (SQLException ex){
				ex.printStackTrace();
			}
			return EpisodeStatus.UNKNOWN;
	
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ArrayList getEpisodesByUser(User user) {
		ArrayList<ArrayList> results = new ArrayList();
		
		try{
			st =  connection.createStatement();
			String query = " select "
				+"user_show.show_id,  episode.season_number, episode.episode_number,episode.episode_name,episode.episode_id"
				+" from stdb.episode "
				+"inner join user_show " 
				+"on episode.show_id=user_show.show_id "
				+"where user_show.user_id =" +user.getId()
				+" order by episode.show_id,episode.season_number,episode.episode_number;";
	        rs = st.executeQuery(query);
	        
	        while(rs.next()){
	        	//create temporary list
	        	ArrayList tempList = new ArrayList();
	        	//add results to temporary list
	        	tempList.add(rs.getString("user_show.show_id")); 
	        	tempList.add(rs.getInt("episode.season_number"));
	        	tempList.add(rs.getInt("episode.episode_number"));
	        	tempList.add(rs.getString("episode.episode_name"));
	        	tempList.add(rs.getString("episode.episode_id"));
	        	
	        	//add temporary list to your multidimensionallist
	        	results.add(tempList);
	        	}
	        
	        
			}catch (SQLException ex){
				ex.printStackTrace();
			}
			
		return results;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ArrayList getWatchedEpisode(int user_id) {
		ArrayList<ArrayList> results = new ArrayList();
		
		try{
			st =  connection.createStatement();
			String query = " select "
				+"episode.episode_number , episode.show_id ,episode.season_number"
				+" from stdb.user_episode "
				+"inner join stdb.episode " 
				+"on stdb.episode.episode_id = stdb.user_episode.episode_id "
				+"where user_episode.user_id =  "+user_id;
	        rs = st.executeQuery(query);
	        
	        while(rs.next()){
	        	//create temporary list
	        	ArrayList tempList = new ArrayList();
	        	//add results to temporary list
	        	tempList.add(rs.getInt("episode.episode_number"));
	        	tempList.add(rs.getString("episode.show_id"));
	        	tempList.add(rs.getInt("episode.season_number"));
	        	
	        	//add temporary list to your multidimensionallist
	        	results.add(tempList);
	        	}
	        
	        
			}catch (SQLException ex){
				ex.printStackTrace();
			}
		
		
		return results;
	}

}
