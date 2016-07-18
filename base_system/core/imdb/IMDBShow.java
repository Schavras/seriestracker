package core.imdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import core.domain.Show;

public class IMDBShow {

	String title,year,rated,released,runtime,genre,director,writer,actors,plot,language,country,awards,poster,metascore,imdbrating,imdbvotes,imdbid,type,response;

	/**
	 * @param title
	 * @param year
	 * @param rated
	 * @param released
	 * @param runtime
	 * @param genre
	 * @param director
	 * @param writer
	 * @param actors
	 * @param plot
	 * @param language
	 * @param country
	 * @param awards
	 * @param poster
	 * @param metascore
	 * @param imdbrating
	 * @param imdbvotes
	 * @param imdbid
	 * @param type
	 * @param response
	 */
	public IMDBShow(
			@JsonProperty("Title")String title,
			@JsonProperty("Year")String year,
			@JsonProperty("Rated")String rated,
			@JsonProperty("Released")String released,
			@JsonProperty("Runtime")String runtime,
			@JsonProperty("Genre")String genre,
			@JsonProperty("Director")String director,
			@JsonProperty("Writer")String writer,
			@JsonProperty("Actors")String actors,
			@JsonProperty("Plot")String plot, 
			@JsonProperty("Language")String language,
			@JsonProperty("Country")String country,
			@JsonProperty("Awards")String awards,
			@JsonProperty("Poster")String poster, 
			@JsonProperty("Metascore")String metascore,
			@JsonProperty("imdbRating")String imdbrating,
			@JsonProperty("imdbVotes")String imdbvotes,
			@JsonProperty("imdbID")String imdbid,
			@JsonProperty("Type")String type,
			@JsonProperty("Response")String response
			) {
		super();
		this.title = title;
		this.year = year;
		this.rated = rated;
		this.released = released;
		this.runtime = runtime;
		this.genre = genre;
		this.director = director;
		this.writer = writer;
		this.actors = actors;
		this.plot = plot;
		this.language = language;
		this.country = country;
		this.awards = awards;
		this.poster = poster;
		this.metascore = metascore;
		this.imdbrating = imdbrating;
		this.imdbvotes = imdbvotes;
		this.imdbid = imdbid;
		this.type = type;
		this.response = response;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IMDBShow [title=" + title + ", year=" + year + ", imdbrating="
				+ imdbrating + ", imdbid=" + imdbid + "]";
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @return the released
	 */
	public String getReleased() {
		return released;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @return the actors
	 */
	public String getActors() {
		return actors;
	}

	/**
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}

	/**
	 * @return the imdbrating
	 */
	public double getImdbrating() {
		return Double.parseDouble(imdbrating);
	}

	/**
	 * @return the imdbid
	 */
	public String getImdbid() {
		return imdbid;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @return the poster
	 */
	public String getPoster() {
		return poster;
	}

	

	/**
	 * Convert to {@link Show} object with same title and imdb id.
	 * @return The show.
	 */
	public Show toShow(){
		return new Show(title, imdbid);
	}
	
	
	
	
}
