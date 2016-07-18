package core.dao;

import java.util.ArrayList;

import core.domain.Show;
import core.domain.User;


/**
 *  The data access object for handling the shows.
 * @author Stavros Zarpas
 * @since 1.0
 */
public interface ShowDAO {

	/**
	 * Returns an arrayList with all the shows of
	 * a specifix user.
	 * @param user The user to search.
	 * @return ArrayList of Shows
	 */
	ArrayList<Show> getShowsByUser(User user);
	
	
	Show getByID(String id);
	
	boolean exist(Show show);

	boolean addShow(Show show);
	
	void createShow(Show show);
}
