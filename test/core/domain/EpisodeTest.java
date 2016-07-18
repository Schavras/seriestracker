package core.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.domain.Episode;

/**
 * Tests the {@link Episode} class.
 * @author Stavros Zarpas
 * @since 1.0
 *
 */
public class EpisodeTest {
	
	/**
	 * Test objest
	 */
	Episode testEpisode1;
	
	/**
	 * Success/failed result.
	 */
	boolean result;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testEpisode1=new Episode();
	}

	/**
	 * Test most cases of {@link Episode#equals(Object) equals} method.
	 */
	@Test
	public void testEquals() {
		Episode testEpisode2  = new Episode();
		
		//Test default constructors
		result = testEpisode1.equals(testEpisode2); 
		Assert.assertTrue(result);
		
		//Test with null
		result = testEpisode1.equals(null);
		Assert.assertFalse(result);
		
		
		//Test by episode number
		
		//  Different id
		testEpisode1  = new Episode("1");
		testEpisode2  = new Episode("2");
		result = testEpisode1.equals(testEpisode2);
		Assert.assertFalse(result);
		//  Same id
		testEpisode1  = new Episode("1");
		testEpisode2  = new Episode("1");
		result = testEpisode1.equals(testEpisode2);
		Assert.assertTrue(result);
		
	}
	
}
