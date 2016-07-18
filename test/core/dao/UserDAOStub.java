package core.dao;

import core.domain.User;

public class UserDAOStub implements UserDAO {

	
	
	@Override
	public User getUserByUserame(String username) {
		switch(username){
		case "username" : return new User("username",1);
		default: return null;
		}
		
	}

	

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean newUser(String username, String password, String email) {
		// TODO Auto-generated method stub
		return true;
	}

}
