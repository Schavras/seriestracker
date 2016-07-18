package presenter;

import java.awt.image.BufferedImage;

import core.OmdbApi.JSONHandler;
import core.OmdbApi.JsonGettersFromURL;
import core.dao.ActiveUser;
import core.dao.EpisodeDAO;
import core.dao.ShowDAO;
import core.databaseDAO.EpisdeDAOMysql;
import core.databaseDAO.InitializeConnection;
import core.databaseDAO.ShowDAOMysql;
import core.domain.Show;
import core.imdb.IMDBShow;
import core.services.ShowManager;
import core.types.Poster;
import ui.views.AddNewShowView;

public class AddNewShowPresenter {
	
	AddNewShowView view;
	ShowDAO dao;
	EpisodeDAO eDao;
	Show show;
	
	protected AddNewShowPresenter(AddNewShowView view, ShowDAO dao){
		this.view= view;
		this.dao=dao;
	}
	
	public AddNewShowPresenter(AddNewShowView view){
		this.view= view;
		dao = new ShowDAOMysql(InitializeConnection.getConnection());
		eDao = new EpisdeDAOMysql(InitializeConnection.getConnection());
	}
	
	public boolean searchById(String id){
		String json = JsonGettersFromURL.getJSONByImdbID(id);
		show  = JSONHandler.getFullShow(json);
		if(show != null){
			return true;
		}else{
			return false;
		}
	}
	
	public String showName(){
		if(show!=null) return show.getInfo().getTitle();
		return "";
	}
	
	public BufferedImage showPoster(){
		if(show!=null) return Poster.getPoster(show.getInfo().getPoster(),240 , 400);
		return null;
	}
	
	public void addShow(){
		Show temp = show;
		
		if(!dao.addShow(temp)){
			
			ShowManager.createShow(temp);
		}
		
		
	}
	
	public void start(){
		view.setAddNewShowPresenter(this);
		view.open();
		ShowManager.loadAllShows(ActiveUser.ACTIVE_USER);
	}
	
	
}
