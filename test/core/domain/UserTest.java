package core.domain;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserTest {

	User testObj;
	
	@Rule
	  public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		testObj = new User("username",1);
	}

	@Test
	public void addShowTest() {
		Assert.assertEquals(0, testObj.getShows().size());
		
		testObj.addShow(new Show());
		Assert.assertEquals(1, testObj.getShows().size());
		
		testObj.addShow(new Show());
		Assert.assertEquals(2, testObj.getShows().size());
		
	}

	@Test
	public void setIdStringTest(){
		testObj.setId("2");
		Assert.assertEquals(2, testObj.getId());
	}	
	
	@Test
	public void setIdStringTestFail(){
		exception.expect(NumberFormatException.class);
		testObj.setId("two");	
	}
}
