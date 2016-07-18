package core.types;


import org.junit.Assert;
import org.junit.Test;

import core.types.Months;

/**
 * Tests the {@link Months} enum.
 * @author Stavros Zarpas
 * @since 1.0
 *
 */
public class MonthsTest {
	
	@Test
	public void getMonthTest(){
		int expected = 1;
		int actual = Months.returnIntMonth("Jan");
		Assert.assertEquals(expected, actual);
		 expected = 2;
		 actual = Months.returnIntMonth("Feb");
		Assert.assertEquals(expected, actual);
		 expected = 3;
		 actual = Months.returnIntMonth("Mar");
		Assert.assertEquals(expected, actual);
		 expected = 4;
		 actual = Months.returnIntMonth("Apr");
		Assert.assertEquals(expected, actual);
		 expected = 5;
		 actual = Months.returnIntMonth("May");
		Assert.assertEquals(expected, actual);
		 expected = 6;
		 actual = Months.returnIntMonth("Jun");
		Assert.assertEquals(expected, actual);
		 expected = 7;
		 actual = Months.returnIntMonth("Jul");
		Assert.assertEquals(expected, actual);
		 expected = 8;
		 actual = Months.returnIntMonth("Aug");
		Assert.assertEquals(expected, actual);
		 expected = 9;
		 actual = Months.returnIntMonth("Sem");
		Assert.assertEquals(expected, actual);
		 expected = 10;
		 actual = Months.returnIntMonth("Oct");
		Assert.assertEquals(expected, actual);
		 expected = 11;
		 actual = Months.returnIntMonth("Nov");
		Assert.assertEquals(expected, actual);
		 expected = 12;
		 actual = Months.returnIntMonth("Dec");
		Assert.assertEquals(expected, actual);
		
		
		
	}
	
	
}