package core.domain;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.domain.Episode;
import core.domain.Season;
import core.types.EpisodeStatus;

/**
 * Tests the {@link Season} class.
 * @author Stavros Zarpas
 * @since 1.0
 *
 */
public class SeasonTest {

	/**
	 * First episode object
	 */
	Episode episode1;
	
	/**
	 * Second episode object
	 */
	Episode episode2;
	
	/**
	 * Third episode object
	 */
	Episode episode3;
	
	/**
	 * Array of episodes; 
	 */
	Episode[] episodes;
	
	/**
	 * The testing object.
	 */
	Season testObject;
	
	/**
	 * Logical result.
	 */
	boolean result;
	
	@Before
	public void setUp(){
		episode1= new Episode("first");
		episode2= new Episode("second");
		episode3= new Episode("third");
		episodes = new  Episode[2];
		episodes[0] = episode1 ;
		episodes[1] = episode2 ;
		testObject = new Season( 1, 2, episodes, false);
	}
	
	
	/**
	 * Test {@link Season#getSpecificEpisode(int) getSpecificEpisode(int)} method
	 * Success return.
	 */
	@Test
	public void getSpecificSuccessTest(){
		Episode actual = testObject.getSpecificEpisode(1);
		Episode expected = new Episode("first");
		Assert.assertEquals( expected, actual);
		actual = testObject.getSpecificEpisode(2);
		expected = new Episode( "second");
		Assert.assertEquals( expected, actual);
	}
	
	/**
	 * Test {@link Season#getSpecificEpisode(int) getSpecificEpisode(int)} method
	 * Negative number test.
	 */
	@Test
	public void getSpecificNegativeTest(){
		Episode	actual = testObject.getSpecificEpisode(-1);
		Assert.assertNull(actual);
		
	//Greater number test.
		actual = testObject.getSpecificEpisode(3);
		Assert.assertNull(actual);
	}
	
	/**
	 * Test {@link Season#getSpecificEpisode(int) getSpecificEpisode(int)} method
	 * Greater number test.
	 */
	@Test
	public void getSpecificGreaterTest(){
		Episode actual = testObject.getSpecificEpisode(3);
		Assert.assertNull(actual);
	}
	
	/**
	 *  Test that the arrays have been correct created.	
	 */
	@Test
	public void ArrayTest(){
		Assert.assertEquals(2, testObject.getTotalNumberOfEpisodes());
		Assert.assertEquals(2, testObject.getEpisodes().length);
	}
	
	/**
	 * Test {@link Season#resize(int) resize(int)} method.
	 * Greater number test.
	 */
	@Test
	public void resizeGreateTest(){
		testObject.resize(3);
		Assert.assertEquals(3, testObject.getTotalNumberOfEpisodes());
		Assert.assertEquals(3, testObject.getEpisodes().length);
		Assert.assertEquals(testObject.getSpecificEpisode(1),new Episode("first"));
		Assert.assertEquals(testObject.getSpecificEpisode(2),new Episode("second"));
		Assert.assertNull(testObject.getSpecificEpisode(3));
	
	}
	
	/**
	 * Test {@link Season#resize(int) resize(int)} method.
	 * Smaller number test.
	 */
	@Test
	public void resizeSmallerTest(){
		testObject.resize(1);
		Assert.assertEquals(1, testObject.getTotalNumberOfEpisodes());
		Assert.assertEquals(1, testObject.getEpisodes().length);
		Episode actual = new Episode( "first");
		Assert.assertEquals(testObject.getSpecificEpisode(1), actual);
	}
	
	/**
	 * Test {@link Season#resize(int) resize(int)} method.
	 * Zero  test.
	 */
	@Test
	public void resizeZeroTest(){
		testObject.resize(0);
		Assert.assertEquals(0, testObject.getTotalNumberOfEpisodes());
		Assert.assertEquals(0, testObject.getEpisodes().length);
	}
	
