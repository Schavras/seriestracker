package core.imdb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import core.types.SimplyDate;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class IMDBEpisode {
	
	String title ,year,rated,released,season,episode,runtime,genre,director,writer,language,actors, plot, country ,  awards   , poster   ,metascore  , imdbrating   , imdbvotes   ,imdbid  ,seriesid  ,type ,response;

	String error;
	
	/**
	 * @param title
	 * @param year
	 * @param rated
	 * @param released
	 * @param season
	 * @param episode
	 * @param runtime
	 * @param genre
	 * @param director
	 * @param writer
	 * @param actors
	 * @param plot
	 * @param language
	 * @param awards
	 * @param poster
	 * @param metascore
	 * @param imdbrating
	 * @param imdbvotes
	 * @param imdbid
	 * @param seriesid
	 * @param type
	 * @param response
	 */
	@JsonCreator
	public IMDBEpisode(@JsonProperty("Title") String title,
			@JsonProperty("Year") String year, 
			@JsonProperty("Rated") String rated,
			@JsonProperty("Released") String released,
			@JsonProperty("Season") String season,
			@JsonProperty("Episode")String episode, 
			@JsonProperty("Runtime") String runtime,
			@JsonProperty("Genre") String genre, 
			@JsonProperty("Director") String director, 
			@JsonProperty("Writer") String writer, 
			@JsonProperty("Actors") String actors,
			@JsonProperty("Plot") String plot, 
			@JsonProperty("Language") String language,
			@JsonProperty("Country") String country, 
			@JsonProperty("Awards") String awards, 
			@JsonProperty("Poster") String poster,
			@JsonProperty("Metascore") String metascore,
			@JsonProperty("imdbRating") String imdbrating,
			@JsonProperty("imdbVotes") String imdbvotes,
			@JsonProperty("imdbID") String imdbid,
			@JsonProperty("seriesID") String seriesid, 
			@JsonProperty("episode") String type, 
			@JsonProperty("Response") String response,
			@JsonProperty("Error") String error) {
		super();
		this.title = title;
		this.year = year;
		this.rated = rated;
		this.released = released;
		this.season = season;
		this.episode = episode;
		this.runtime = runtime;
		this.genre = genre;
		this.director = director;
		this.writer = writer;
		this.actors = actors;
		this.plot = plot;
		this.language = language;
		this.awards = awards;
		this.poster = poster;
		this.metascore = metascore;
		this.imdbrating = imdbrating;
		this.imdbvotes = imdbvotes;
		this.imdbid = imdbid;
		this.seriesid = seriesid;
		this.type = type;
		this.response = response;
		this.country = country;
		this.error = error;
	}
	


	
	
	/**
	 * 
	 */
	public IMDBEpisode() {
		super();
	}


	public String getTitle() {
		return title;
	}

	public SimplyDate  getReleased() {
		return  new SimplyDate(released);
	}





	


	public int getEpisode() {
		return Integer.parseInt(episode);
	}




	public String getPlot() {
		return plot;
	}


	public void setPlot(String plot) {
		this.plot = plot;
	}


	public double getImdbrating() {
		return Double.parseDouble(imdbrating);
	}


	


	public String getImdbid() {
		return imdbid;
	}


	


	public String getResponse() {
		return response;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IMDBEpisode [title=" + title + ", imdbid=" + imdbid
				+ ", response=" + response + "]";
	}
	
	
}
