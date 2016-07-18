/**
 * 
 */
package core.domain;

import java.util.ArrayList;

/**
 * Holds the data of the user of the desktop app.
 * @author John Zachariadis
 * @since 
 */
public class User {
	
	private int id;
	@SuppressWarnings("unused")
	private String email;
	private String username;	
	private ArrayList<Show> shows;
	
	
	//----------------------------Constructors----------
	/**
	 * Default constructor.
	 */
	public User(){
		username = "user";
		shows = new ArrayList<Show>();
	}
	
	/**
	 * Constructor for User. 	
	 * @param username 	username String for login
	 */
	public User(String username, int id){
		this.id = id;
		this.username = username;
		shows = new ArrayList<Show>();
	}
	
	//--------------------------Custom Method-----
	

	/**
	 * Adds a new {@link Show} in the ArrayList
	 * @param show
	 * @return
	 */
	public boolean addShow(Show show){
		return shows.add(show);
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) throws NumberFormatException {
		try{
			this.id = Integer.parseInt(id);
		}catch(NumberFormatException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	// -----------------------------Getters-------
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	// -------------------------------Setters--------

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public void setShows(ArrayList<Show> shows){
		this.shows=shows;
	}
	
	//-----------------------Getters-----------------
	
	/**
	 * Used to check username.
	 * @return	the username of the user.
	 */
	public String getName(){
		return username;
	}
	
	/**
	 * Returns all shows of the user
	 * @return the shows
	 */
	public ArrayList<Show> getShows() {
		return shows;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "#" + id + " " + username;
	}
	
	
}