	/**
	 * Test {@link Season#resize(int) resize(int)} method.
	 * Negative number test.
	 */
	@Test
	public void resizeNegativeTest(){
		testObject.resize(-1);
		Assert.assertEquals(0, testObject.getTotalNumberOfEpisodes());
		Assert.assertEquals(0, testObject.getEpisodes().length);
	}

	/**
	 * Test {@link Season#updateEpisode(Episode) updateEpisode(Episode)} method.
	 *  Test the negative number
	 */
	@Test
	public void updateNegativeTest(){
		episode3.setNumber(-1);
		result = testObject.updateEpisode(episode3);
		Assert.assertFalse(result);
	}
	
	/**
	 * Test {@link Season#updateEpisode(Episode) updateEpisode(Episode)} method.
	 *  Test the existing number
	 */
	@Test
	public void updateExistingTest(){
		episode3.setNumber(1);
		result = testObject.updateEpisode(episode3);
		Assert.assertTrue(result);
		Assert.assertEquals(testObject.getSpecificEpisode(1), episode3);
	}
	
	/**
	 * Test {@link Season#updateEpisode(Episode) updateEpisode(Episode)} method.
	 *  Test the greater number
	 */
	@Test
	public void updateGreaterTest(){
		episode3.setNumber(4);
		result = testObject.updateEpisode(episode3);
		Assert.assertTrue(result);
		Assert.assertEquals(testObject.getSpecificEpisode(4), episode3);
		Assert.assertEquals(testObject.getSpecificEpisode(1), episode1);
		Assert.assertNull(testObject.getSpecificEpisode(3));
	}
	
	/**
	 * Tests {@link Season#checkCompleted() checkCompleted()} method,
	 * when the season is completed.
	 */
	@Test
	public void checkCompleteTrueTest(){
		episodes[0].setStatus(EpisodeStatus.WATCHED);
		episodes[1].setStatus(EpisodeStatus.WATCHED);
		
		result = testObject.checkCompleted();
		Assert.assertTrue(result);
		
		result = testObject.checkCompleted();
		Assert.assertTrue(result);
	}
	
	/**
	 * Tests {@link Season#checkCompleted() checkCompleted()} method,
	 * when the season is not completed.
	 */
	@Test
	public void checkCompleteFalseTest(){
		episodes[0].setStatus(EpisodeStatus.WATCHED);
		episodes[1].setStatus(EpisodeStatus.RELEASED);
		
		result = testObject.checkCompleted();
		Assert.assertFalse(result);
	}
	
	/**
	 * Tests {@link Season#getNextEpisode() getNextEpisode()} method,
	 * when there is a unwatced episode.
	 */
	@Test
	public void nextEpisodeTest(){
		episodes[0].setStatus(EpisodeStatus.WATCHED);
		episodes[1].setStatus(EpisodeStatus.RELEASED);
		Episode next = new Episode("second");
		Episode result = testObject.getNextEpisode();
		
		Assert.assertEquals(next, result);
	}
	
	/**
	 * Tests {@link Season#getNextEpisode() getNextEpisode()} method,
	 * when there is not a unwatced episode.
	 */
	@Test
	public void nextEpisodeTestFailed(){
		episodes[0].setStatus(EpisodeStatus.WATCHED);
		episodes[1].setStatus(EpisodeStatus.WATCHED);
		Episode result = testObject.getNextEpisode();
		
		Assert.assertNull(result);
	}
	
	/**
	 * Tests {@link Season#setEpisodes(java.util.ArrayList) setEpisodes(java.util.ArrayList <Episode> ) } method.
	 */
	@Test
	public void setEpisodesArrayTest(){
		ArrayList<Episode> arrayEpisodes = new ArrayList<Episode>();
		arrayEpisodes.add(episodes[0]);
		testObject.setEpisodes(arrayEpisodes);
		
		Assert.assertEquals(1, testObject.getTotalNumberOfEpisodes());
		Assert.assertEquals(episodes[0], testObject.getEpisodes()[0]);
	}
	
}
