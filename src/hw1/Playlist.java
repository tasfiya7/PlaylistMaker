/**
 * Tasfiya Mubasshira
 * 114870281
 * CSE 214 sec 7
 * @author Tasfiya Mubasshira
 * 
 * The Playlist class is used to create a Playlist type object. This class can contain up to 50 SongRecord Objects 
 * 
 */

package hw1;


public class Playlist extends SongRecord implements Cloneable {
	
	private SongRecord [] songs; // Array of SongRecords
	private final static int MAX_SONGS=50; // Maximum number of Song Records the songs array can hold
	private int itemsInPlaylist=0; // number of SongRecords in the songs array
	
	
/**
 * 	Constucts a Playlist Object with an empty array of SongRecords that can hold up to 50 SongRecords
 */
 Playlist() {
	songs= new SongRecord[MAX_SONGS];
}
 
 

/**
 * This method makes a deep copy of the Playlist object 
 * @return It returns a Playlist object as a deep copy
 */
public Object clone() {
	
	Playlist playlistClone= new Playlist();
	SongRecord[] recordClone= new SongRecord[MAX_SONGS];
	for (int i=0; i<songs.length; i++) {
		if(songs[i] != null) {
			
			recordClone[i]= (SongRecord) this.songs[i].clone();
		}
		
	}
	playlistClone.songs= recordClone;
	playlistClone.itemsInPlaylist= (int) this.itemsInPlaylist;
	
	return playlistClone;
}


/**
 * This method compares if a Playlist object is the same/equivalent to another Playlist
 * @param obj This is the object being compared to see if it is equivalent to the Playlist Object
 * @return It returns true if the object is equivalent to the Playlist and false if it isn't or if the object is not instantiated
	 
 */
public boolean equals (Object obj) {
	if (obj==null){
		return false;
	}
	
	if (obj instanceof Playlist) {
		Playlist p = (Playlist)obj;
		if(this.itemsInPlaylist != p.itemsInPlaylist) {
			return false;
		}
		for (int i=0; i< songs.length;i++) {
			if(!p.songs[i].equals(this.songs[i])){
				return false;
			}
			else {
				return true;
			
			}
		}
	}
		return false;
	}

	
/**
 * This method returns the number of SongRecords in the Playlist
 * @return items which is the variable that counts the Song Records in the Playlist
 */
public int size() {
	return itemsInPlaylist;
}

/**
 * This method adds SongRecords to the Playlist at a certain position. If the position is already occupied the other SongRecords starting from that position will be shifted to right of the array
 * which would mean they come later in the Playlist
 * @param s This is the Song that is to be place in a position
 * @param position This is the position the Song Record will be placed
 * @throws IllegalArgumentException This exception is thrown if the the position given is below 1 as the position on a Playlist can't be before the first ever position. 
 * This exception is also thrown if the position is greater than 1 more than the current amount of SongRecords as there can't be gaps between the SongRecord positions
 * @throws FullPlaylistException This exception is thrown if the Playlist has already reached its capacity so no more SongRecords can be added
 */
public void addSong(SongRecord s, int position) throws IllegalArgumentException, FullPlaylistException {
	

	
	if (s!=null) {
	
	
	
	if (itemsInPlaylist==MAX_SONGS) {
		throw new FullPlaylistException("The Playlist is full. There is no more room to add a song");
	}
	
	if (position <1 || position> (itemsInPlaylist +1)) {
		throw new IllegalArgumentException("This is not a valid position");
	}
	
		
	for (int i=itemsInPlaylist; i>position-1;i--) {
		songs[i]=songs[i-1];
		i--;
	}
	songs[position-1]=s;
	itemsInPlaylist++;
	
	}
	
}

/**
 * This method removes SongRecords from the Playlist at a certain position. The other SongRecords starting from that position will be shifted to left of the array
 * which would mean they come earlier in the Playlist
 * @param position This is position of the SongREcord that would be removed from the Playlist
 * @throws IllegalArgumentException This exception is thrown if the position in the parameter is less than 1 as there is no SongRecords before the first position.
 * This exception is also throw when the position is greater than the current number of SongRecords in the Playlist as there would not be any SongRecords in that position to be removed.
 */
public void removeSong(int position) throws IllegalArgumentException{
	


	if(position < 1 || position > itemsInPlaylist) {

	throw new IllegalArgumentException();
	}
	

	for(int i = position-1; i < itemsInPlaylist+1; i++) {


	songs[i] = songs[i+1];
	}


	itemsInPlaylist--;
	


	
}
		

/**
 * This method returns SongRecord in a given position
 * @param position This is the position of the SOngRecord in the Playlist that is to be returned.
 * @return It returns a SongRecord at desired position.
 * @throws IllegalArgumentException This exception is thrown if the position is less than 1 as there are no SongRecords before the first position.
 * This exception is also thrown if the position is greater than the number of songs in the playlist as you can't return a SongRecord from a position in the PLaylist that has not been filled yet
 */
public SongRecord getSong(int position) throws IllegalArgumentException {
	
	

	if(position < 1 || position > itemsInPlaylist)

		throw new IllegalArgumentException();
	
	
	return songs[position-1];
}




/**
 * This method prints all the SongRecords that  are in a Playlist in a formatted table, including the SongRecords's title, artist, and length
 */
public void printAllSongs() {
	
	System.out.println("...............................................................");
	System.out.printf("%-15s%-30s%-10s%-10s\n", "Song#", "Title", "Artist", "Length");
    for (int i = 0; i < itemsInPlaylist; i++) {
       if( songs[i]!= null) { 
        System.out.printf("%-15s%-30s%-10s%-10s", i+1, songs[i].getTitle(), songs[i].getArtist(), songs[i].getMin());
        System.out.print(":");
        if (songs[i].getSec()>=0 && songs[i].getSec()<10) {
        	System.out.println("0"+ songs[i].getSec());// formatting the seconds to reflect the proper amount of seconds if it is not double digits
        	
        }
        else {
        System.out.println(songs[i].getSec());
       }
       System.out.println();
       }
    }

	
}

/**
 * This method creates and returns a Playlist with SongRecords from the original Playlist that are all from the same artist, given the original Playlist and the artist as the parameter.
 * It all formats the SongRecords from the same artist in the same order they were in, in the original Playlist.
 * @param originalList This is the original Playlist from which songs from the same artist will be taken an put into a new Playlist
 * @param artist This is the artist that the SongRecords in the new Playlist will have in common
 * @return It returns a Playlist with SongRecords from the original Playlist with the same artist.
 */
public static Playlist getSongsByArtist(Playlist originalList, String artist) {
	
	Playlist artistPl= new Playlist();
	SongRecord[] artistSongs= new SongRecord[MAX_SONGS];
	int count=0;
	for (int i=0; i<originalList.songs.length; i++) {
		if(originalList.songs[i] != null) {
			
			if (originalList.songs[i].getArtist().equals(artist)){
				artistSongs[count]=originalList.songs[i];
				count++;
			}
			
		}
		
	}
		artistPl.songs= artistSongs;
		artistPl.itemsInPlaylist= count+1;
	
	return artistPl;
	
	
}


/**
 * This method prints/returns a formatted String containing all the SongRecords and it's title, artist, and length in a Playlist
 * @returns String formatted to represent the SongRecords and its infromation in a PLaylist
 */
public String toString() {
	
	System.out.println("...............................................................");
	System.out.printf("%-15s%-30s%-10s%-10s\n", "Song#", "Title", "Artist", "Length");
    for (int i = 0; i < itemsInPlaylist; i++) {
       if( songs[i]!= null) { 
        System.out.printf("%-15s%-30s%-10s%-10s", i+1, songs[i].getTitle(), songs[i].getArtist(), songs[i].getMin());
        System.out.print(":");
        if (songs[i].getSec()>=0 && songs[i].getSec()<10) {
        	System.out.println("0"+ songs[i].getSec());
        	
        }
        else {
        System.out.println(songs[i].getSec());
       }
       System.out.println();
       }
    }
    return null;
	
	
}




}




/**
 * 
 * @author Tasfiya Mubasshira
 * This class was created for the exception thrown when a Playlist is full and no more song can be added to it.
 *
 */
class FullPlaylistException extends Exception {
	
	FullPlaylistException(){
		
	}
	FullPlaylistException(String s){
		super(s);
		System.out.println(s);
	}
	
}









	

