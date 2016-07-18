package core.types;

/**
 * The status of the episode. 
 * Can be {@code ANNOUNCED} , for episodes that havent released yet, {@code RELEASED} for realeased episode
 * which have not been watched yet, and {@code WATCHED} for episodes that the user have seen, or {@code UNKNOWN} otherwise.
 * @author Stavros Zarpas
 * @since 1.0
 */
public enum EpisodeStatus {

	/**
	 * Default, unknown status.
	 */
	UNKNOWN,
	
	/**
	 * Episodes that havent released yet.
	 */
	ANNOUNCED,
	
	/**
	 *  Realeased episode which have not been watched yet.
	 */
	RELEASED,
	
	/**
	 * The episodes that the user have seen.
	 */
	WATCHED
}
