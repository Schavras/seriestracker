use stdb;

-- the tables of the users
CREATE TABLE users (
	user_id int PRIMARY KEY AUTO_INCREMENT,
	user_username VARCHAR(20),
	user_password BLOB,
	user_email VARCHAR(20)
);

-- The table of the shows.
CREATE TABLE shows(
	show_id VARCHAR(20) PRIMARY KEY,
	show_name VARCHAR(20)
);


-- The table of the episodes.
CREATE TABLE episode(
	episode_id VARCHAR(20) PRIMARY KEY,
	episode_number INT,
	episode_name VARCHAR(100),
    season_number INT,
    show_id VARCHAR(20),
    
    FOREIGN KEY fk_show(show_id)
	REFERENCES shows(show_id)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
);

CREATE TABLE user_show(
	user_id INT,
	show_id VARCHAR(20),
	-- last_active DATE,
    
	FOREIGN KEY fk_user(user_id)
	REFERENCES users(user_id)
	ON UPDATE CASCADE
	ON DELETE RESTRICT,
	
	FOREIGN KEY fk_show(show_id)
	REFERENCES shows(show_id)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
);

CREATE TABLE user_episode (
	episode_id VARCHAR(20),
	user_id int,

	FOREIGN KEY fk_user(user_id)
	REFERENCES users(user_id)
	ON UPDATE CASCADE
	ON DELETE RESTRICT,
	
	FOREIGN KEY fk_episode(episode_id)
	REFERENCES episode(episode_id)
	ON UPDATE CASCADE
	ON DELETE RESTRICT
);