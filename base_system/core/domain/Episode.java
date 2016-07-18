package core.domain;

import core.domain.info.EpisodeInfo;
import core.types.EpisodeStatus;

/**
 * An episode of the show. Contains the number of the episode, the name of episode, 
 * the plot, rating, and date of release.
 * @since 1.0
 * @author KLMR
 *
 */
public class Episode {
	
	/**
	 * The id of this episode
	 */
	public String  ID;
	
	/**
	 * The number of the episode.
	 */
	private int number;
	
	/**
	 * Holds all information about the episode.
	 */
	private EpisodeInfo info;
	
	/**
	 * Status of current episode
	 * {@link EpisodeStatus}
	 */
	EpisodeStatus status;
	
	
	//--------------------------------Constractors -------------------------------
	/**
	 * Default Constructor.
	 * Set number and rating to 0 , name and plot to empty string, and Default date.
	 */
	public Episode(){
		ID="-1";
		number=0;
		info  = new EpisodeInfo();
		status = EpisodeStatus.UNKNOWN;
	}
	
	/**
	 * Integer Constructor. If we know only the number of the episode.
	 * Set number and rating to 0 , name and plot to empty string, and Default date.
	 * @param number The number of the episode.
	 */
	public Episode(int number){
		this.number=number;
		ID="-1";
		info = new EpisodeInfo();
		status = EpisodeStatus.UNKNOWN;
	}
	
	/**
	 * Integer Constructor. If we know only the number of the episode.
	 * Set number and rating to 0 , name and plot to empty string, and Default date.
	 * @param number The number of the episode.
	 */
	public Episode(String id){
		number = 0;
		ID=id;
		info = new EpisodeInfo();
		status = EpisodeStatus.UNKNOWN;
	}
	

	/**
	 * Full Constructor.
	  * @param number The number of the episode.
	 * @param name The name of the episode.
	 */
	public Episode(String id, int number, EpisodeStatus status) {
		ID = id;
		this.number = number;
		this.status = status;
	}
	
	//----------------------------CUSTOM METHOD-----------------------------
	
	public Episode(String imdbid,int number, EpisodeInfo info) {
		ID = imdbid;
		this.number = number;
		status = EpisodeStatus.UNKNOWN;
		this.info = info;
	}

	/**
	 * Checks if episode is watched.
	 * @return true if episode is watched.
	 */
	public boolean isWatched(){
		return status.equals(EpisodeStatus.WATCHED);
	}
	
	/**
	 * Checks if episode is released.
	 * @return true if episode is released.
	 */
	public boolean isReleased(){
		return status.equals(EpisodeStatus.RELEASED);
	}
	
	public void setEpisodeToWatched(){
		status = EpisodeStatus.WATCHED;
	}

	//--------------------------------GETTERS -------------------------------

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	public EpisodeInfo getInfo() {
		return info;
	}
	
	public EpisodeStatus getStatus(){
		return status;
	}

	//------------------------------- SETTERS --------------------------
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}


	public void setInfo(EpisodeInfo info) {
		this.info = info;
	}
	
	
	/**
	 * @param status  Status of current episode
	 */
	public void setStatus(EpisodeStatus status){
		this.status = status;
	}
	
	//--------------------------- Equals ------------------------

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Episode other = (Episode) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}


	//---------------------------------------- toString -------------------------
	

	@Override
	public String toString() {
		return "Episode [ID=" + ID + ", number=" + number + ", status=" + status + "]";
	}	
}