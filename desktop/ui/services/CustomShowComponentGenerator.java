package ui.services;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import ui.CustomShowComponent;
import core.OmdbApi.JSONHandler;
import core.OmdbApi.JsonGettersFromURL;
import core.dao.ActiveUser;
import core.databaseDAO.InitializeConnection;
import core.databaseDAO.ShowDAOMysql;
import core.domain.Episode;
import core.domain.Show;
import core.imdb.IMDBShow;
import core.services.ShowManager;
import core.types.Poster;

public class CustomShowComponentGenerator {
	
	static ArrayList <CustomShowComponent> shows;
	
	
	String id;
	Show imdbshow;
	Episode nextEpisode;
	
	public CustomShowComponentGenerator(String id) {
		this.id = id;
		String json = JsonGettersFromURL.getJSONByImdbID(id);
		imdbshow = JSONHandler.getFullShow(json);
	}
	
	
	
	public BufferedImage getPoster(){
		
		return Poster.getPoster(imdbshow.getInfo().getPoster(),53, 78);
       
	}
	
	public String getTitle(){
		return imdbshow.getInfo().getTitle();
	}
	
	public String getNextEpisode(){
		String next = null;
		for(int i = 0; i  <ActiveUser.ACTIVE_USER.getShows().size() ; i++){
			if (ActiveUser.ACTIVE_USER.getShows().get(i).getID().equals(id)){
				nextEpisode = ActiveUser.ACTIVE_USER.getShows().get(i).getFirstUnseen();
				next = String.valueOf(nextEpisode);
			}
		}
		
		if(next.equals("null")){
			return "No unseen episode";

		}else{
			return "Next Episode= " +next;
		}
	}
	
	public void watchNextEpisode(){
		ShowManager.changeEpisodeStatusToWatched(nextEpisode);
	}
	
	
	
	public static ArrayList<CustomShowComponent> generateList(){
		
		ArrayList<Show> shows = ShowManager.loadAllShows(ActiveUser.ACTIVE_USER);
		//System.out.println(shows);
		ArrayList<CustomShowComponent> comp = new ArrayList<CustomShowComponent>();
		
		for(int i = 0 ; i < shows.size() ; i++){
			comp.add(new CustomShowComponent(shows.get(i).getID()));
		}
		
		
		return comp;
	}
	
}
