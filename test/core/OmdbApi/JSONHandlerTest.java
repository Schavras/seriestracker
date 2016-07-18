package core.OmdbApi;

import org.junit.Assert;
import org.junit.Test;

import core.OmdbApi.JSONHandler;
import core.domain.Episode;
import core.domain.Season;
import core.domain.Show;
import core.imdb.IMDBSeason;
import core.types.SimplyDate;

public class JSONHandlerTest {
	
	String str="";
	String sresult;
	int iresult;
	
	@Test
	public void testEpisode(){
		Episode episode;
		
		 str = "{" 
				+"\"Title\":\"Winter Is Coming\","
				+"\"Year\":\"2011\","
				+"\"Rated\":\"TV-MA\","
				+"\"Released\":\"17 Apr 2011\","
				+"\"Season\":\"1\","
				+"\"Episode\":\"1\","
				+"\"Runtime\":\"62 min\","
				+"\"Genre\":\"Adventure, Drama, Fantasy\","
				+"\"Director\":\"Timothy Van Patten\","
				+"\"Writer\":\"David Benioff (created by), D.B. Weiss (created by), George R.R. Martin (A Song of Ice and Fire by), David Benioff, D.B. Weiss\","
				+"\"Actors\":\"Sean Bean, Mark Addy, Nikolaj Coster-Waldau, Michelle Fairley\","
				+"\"Plot\":\"Jon Arryn, the Hand of the King, is dead. King Robert Baratheon plans to ask his oldest friend, Eddard Stark, to take Jon's place. Across the sea, Viserys Targaryen plans to wed his sister to a nomadic warlord in exchange for an army.\","
				+"\"Language\":\"English\","
				+"\"Country\":\"USA\","
				+"\"Awards\":\"N/A\","
				+"\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMTk5MDU3OTkzMF5BMl5BanBnXkFtZTcwOTc0ODg5NA@@._V1_SX300.jpg\","
				+"\"Metascore\":\"N/A\","
				+"\"imdbRating\":\"8.9\","
				+"\"imdbVotes\":\"15409\","
				+"\"imdbID\":\"tt1480055\","
				+"\"seriesID\":\"tt0944947\","
				+"\"Type\":\"episode\","
				+"\"Response\":\"True\""
			+"}";
				
		
				
		episode = JSONHandler.JSONToEpisode(str);
		sresult = episode.getID();
		Assert.assertEquals("tt1480055" , sresult);
		
		sresult = episode.getInfo().getTitle();
		Assert.assertEquals("Winter Is Coming" , sresult);

		sresult = episode.getInfo().getPlot();
		String expected="Jon Arryn, the Hand of the King, is dead. King Robert Baratheon plans to ask his oldest friend, Eddard Stark, to take Jon's place. Across the sea, Viserys Targaryen plans to wed his sister to a nomadic warlord in exchange for an army." ;
		Assert.assertEquals(expected, sresult );
		
		
		Assert.assertEquals(new SimplyDate(17,4,2011),episode.getInfo().getReleased());
		
		iresult = episode.getNumber();
		Assert.assertEquals(1 , iresult );
		
		double dresult = episode.getInfo().getImdbrating();
		Assert.assertEquals( 8.9, dresult,0.0005);
	}
	
	@Test
	public void testInvalidEpisode(){
		Episode episode;
		
		 str = "{\"Response\":\"False\",\"Error\":\"Incorrect IMDb ID.\"}";				
		episode = JSONHandler.JSONToEpisode(str);
		
		Assert.assertNull(episode);
	}
	
	
	@Test
	public void testShow(){
		String json = JsonGettersFromURL.getJSONByImdbID("tt2575988");
		Show show  = JSONHandler.getFullShow(json);
		
		 json = JsonGettersFromURL.getJSONByImdbID("tt0903747");
		 show  = JSONHandler.getFullShow(json);
	}
	
//	@Test
//	public void testSeason(){
//		String json = JsonGettersFromURL.getJSONSeasonByID("tt0903747", 1);
//		Season season = JSONHandler.JSONToSeason(json);
//		Assert.assertEquals(1, season.getNumber());
//		Assert.assertEquals(7, season.getTotalNumberOfEpisodes());
//		
//		Assert.assertEquals("Pilot", season.getEpisodes()[0].getTitle());
//		Assert.assertEquals(new SimplyDate(20, 01, 2008), season.getEpisodes()[0].getDateOfRelease());
//	}
	
}

