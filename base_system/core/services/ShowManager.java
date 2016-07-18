package core.services;

import java.util.ArrayList;

import core.OmdbApi.JSONHandler;
import core.OmdbApi.JsonGettersFromURL;
import core.dao.ActiveUser;
import core.dao.EpisodeDAO;
import core.dao.ShowDAO;
import core.domain.Episode;
import core.domain.Season;
import core.domain.Show;
import core.domain.User;
import core.types.EpisodeStatus;

public class ShowManager {

	static EpisodeDAO dao;
	static ShowDAO	sDao;
	static ArrayList<Show> shows  = new ArrayList<Show>();
	public ShowManager(EpisodeDAO dao, ShowDAO	sDao){
		ShowManager.sDao = sDao;
		ShowManager.dao = dao;
	}	
	
	//add new show
	public static void createShow(Show show){
		int seasonNumber = 1;
		
		
		String json = JsonGettersFromURL.getJSONSeasonByID(show.getID(), seasonNumber);
		Season season = JSONHandler.JSONToSeason(json);
		while(season!=null){
			for(int i = 0 ; i < season.getTotalNumberOfEpisodes() ; i ++){
				dao.addEpisode(season.getEpisodes()[i],seasonNumber,show.getID());
			}
			seasonNumber++;
			json = JsonGettersFromURL.getJSONSeasonByID(show.getID(), seasonNumber);
			season = JSONHandler.JSONToSeason(json);
		}
		
	}
	
	
	@SuppressWarnings({ "unchecked" })
	public static ArrayList<Show> loadAllShows(User user){
		shows  = new ArrayList<Show>();		
		shows = generateShows(dao.getEpisodesByUser(user));
		
		user.setShows(shows);
		return user.getShows();
	}

	@SuppressWarnings("rawtypes")
	private static ArrayList<Show> generateShows(ArrayList<ArrayList> result){
		
	//	ArrayList<Show> shows = new ArrayList<Show>();
		if(result.size() == 0) return shows;
		ArrayList<Episode> episodes = new ArrayList<Episode>();
		ArrayList<Season> seasons =  new ArrayList<Season>();
		
		String currentShow;
		int currentSeason;
		
		currentShow = (String) result.get(0).get(0);
		Show show = new Show();
		show.setID(currentShow);
		
		
		currentSeason = 1;
		Season season = new Season(currentSeason);
		
		Episode episode;
		for ( int i = 0 ; i < result.size() ; i++){
			if(!( (String) (result.get(i).get(0))).equals((String)currentShow)){
				season.setEpisodes(episodes);
				seasons.add(season);
				
				episodes = new ArrayList<Episode>();
				
				show.setSeasons(seasons);
				shows.add(show);
				
				show = new Show();
				currentShow = (String) result.get(i).get(0);
				show.setID(currentShow);
				
				currentSeason = 1;
				season = new Season(currentSeason);
				seasons = new ArrayList<Season>();
			}
			
			if(! ( ((int) result.get(i).get(1)) == ( (int) currentSeason)) ){
				season.setEpisodes(episodes);
				seasons.add(season);
				
				currentSeason++;
				season = new Season(currentSeason);
				episodes = new ArrayList<Episode>();
			}
			
			episode = new Episode();
			episode.setID((String) result.get(i).get(4));
			episode.setTitle( (String) result.get(i).get(3));
			episode.setNumber((int) result.get(i).get(2));
			episode.setStatus(EpisodeStatus.RELEASED);
			episodes.add(episode);
		}
		
		season.setEpisodes(episodes);
		seasons.add(season);
		show.setSeasons(seasons);		
		shows.add(show);
		
		
		changeWatchedStatus(shows);
	//	System.out.println(shows.get(0).getSeasons().get(1).getEpisodes()[0]);
		return shows;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void changeWatchedStatus(ArrayList<Show> showds) {
		ArrayList<ArrayList> results = dao.getWatchedEpisode(ActiveUser.ACTIVE_USER.getId());
		String showId;
		int seasonNumber,episodeNumber;
		System.out.println(results.size());
		for(int i = 0; i < results.size() ; i++){
			episodeNumber = (int) results.get(i).get(0) -1;
			showId = (String)results.get(i).get(1);
			seasonNumber = (int) results.get(i).get(2) - 1;
			findShow(showId, shows).getSeasons().get(seasonNumber).getEpisodes()[episodeNumber].setStatus(EpisodeStatus.WATCHED);
		}
		
	}
	
	private static Show findShow(String id, ArrayList<Show> shows){
		for(int i = 0 ; i < shows.size() ; i++){
			if(shows.get(i).getID().equals(id)) return shows.get(i);
		}
		
		return null;
		
	}

	public static void changeEpisodeStatusToWatched(Episode episode) {
		if(episode==null) return;
		dao.setStatusToWatched(episode);
		
	}
	
}
