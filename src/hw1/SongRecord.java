/**
 * Tasfiya Mubasshira
 * 114870281
 * CSE 214 sec 7
 * @author Tasfiya Mubasshira
 */
/**
 * This class defines the SongRecord Object which records the characteristics associated with a song.
 * This class implements the cloneable interface to make cloning in the Playlist class easier.
 */
package hw1;

public class SongRecord implements Cloneable{
	
	private String title;
	private String artist;
	private int min;
	private int sec;
	
	/**
	 * This is the default constructor for the SongRecord Object with no parameters.
	 */
	
	public SongRecord() {
		
	}
	
	
	/**
	 * This is the Constructor which creates an instance of the SongRecord Object
	 * with <code>t</code> , <code>a</code> , <code>m</code> ,and <code>s</code>
	 * @param t String value that holds the title of the song record
	 * @param a String value that holds the artist of the song record
	 * @param m integer(int) value that holds the length of the song in minutes
	 * @param s integer(int) value that holds the length of the song in minutes
	 */
	public SongRecord(String t, String a, int m, int s) {
		title=t;
		artist=a;
		min=m;
		sec=s;
	}
	
	
	/**
	 * Accessor/Getter method for getting the title of the song record
	 * @return it returns the title of the song record as a String
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Mutator/Setter method to set the title of a song Record as a String
	 * @param t represents the String that will be set as the title of the song record
	 */
	public void setTitle(String t) {
		title=t;
	}
	
	/**
	 * Accessor/Getter method for getting the artist of the song record
	 * @return it returns the artist of the song record as a String
	 */
	public String getArtist() {
		return artist;
	}
	
	/**
	 * Mutator/Setter method to set the artist of a song Record as a String
	 * @param a represents the String that will be set as the artist of the song record
	 */
	public void setArtist(String a) {
		artist=a;
	}
	
	/**
	 * Accessor/Getter method for getting the length of the song record in minutes
	 * @return it returns the length of the song record in minutes, as an integer(int)
	 */
	public int getMin() {
		return min;
	}
	
	/**
	 * Mutator/Setter method to set the length of a song Record in minutes as an integer(int)
	 * @param m represents the integer(int) that will be set as the length of the song record in minutes
	 * @throws Exception This exception is thrown if the value of the minutes being set is negative as minutes can only be positive.
	 */
	public void setMin(int m) throws IncorrectMinutesException {
		if (m<0) {
			throw new IncorrectMinutesException ();
		}
		
		min=m;
		
	}
	
	/**
	 * Accessor/Getter method for getting the length of the song record in second leftover after the minutes
	 * @return it returns the seconds of the song record as an integer(int)
	 */
	public int getSec() {
		return sec;
	}
	
	/**
	 * Mutator/Setter method to set the length of a song Record in seconds as an integer(int)
	 * @param s represents the integer(int) that will be set as the length of the song record in seconds
	 * @throws Exception This exception is thrown if the value of the seconds being set is negative or more than 59 as seconds can only range from 0 to 59 before it beccomes a minute
	 */
	public void setSec(int s) throws IncorrectSecondsException {
		if (s<0 || s>59) {
			throw new IncorrectSecondsException();
		}
		
		sec=s;
		
	}
	
	
	/**
	 * This method compares if a Song Record is the same/equivalent to another
	 * @param obj This is the object being compared to see if it is equivalent to the SongRecord Object
	 * @return It returns true if the object is equivalent to the SongRecord and False if it isn't or if the object is not instantiated
	 */
	public boolean equals(Object obj) {
		if (obj==null) {
			return false;
		}
		if (obj instanceof SongRecord) {
			SongRecord songRecord = (SongRecord) obj;
			return songRecord.title.equals(this.title) && songRecord.artist.equals(this.artist) && songRecord.min==this.min && songRecord.sec==this.sec;
			
		}
	return false;
	}
	
	
	/** This method makes a copy of the SongRecord object which is used as a helper method for the clone method in the Playlist class
	 * @return It returns a SongRecord object as a copy
	 */
	public Object clone() {
		SongRecord record=new SongRecord();
		record.artist=this.artist;
		record.title=this.title;
		record.min=this.min;
		record.sec=this.sec;
		return record;
		
	}
	
	/**
	 * This method prints out all the characteristics associated with a SongRecord in the form of a String
	 * @return It returns a String including the title, artist, and length (in minutes and seconds) of a SondRecord
	 */
	public String toString() {
		String temp= "";
		temp+= "title: " + getTitle() + "     artist: " + getArtist() + "     Minutes: " + getMin() + "     Seconds: " + getSec();
		return temp;
	}
	
}

/**
* 
* @author Tasfiya Mubasshira
* This class was created for the exception thrown when an Invalid number of Seconds are inputed. Seconds have to be between 0 and 59.
*
*/
class IncorrectSecondsException extends Exception{
	
	IncorrectSecondsException(){
		
	}
	IncorrectSecondsException(String s){
		super(s);
		System.out.println(s);
	}
}


/**
 * 
 * @author Tasfiya Mubasshira
 * This class was created for the exception thrown when an Invalid numbe of minutes is inputed. Minutes cannot be negative.
 *
 */
class IncorrectMinutesException extends Exception{
	
	IncorrectMinutesException(){
		
	}
	IncorrectMinutesException(String s){
		super(s);
		System.out.println(s);
	}
}



