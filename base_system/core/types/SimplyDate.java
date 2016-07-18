/**
 * 
 */
package core.types;


import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Represent a date, without the time parametrs. Use specific day,month, and year,
 * and creates a date with all time paramentrs set to 0.
 * @author Stavros Zarpas
 * @since 1.0
 *
 */
public class SimplyDate extends Date {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7024642243811074393L;

	/**
	 * Represent the day of the month.
	 */
	private int day;
	
	/**
	 * Represent the month of the year.
	 */
	private int month;
	
	/**
	 * Represent the year.
	 */
	private int year;
	
	/**
	 * {@link Date} object with 00.00.00.00 time.
	 */
	@SuppressWarnings("unused")
	private Date date;
	
	/**
	 * Constractor. Creates new SimplyDate object
	 * with specific day, month and year
	 * @param day The day of the month.
	 * @param month The month of the year.
	 * @param year The year.
	 */
	public SimplyDate(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
		//remove time from date
		date = removeTime(year, month -1 , day);
	}
	
	/**
	 * Default Constractor. Creates new SimplyDate object
	 * with default day, month and year
	 * @param day The day of the month.
	 * @param month The month of the year.
	 * @param year The year.
	 */
	public SimplyDate(){
		this.day = 0;
		this.month = 0;
		this.year = 2000;
		//remove time from date
		date = removeTime(year, month , day);
	}
	
	/**
	 * Constractor for "DD "Month" YYYY" format,
	 * where Month = 3 first letter of month.
	 * @param str
	 */
	public SimplyDate(String str){
		StringTokenizer tokenizer = new StringTokenizer(str, " ");
		int tday,tmonth,tyear;
		String StrTemp;
		try{
			//day decode
			StrTemp  = tokenizer.nextToken();
			tday = Integer.parseInt(StrTemp);
	
			//month decode
			StrTemp  = tokenizer.nextToken();
			tmonth = Months.returnIntMonth(StrTemp);
			
			//year decode
			StrTemp  = tokenizer.nextToken();
			tyear = Integer.parseInt(StrTemp);
		}catch (NumberFormatException e){
			tokenizer = new StringTokenizer(str, "-");
			//year decode
			StrTemp  = tokenizer.nextToken();
			System.out.println(StrTemp);
			tyear = Integer.parseInt(StrTemp);
			
			//month decode
			StrTemp  = tokenizer.nextToken();
			tmonth = Integer.parseInt(StrTemp);
			
			
			//day decode
			StrTemp  = tokenizer.nextToken();
			tday = Integer.parseInt(StrTemp);
		}


		this.day = tday;
		this.month = tmonth;
		this.year = tyear;
		//remove time from date
		date = removeTime(year, month -1 , day);
	}
	
	
	/**
	 * Create a new Date with the given day,month and year,
	 * and sets time to 0.
	 * @param day The day of the month.
	 * @param month The month of the year.
	 * @param year The year.
	 * @return new Date with time set to 0.
	 */
	private Date removeTime(int day, int month, int year){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.YEAR, year);
	    cal.set(Calendar.HOUR_OF_DAY, 0);  
	    cal.set(Calendar.MINUTE, 0);  
	    cal.set(Calendar.SECOND, 0);  
	    cal.set(Calendar.MILLISECOND, 0);  
	    return cal.getTime(); 
	}


	/** 
	 * Use {@link day}, {@link month} , and {@link year}
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}


	/**
	 * Compare {@link day}, {@link month} , and {@link year}
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		SimplyDate other = (SimplyDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Return the date on DD/MM/YYYY format
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return day + "/" + month + "/" +year;
	}
	
	
	
	
}
