package core.OmdbApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * This object contains all the {@code public static String} methods, 
 * for obtain and create a String in th json format.
 * Use the OMDB API.
 *  @see <a href="http://www.omdbapi.com/">http://omdbapi.com</a>
 * 
 * @author Stavros Zarpas
 * @since 1.0
 */
public class JsonGettersFromURL {
	
	/**
	 * Gets the json file based on ID of IMDB.
	 * @param id The ID of IDBM object
	 * @return	Json format of object
	 */
	public static String getJSONByImdbID(String id){
		String url = "http://www.omdbapi.com/?i=" + id + "&r=json";
		return connect(url);
	}
	
	public static String getJSONByIdEpisodeSeason(String id, int season, int episode ){
		String url = "http://www.omdbapi.com/?i="+ id +"&Season="+ season +"&Episode="+ season ;
		return connect(url);
	}
	
	public static String getJSONSeasonByID(String id, int season){
		String url = "http://www.omdbapi.com/?i="+id+"&Season="+season;
		return connect(url);
	}
	
	private static String connect(String url){
		URL connection = null; 
		
		//connect to the URL
		try {
			connection = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	        URLConnection cnt = null;
			try {
				cnt = connection.openConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//create inpute buffer reader, to read the string
	        BufferedReader in = null;
			try {
				in = new BufferedReader(
				                        new InputStreamReader(
				                        		cnt.getInputStream()));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			//creating the string from stream.
	        String inputLine = "";
	        String newLine="";

	        try {
				while ((inputLine = in.readLine()) != null){
					newLine+=inputLine;
				}
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
	        //close the input stream
	        try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return newLine;
	}
}
