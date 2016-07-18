package core.dao;

import java.util.ArrayList;

import core.dao.EpisodeDAO;
import core.domain.Episode;
import core.domain.User;
import core.types.EpisodeStatus;
import core.types.SimplyDate;

/**
 * We use this stub for testing seasons. 
 * It represents a {@link EpisodeDAO} object,
 * with controled behavor.
 * 
 * @author Stavros Zarpas
 * @since 1.0
 */
public class EpisodeDAOStub implements EpisodeDAO{
	
	/**
	 * Active arraylist of episodes.
	 */
	ArrayList<Episode> 	episodes;
	
	/**
	 * Test episode #1.
	 */
	Episode episode1;
	
	/**
	 * Test episode #2.
	 */
	Episode episode2;

	/**
	 * Custom contractor. Sets episodes from paramentrs.  
	 * @param episode1 First Episode.
	 * @param episode2 Second Episode.
	 */
	public EpisodeDAOStub( Episode episode1, Episode episode2) {
		super();
		episodes = new ArrayList<Episode>();
		this.episode1 = episode1;
		this.episode2 = episode2;
	}
	

	/**
	 * Default contractor. Call default {@link Episode#Episode() default Episode constractor}
	 * for both episodes.
	 *  
	 */
	public EpisodeDAOStub() {
		episodes = new ArrayList<Episode>();
		episode1 = new Episode("id1",1,EpisodeStatus.UNKNOWN);
		episode2 = new Episode("id2",2,EpisodeStatus.UNKNOWN);
	}

	/**
	 * Adds test episodes into list.
	 */
	@Override
	public void loadSeasonEpisodes() {
		episodes.add(episode1);
		episodes.add(episode2);
		
	}

	


	/**
	 * If the episode number is 0 , then it returns true. In any other case,
	 * returns false.
	 */
	@Override
	public boolean isStored(int showId, int seasonNumber, int episodeNumber) {
		if(episodeNumber == 0){
			return true;
		}else{
			return false;
		}
	}


	@Override
	public Episode updateEpisode(int showId, int seasonNumber, int episodeNumber) {
		return null;
	}


	@Override
	public void addEpisode(Episode episode, int seasonNumber, String show_id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setStatusToWatched(Episode episode) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public EpisodeStatus getStatus(int user_id, String episode_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Episode> getEpisodesOfSeason(int showId, int seasonNumber,
			String user_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList getEpisodesByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList getWatchedEpisode(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}
