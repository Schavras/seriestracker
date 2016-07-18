/**
 * 
 */
package core.domain.info;

import java.util.StringTokenizer;

import com.fasterxml.jackson.annotation.JsonProperty;

import core.types.SimplyDate;

/**
 * @author Stavros Zarpas
 * @since 
 */
public class ShowInfo {


	String title;
	String year;
	String rated;
	SimplyDate released;
	String runtime;
	String genre;
	String director;
	String writer;
	String actors;
	String plot;
	String language;
	String country;
	String awards;
	String poster;
	String metascore;
	double imdbrating;
	String imdbvotes;
	String imdbid;
	String type;
	String response;
	
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
	public ShowInfo(
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
		this.released = new SimplyDate(released);
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
		this.imdbrating = Double.parseDouble(imdbrating);
		this.imdbvotes = imdbvotes;
		this.imdbid = imdbid;
		this.type = type;
		this.response = response;
	}
	
	public ShowInfo(){
		super();
	}

	public String getTitle() {
		return title;
	}

	public String getYear() {
		return year;
	}

	public String getRated() {
		return rated;
	}

	public SimplyDate getReleased() {
		return released;
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

	public String getActors() {
		return actors;
	}

	public String getPlot() {
		return plot;
	}

	public String getLanguage() {
		return language;
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

	public String getType() {
		return type;
	}

	public String getResponse() {
		return response;
	}

	/*public void setYear(String yearRange){
		String deli = "–";
		
		
		StringTokenizer token = new StringTokenizer(yearRange);

		yearRange = token.nextToken(deli);
		int year = Integer.parseInt(yearRange);
		show.setStartingYear(year);
		
		if(token.hasMoreTokens())	{
			yearRange = token.nextToken();
			this.year = year;
		}
	
	}
	*/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IMDBShow [title=" + title + ", year=" + year + ", imdbrating="
				+ imdbrating + ", imdbid=" + imdbid + "]";
	}

	
}
