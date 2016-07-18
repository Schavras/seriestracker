package core.domain.info;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import core.types.SimplyDate;

/**
 * Represent a summary of the information from IMDB for a
 * single Episode.
 * @author Stavros Zarpas
 * @since
 */
@JsonIgnoreProperties(ignoreUnknown = true) 
public class EpisodeInfo {

	
	String title;
	int year;
	String rated;
	SimplyDate released;
	int season;
	int episode;
	String runtime;
	String genre;
	String director;
	String writer;
	String language;
	String actors;
	String plot;
	String country;
	String awards;
	String poster;
	String metascore;
	double imdbrating;
	String imdbvotes;
	String imdbid;
	String seriesid;
	String type;
	String response;
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
	public EpisodeInfo(@JsonProperty("Title") String title,
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
		this.year = Integer.parseInt(year);
		this.rated = rated;
		this.released = new SimplyDate(released);
		this.season = Integer.parseInt(season);
		this.episode = Integer.parseInt(episode);
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
		this.imdbrating = Double.parseDouble(imdbrating);
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
	public EpisodeInfo() {
		super();
	}

	
	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getRated() {
		return rated;
	}

	public SimplyDate getReleased() {
		return released;
	}

	public int getSeason() {
		return season;
	}

	public int getEpisode() {
		return episode;
	}

	public String getRuntime() {
		return runtime;
	}

	public String getGenre() {
		return genre;
	}

	public String getDirector() {
		return director;
	}

	public String getWriter() {
		return writer;
	}

	public String getLanguage() {
		return language;
	}

	public String getActors() {
		return actors;
	}

	public String getPlot() {
		return plot;
	}

	public String getCountry() {
		return country;
	}

	public String getAwards() {
		return awards;
	}

	public String getPoster() {
		return poster;
	}

	public String getMetascore() {
		return metascore;
	}

	public double getImdbrating() {
		return imdbrating;
	}

	public String getImdbvotes() {
		return imdbvotes;
	}

	public String getImdbid() {
		return imdbid;
	}

	public String getSeriesid() {
		return seriesid;
	}

	public String getType() {
		return type;
	}

	public String getResponse() {
		return response;
	}

	public String getError() {
		return error;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Episode info[title=" + title + ", imdbid=" + imdbid
				+ ", response=" + response + "]";
	}
	
	
}
