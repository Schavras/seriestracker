package core.types;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.types.SimplyDate;

/**
 * Tests the {@link SimplyDate} class.
 * @author Stavros Zarpas
 * @since 1.0
 *
 */
public class SimplyDateTest {
	
	int day;
	int month;
	int year;
	
	SimplyDate date1;
	SimplyDate date2;
	
	@Before
	public void setUp(){
		date1 = new SimplyDate(1,1,2016);
	}
	
	@Test
	public void sameDateEqualsTest(){
		date1 = new SimplyDate(1,1,2016);
		date2 = new SimplyDate(1,1,2016);
		Assert.assertEquals(date1, date2);
	}
	
	@Test
	public void differentDayEqualsTest(){
		date1 = new SimplyDate(1,1,2016);
		date2 = new SimplyDate(2,1,2016);
		Assert.assertNotEquals(date1, date2);
	}
	
	@Test
	public void differentMonthEqualsTest(){
		date1 = new SimplyDate(1,1,2016);
		date2 = new SimplyDate(1,2,2016);
		Assert.assertNotEquals(date1, date2);
	}
	
	@Test
	public void differentYearEqualsTest(){
		date1 = new SimplyDate(1,1,2016);
		date2 = new SimplyDate(1,1,2017);
		Assert.assertNotEquals(date1, date2);
	}
	
	@Test
	public void testGetters(){
		day = date1.getDay();
		Assert.assertEquals(1, day);
		
		month = date1.getMonth();
		Assert.assertEquals(1, month);
		
		year = date1.getYear();
		Assert.assertEquals(2016, year);
				
	}
	
	@Test
	public void DateParseStringTest(){
		String str = "17 Apr 2011";
		date1 = new SimplyDate(str);
		
		day = date1.getDay();
		Assert.assertEquals(17, day);
		
		month = date1.getMonth();
		Assert.assertEquals(4, month);
		
		year = date1.getYear();
		Assert.assertEquals(2011, year);
		
		date2 = new SimplyDate(17,4,2011);
		Assert.assertEquals(date1, date2);
	}
	
	@Test
	public void DateParseStringNumberFormatTest(){
		String str = "2008-01-20";
		date1 = new SimplyDate(str);
		
		day = date1.getDay();
		Assert.assertEquals(20, day);
		
		month = date1.getMonth();
		Assert.assertEquals(1, month);
		
		year = date1.getYear();
		Assert.assertEquals(2008, year);
		
		date2 = new SimplyDate(20,1,2008);
		Assert.assertEquals(date1, date2);
	}
	
	

}