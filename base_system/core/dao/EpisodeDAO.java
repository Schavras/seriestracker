package core.dao;

import java.util.ArrayList;

import core.domain.Episode;
import core.domain.User;
import core.types.EpisodeStatus;

/**
 *  The data access object for handling the episodes.
 * @author Stavros Zarpas
 * @since 1.0
 */
public interface EpisodeDAO {
	
	/**
	 * Loads all the episodes of current season
	 * for active user.
	 * @param user
	 */
	public void loadSeasonEpisodes();
	
	/**
	 * Returns an {@link ArrayList} of all episodes
	 * of the current season
	 * @param showId The imdb id.
	 * @param seasonNumber The number of season.
	 * @return All episodes of season.
	 */
	public ArrayList<Episode> getEpisodesOfSeason(int showId, int seasonNumber, String user_id);
	
	/**
	 * Check if current episode is already stored.
	 * @param showId The imdb id.
	 * @param seasonNumber The number of season.
	 * @param episodeNumber The number of episode.
	 * @return true if stored, false otherwise.
	 */
	public boolean isStored(int showId, int seasonNumber , int episodeNumber);

	/**
	 * Update an episode based on the show, the season and episode number.
	 * Add the optional data.
	  @param showId The imdb id.
	 * @param seasonNumber The number of season.
	 * @param episodeNumber The number of episode.
	 * @return
	 */
	public Episode updateEpisode(int showId, int seasonNumber , int episodeNumber);

	public void addEpisode(Episode episode,int seasonNumber, String show_id);

	public void setStatusToWatched(Episode episode);

	public EpisodeStatus getStatus(int user_id, String episode_id);

	public ArrayList getWatchedEpisode(int user_id);
	
	/**
	 * Get all episodes of a specific user
	 * @param user
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList getEpisodesByUser(User user);
}
