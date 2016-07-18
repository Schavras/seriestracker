package core.domain;

import java.util.ArrayList;

import core.domain.info.ShowInfo;
import core.types.EpisodeStatus;

/**
 * Represent a show. Contains the id of the show, based on IMDB.
 * The name of the show, a list of seasons, starting and ending year,
 * and rating of the show.
 * @author Stavros Zarpas
 * @since
 */
public class Show {
	
	/**
	 * The ID of the show
	 */
	String ID;
	
	/**
	 * The name of the show.
	 */
	String name;
	
	/**
	 * A list of seasons.
	 */
	ArrayList<Season> seasons ;
	
	/**
	 * Holds the information for this show.
	 */
	ShowInfo info;
	
	//-----------------Constructors-------------
	
	/**
	 * @param name
	 */
	public Show(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * @param name
	 * @param id
	 */
	public Show(String name,String id) {
		super();
		this.name = name;
		this.ID = id;
	}
	
	/**
	 * @param name
	 */
	public Show(String name,String id,ShowInfo info) {
		super();
		this.name = name;
		this.ID = id;
		this.info=info;
	}
	

	/**
	 * Default Constructor
	 */
	public Show() {
		super();
	}

	/**
	 * @param iD
	 * @param name
	 * @param seasons
	 * @param startingYear
	 * @param lastYear
	 * @param director
	 * @param actors
	 * @param rating
	 */
	public Show(String iD, String name, ArrayList<Season> seasons) {
		super();
		ID = iD;
		this.name = name;
		this.seasons = seasons;
	}

	// --------------------------Custom Methods ----------------------------
	public void addSeason(int index, Season season){
		seasons.add(index, season);
	}
	

	public void addSeason(Season season){
		seasons.add(season.getNumber(), season);
	}
	
	
	/**
	 * Return the first {@link Episode} that has not been 
	 * watched by the user. If all episodes of all 
	 * season have been watched, return null.
	 * @return 	First unseen episode, null otherwise
	 */
	public Episode getFirstUnseen(){
		for(int i =0 ; i< seasons.size();i++){
			if(!seasons.get(i).checkCompleted()){
				return seasons.get(i).getNextEpisode();
			}
		}
		return null;
	}

	/**
	 * Gets the first unseen episode and set it's status to
	 * watched. If there isn't a next episode, return.
	 */
	public void setNextSeen(){
		Episode h = getFirstUnseen();
		if(h != null) h.setEpisodeToWatched();
		else return;
	}
	
	//-------------------------- Getters ---------------------------------------
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the seasons
	 */
	public ArrayList<Season> getSeasons() {
		return seasons;
	}

	

	public ShowInfo getInfo() {
		return info;
	}

	
	//--------------------------Setters ---------------------------------------

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param seasons the seasons to set
	 */
	public void setSeasons(ArrayList<Season> seasons) {
		this.seasons = seasons;
	}
	

	public void setInfo(ShowInfo info) {
		this.info = info;
	}

	
	// ------------------------- toString ------------------
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Title= " + name + " " +" # of seasons = " + seasons.size() + " imdbid= "+ ID + "\n"; 
	}
		
}
