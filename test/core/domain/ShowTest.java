package core.domain;

import java.util.ArrayList;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.types.EpisodeStatus;

public class ShowTest {

	Show testObj;
	Season testSeason1;
	Season testSeason2;
	Episode testEpisode1;
	Episode testEpisode2;
	Episode[] episodes;
	ArrayList<Season> seasons;
	
	@Before
	public void setUp() throws Exception {
		testEpisode1 = new Episode("first");
		testEpisode2 = new Episode("second");
		
		testEpisode1.setStatus(EpisodeStatus.WATCHED);
		testEpisode2.setStatus(EpisodeStatus.WATCHED);
		
		episodes = new Episode[2];
		episodes[0] = testEpisode1;
		episodes[1] = testEpisode2;
		
		testSeason1 = new Season( 1, 2, episodes, true);
		
		episodes[0].setStatus(EpisodeStatus.RELEASED);
		
		testSeason2 = new Season( 2, 2, episodes, false);
		
		seasons = new ArrayList<Season>();
		seasons.add(testSeason1);
		seasons.add(testSeason2);	
		
		testObj = new Show("test");
		testObj.setSeasons(seasons);
	}

	@Test
	public void testGetFirstUnseen() {
		Episode expected = new Episode("first");
		Episode actual = testObj.getFirstUnseen();
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void testNullGetFirstUnseen() {
		testObj.getSeasons().get(1).getEpisodes()[0].setStatus(EpisodeStatus.WATCHED);
		Episode actual = testObj.getFirstUnseen();
		Assert.assertNull(actual);
		
	}
	
	@Test
	public void setNextSeenTest (){
		testObj.setNextSeen();
		EpisodeStatus result = testObj.getSeasons().get(1).getEpisodes()[1].getStatus();
		Assert.assertEquals(result, EpisodeStatus.WATCHED);
	}
	
	@Test
	public void setNextSeenTestNoNext (){
		testObj.getSeasons().get(1).getEpisodes()[0].setStatus(EpisodeStatus.WATCHED);
		testObj.setNextSeen();
		EpisodeStatus result = testObj.getSeasons().get(1).getEpisodes()[1].getStatus();
		Assert.assertEquals(result, EpisodeStatus.WATCHED);
	}
	

	
}
