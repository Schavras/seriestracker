package core.imdb;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMDBSeason {

	
    public ArrayList<IMDBEpisode> episodes;
	
	public String title,season,response;

	/**
	 * @param episodes
	 * @param title
	 * @param season
	 * @param response
	 */
	public IMDBSeason(
			@JsonProperty("Episodes")ArrayList<IMDBEpisode> episodes,
			@JsonProperty("Title")String title,
			@JsonProperty("Season")String season,
			@JsonProperty("Response")String response
			) {
		super();
		this.episodes = episodes;
		this.title = title;
		this.season = season;
		this.response = response;
	}

	/**
	 * @return the episodes
	 */
	public ArrayList<IMDBEpisode> getEpisodes() {
		return episodes;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the season
	 */
	public String getSeason() {
		return season;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param episodes the episodes to set
	 */
	public void setEpisodes(ArrayList<IMDBEpisode> episodes) {
		this.episodes = episodes;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param season the season to set
	 */
	public void setSeason(String season) {
		this.season = season;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IMDBSeason [episodes=" + episodes + ", title=" + title
				+ ", season=" + season + ", response=" + response + "]";
	}

}
