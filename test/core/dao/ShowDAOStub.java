package core.dao;

import java.util.ArrayList;

import core.domain.Show;
import core.domain.User;
import core.domain.Season;;

public class ShowDAOStub implements ShowDAO {

	@Override
	public ArrayList<Show> getShowsByUser(User user) {
		ArrayList<Show> shows = new ArrayList<Show>();
		shows.add(new Show("id1", "show1", new ArrayList<Season>()));
		shows.add(new Show("id2", "show2", new ArrayList<Season>()));
		return shows;
	}

	@Override
	public Show getByID(String id) {
		return new Show(id, "show", new ArrayList<Season>());
	}

	@Override
	public boolean addShow(Show show) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exist(Show show) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createShow(Show show) {
		// TODO Auto-generated method stub
		
	}

}
