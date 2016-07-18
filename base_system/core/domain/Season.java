 /**
 * 
 */
package core.domain;

import java.util.ArrayList;

import core.domain.info.SeasonInfo;
import core.types.EpisodeStatus;

/**
 * Represent a season of a show. Contains list of {@link Episode}
 * @author Stavros Zarpas
 * @since 1.0
 *
 */
public class Season {
	
	
	
	/**
	 * The number of the season.
	 */
	private int number;
	 
	/**
	 * The total number of episodes.
	 */
	private int totalNumberOfEpisodes;
	
	
	/**
	 * Stores every episode of this season.
	 */
	private Episode[] episodes;

	private boolean completed;

	private SeasonInfo info;
	
	// ---------------------Constractors ---------------------
	
	
	/**
	 * Full constractor of season
	 * @param number The number of the season
	 * @param totalNumberOfEpisodes The total number of episodes.
	 * @param episodes every episode of this season.
	 */
	public Season(int number, int totalNumberOfEpisodes,
			Episode[] episodes, boolean completed) {
		this.number = number;
		this.totalNumberOfEpisodes = totalNumberOfEpisodes;
		this.episodes = episodes;
		this.completed = completed;
	}

	/**
	 * Contractor with the number of season and total number of episodes.
	 * @param number The number of season.
	 * @param totalNumberOfEpisodes Total number of episodes
	 */
	public Season(int number, int totalNumberOfEpisodes) {
		this.number = number;
		this.totalNumberOfEpisodes = totalNumberOfEpisodes;
		episodes = new Episode[totalNumberOfEpisodes];
	}
	
	
	/**
	 * Minimum contractor, with only the number of the season
	 * @param number
	 */
	public Season(int number){
		this.number = number;
		totalNumberOfEpisodes = 0;
		episodes = new Episode[totalNumberOfEpisodes];
	}
	
	//  ---------------------  Custom methods ----------------------------
	
	
	/**
	 *  Get spefic episode of the season, if exist.
	 * @param number The number of the episode.
	 * @return The spefic object if exist, {@code null} otherwise.
	 */
	public Episode getSpecificEpisode(int number){
	//Check if number is invalid.
		if(number < 1 || number > totalNumberOfEpisodes  ){
			return null;
		}
		
	//Return the episode at index number-1.
		return episodes[number-1];
	}
	
	
	/**
	 * Adds a new episode in this season.
	 * @param newEpisode The new episode to be added
	 * @return
	 */
	public boolean updateEpisode(Episode newEpisode){
		
	//Check if number of episode is negative
		if(newEpisode.getNumber() < 1){
			return false;
		}
		
	//If episode's number is less or equals than total number of episodes
		if(newEpisode.getNumber() <= totalNumberOfEpisodes){
			
			//replace the episode with same number with the new episode
				episodes[newEpisode.getNumber() -1] = newEpisode;
			//return success.
				return true;
		
	//if episode's number is greater than total number of episodes.
		}else{
		
		//Make new array with length equal to the number of new episode
			resize(newEpisode.getNumber());
		//Add the new episode.
			episodes[newEpisode.getNumber() -1] = newEpisode;
			
			return true;
		}
	}


	/**
	 * Resize the array and copy the current data to the new array.
	 * @param newSize New {@link #totalNumberOfEpisodes total}  number of episodes.
	 */
	protected void resize(int newSize) {
	//If size is negative
		if (newSize < 0){
		// Delete the array and set total number of episodes to 0.
			totalNumberOfEpisodes = 0;
			episodes = new Episode[totalNumberOfEpisodes];
			return;
		}
	//Create new temporary array.
		Episode[] temp = new Episode[newSize];

	//Finds the min of the two number, in order not to get out of bounds
		int min = Math.min(episodes.length, newSize);
	//Copy existing episodes.
		for (int i = 0 ; i < min ; i++){
			temp[i] = episodes[i];
		}
		
	//Set new total number of episodes.
		totalNumberOfEpisodes= newSize;
		
	//Set episode array into the new array.
		episodes = temp;
	}
	
	
	/**
	 * Checks the whole season is watched. Check each episode
	 * of the season, and if there is one with status other than
	 * {@link EpisodeStatus#WATCHED watched} sets completed to false, and return false.
	 * 
	 * @return {@code true} if the season is completed, {@code false} otherwise
	 */
	public boolean checkCompleted(){
		
		if (completed == true) return true;
		
		for (int i = 0 ; i < totalNumberOfEpisodes ; i++){
			if(!episodes[i].isWatched()){
				completed = false;
				return false;
			}
		}
		completed=true;
		return true;
	}
	
	/**
	 * Get the first {@link Episode} with status {@link EpisodeStatus#RELEASED RELEASED}
	 * @return the first unwatched episode
	 */
	public Episode getNextEpisode(){
		for(int i= 0 ; i < totalNumberOfEpisodes; i++){
			if(episodes[i].isReleased()){
				return episodes[i];
			}
		}
		return null;
	}
	
	public void setEpisodes(ArrayList<Episode> episodesList){
		totalNumberOfEpisodes = episodesList.size();
		episodes = new Episode[totalNumberOfEpisodes];
		
		for (int i = 0 ; i < totalNumberOfEpisodes ; i++){
			episodes[i] = episodesList.get(i);
		}
	}
	// ----------------------------------  Equals ------------------------------------

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Season other = (Season) obj;
			if (number != other.number)
			return false;
		if (totalNumberOfEpisodes != other.totalNumberOfEpisodes)
			return false;
		return true;
	}

	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + totalNumberOfEpisodes;
		return result;
	}
	
	// -------------------  GETTERS -------------
	


	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the totalNumberOfEpisodes
	 */
	public int getTotalNumberOfEpisodes() {
		return totalNumberOfEpisodes;
	}

	/**
	 * @return the episodes
	 */
	public Episode[] getEpisodes() {
		return episodes;
	}
	
	/**
	 * @return the completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	
	//------------------------ SETTERS -----------------------------
	

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @param totalNumberOfEpisodes the totalNumberOfEpisodes to set
	 */
	public void setTotalNumberOfEpisodes(int totalNumberOfEpisodes) {
		this.totalNumberOfEpisodes = totalNumberOfEpisodes;
	}

	/**
	 * @param episodes the episodes to set
	 */
	public void setEpisodes(Episode[] episodes) {
		this.episodes = episodes;
	}


	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	
	//-------------------------------------- toString -------------------------
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Season #" + number+ " Total Number Of Episodes = " + totalNumberOfEpisodes;
	}

	
	
}
