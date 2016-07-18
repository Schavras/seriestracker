	/**
 * 
 */
package core.domain.info;

import org.junit.Assert;
import org.junit.Test;

import core.types.SimplyDate;


/**
 * @author Stavros Zarpas
 * @since 
 */
public class EpisodeInfoTest {

	String string;
	String integer;
	String doubl;
	String date;
	
	
	EpisodeInfo testObj;
	
	@Test
	public void ConstructorTest() {
		string = "string";
		integer = "1";
		doubl = "1.2";
		date = "1 Jan 2000";
		testObj = new EpisodeInfo(string, integer, string, date, integer, integer, string, string, string, string, string, string, string, string, string, string, string, doubl, string, string, string, string, string, string);
		Assert.assertEquals("string", testObj.getTitle());
		Assert.assertEquals(1, testObj.getEpisode());
		Assert.assertEquals(new SimplyDate(1, 1, 2000),	 testObj.getReleased());
		Assert.assertEquals(1.2, testObj.getImdbrating(),0.0000001);
	}

}
