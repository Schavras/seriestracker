package core.dao;

import core.domain.User;


/**
 *  The data access object for handling the users.
 * @author Stavros Zarpas
 * @since 1.0
 */
public interface UserDAO {
	
	/**
	 * Login on system, based on username and password.
	 * If one of this is wrong, return null.
	 * @param username The username of the user.
	 * @param password The password of the user.
	 * @return The user with this username
	 */
	User login(String username, String password);

	/**
	 * Finds the user based on his username.
	 * @param username The username of the user.
	 * @return 
	 */
	User getUserByUserame(String username);
	
	
	
	/**
	 * Register a new user, if username is not already in use.
	 * @param user
	 * @return true if succeded, false otherwise.
	 */
	boolean newUser(String username, String password, String email);
}
