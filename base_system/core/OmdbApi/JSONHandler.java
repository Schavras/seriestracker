package core.OmdbApi;


import java.io.IOException;
import java.util.StringTokenizer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import core.domain.Episode;
import core.domain.Season;
import core.domain.Show;
import core.domain.info.EpisodeInfo;
import core.domain.info.ShowInfo;
import core.imdb.IMDBEpisode;
import core.imdb.IMDBSeason;
import core.imdb.IMDBShow;
public class JSONHandler {
	
	public static Show getFullShow(String json){
		ShowInfo info = new ShowInfo();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//JSON from String to Object
		   try {
			   info = mapper.readValue(json, ShowInfo.class);
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		   
		return new Show(info.getTitle(), info.getImdbid(),info);
		
	}

	
	/**
	 * Convert {@link JSONObject} to {@link Episode}
	 * @param json
	 * @return
	 */
	@JsonCreator
	public static Episode JSONToEpisode(String json){
		
		
		EpisodeInfo info = new EpisodeInfo();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//Episode imdbEpisode = null;
		//JSON from String to Object
		   try {
			   info = mapper.readValue(json, EpisodeInfo.class);
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		   System.out.println(info);
	   if( info.getResponse()==null){
			return null;
		}
	   
	   Episode episode =new Episode(info.getImdbid(),info.getEpisode(),info);
	   
	   return episode;
	
	}
	
//	private static Episode imdbToEpisode(IMDBEpisode imdbEpisode){
//		Episode episode = new Episode();	
//		episode.setDateOfRelease(imdbEpisode.getReleased());
//		episode.setID(imdbEpisode.getImdbid());
//		episode.setTitle(imdbEpisode.getTitle());
//		episode.setNumber(imdbEpisode.getEpisode());
//		episode.setPlot(imdbEpisode.getPlot());
//		episode.setRating(imdbEpisode.getImdbrating());
//
//		return episode;
//	}
	
/*	*//**
	 * Convert {@link JSONObject} to {@link Episode}
	 * @param json
	 * @return
	 *//*
	@JsonCreator
	public static Show JSONToShow(String json){
		
		Show show = new Show();
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		IMDBShow imdbEpisode = null;
		//JSON from String to Object
		   try {
			   imdbEpisode = mapper.readValue(json, IMDBShow.class);
		} catch (JsonParseException e) {
			
			e.printStackTrace();
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		show.setActors(imdbEpisode.getActors());
		show.setDirector(imdbEpisode.getDirector());
		show.setID(imdbEpisode.getImdbid());
		show.setName(imdbEpisode.getTitle());
		show.setRating(imdbEpisode.getImdbrating());
		String deli = "–";
		
		String yearRange = imdbEpisode.getYear();
		StringTokenizer token = new StringTokenizer(yearRange);

		yearRange = token.nextToken(deli);
		int year = Integer.parseInt(yearRange);
		show.setStartingYear(year);
		
		if(token.hasMoreTokens())	{
			yearRange = token.nextToken();
			show.setLastYear(year);
		}
	

		return show;
	
	}
	*/
//
//	public static Season JSONToSeason(String json){
//		Season season;
//		
//
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		IMDBSeason imdbSeason = null;
//		//JSON from String to Object
//		   try {
//			   imdbSeason = mapper.readValue(json, IMDBSeason.class);
//		} catch (JsonParseException e) {
//			
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			
//			e.printStackTrace();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		   
//		if( imdbSeason.getResponse().equals("False")){
//			return null;
//		}  
//		
//		int number = Integer.parseInt(imdbSeason.getSeason()); 
//		Episode[] episodes = new Episode[imdbSeason.getEpisodes().size()];
//		
//		for(int i = 0 ; i < imdbSeason.getEpisodes().size() ; i++){
//			episodes[i] = imdbToEpisode(imdbSeason.getEpisodes().get(i));
//		}
//		int totalNumberOfEpisodes = episodes.length;
//		season = new Season(number, totalNumberOfEpisodes, episodes, false);
//		return season;
//		
//	}
//	
}
