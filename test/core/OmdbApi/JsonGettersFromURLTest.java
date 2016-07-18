package core.OmdbApi;

import org.junit.Assert;
import org.junit.Test;

import core.OmdbApi.JsonGettersFromURL;

public class JsonGettersFromURLTest {
	
	@Test
	public void getJSONByImdbIDTest(){
		String actual = JsonGettersFromURL.getJSONByImdbID("tt1480055");
		 String str = "{" 
					+"\"Title\":\"Winter Is Coming\","
					+"\"Year\":\"2011\","
					+"\"Rated\":\"TV-MA\","
					+"\"Released\":\"17 Apr 2011\","
					+"\"Season\":\"1\","
					+"\"Episode\":\"1\","
					+"\"Runtime\":\"62 min\","
					+"\"Genre\":\"Adventure, Drama, Fantasy\","
					+"\"Director\":\"Timothy Van Patten\","
					+"\"Writer\":\"David Benioff (created by), D.B. Weiss (created by), George R.R. Martin (\\\"A Song of Ice and Fire\\\" by), David Benioff, D.B. Weiss\","
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
		 
		 Assert.assertEquals(str, actual);
		 
	}

}
