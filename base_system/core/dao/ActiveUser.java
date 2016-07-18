package core.dao;

import core.domain.User;

public class ActiveUser {
	
	public static User ACTIVE_USER=null;
	
	
	public ActiveUser(User user){
		ACTIVE_USER=user;
	}
}
